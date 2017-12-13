package dao;

import db.DataConnect;
import pojo.Admin;
import pojo.Client;
import pojo.User;

import java.sql.*;
import java.util.Calendar;

public class UserDao {
    private Connection db;

    public UserDao() {
        db = DataConnect.getInstance();
    }

    public User getUserByLogin(String login) {

        try {

            PreparedStatement ps = db.prepareStatement("SELECT id_user FROM user WHERE login = ?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return getUserById(rs.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        //pas d'utilisateur trouvé pour ce login
        return null;
    }

    public User getUserById(int id) {

        User user = null;
        try {
            PreparedStatement ps = db.prepareStatement("SELECT  pseudo, login, registerDate FROM user WHERE id_user=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(id);
                user.setLogin(rs.getString("login"));
                user.setPseudo(rs.getString("pseudo"));
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(rs.getTimestamp("registerDate").getTime());
                user.setRegisterDate(c.getTime());

                Admin temp = getAdmin(user);
                if (temp != null) {
                    user = new Admin(user);
                } else {
                    user = getClient(user);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    private Admin getAdmin(User u) {
        try {
            PreparedStatement ps = db.prepareStatement("SELECT * FROM administrator WHERE id_user = ?");
            ps.setInt(1, u.getId());
            if (ps.executeQuery().next()) {
                return new Admin(u);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Client getClient(User u) {
        Client cli = new Client(u);
        try {
            PreparedStatement ps = db.prepareStatement("SELECT isValidated, isDeleted FROM client WHERE id_user=?");
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                cli.setDeleted(rs.getBoolean("isValidated"));
                cli.setValidated(rs.getBoolean("isDeleted"));
                return cli;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByPseudo(String pseudo) {

        try {

            PreparedStatement ps = db.prepareStatement("SELECT id_user FROM user WHERE pseudo = ?");
            ps.setString(1, pseudo);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return getUserById(rs.getInt("id_user"));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        //pas d'utilisateur trouvé pour ce pseudo
        return null;
    }

    public Client createClient(Client client) {
        try{
            client.setRegisterDate(new java.util.Date());

            PreparedStatement ps = db.prepareStatement("insert into user(login, pseudo, password, registerDate) value(?,?,md5(?), ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getLogin());
            ps.setString(2, client.getPseudo());
            ps.setString(3, client.getPassword());
            ps.setTimestamp(4,new Timestamp(client.getRegisterDate().getTime()));
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                client.setId(rs.getInt(1));

                ps = db.prepareStatement("insert into client(id_user, isDeleted, isValidated) VALUE(?,?,?)");
                ps.setInt(1, client.getId());
                ps.setBoolean(2, client.isValidated());
                ps.setBoolean(3, client.isDeleted());
                ps.execute();
                return client;
            }
        }catch (SQLException e){e.printStackTrace();}
        return null;
    }

    public User connectUser(String login, String password) {

        User user = null;
        try{
            PreparedStatement ps = db.prepareStatement("select id_user from user where login=? and password=md5(?)");
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                user = getUserById(rs.getInt("id_user"));

        }catch (SQLException e){e.printStackTrace();}
        return user;
    }
}
