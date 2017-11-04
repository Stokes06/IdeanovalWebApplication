package db;

import java.sql.*;

public class Database {

    private static Connection db;
    private static String user = "root";
    private static String password = "";
    private static String database = "db_ideanoval";
    public static Connection getInstance() {
        if (db != null) return db;

        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver); // instancie le driver

            db = DriverManager.getConnection("jdbc:mysql://localhost/"+database, user, password);

            return db;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
          return null;
    }

    public static int getLastInsertId(){
        try{

            Connection db = getInstance();
            Statement st = db.createStatement();
            ResultSet rs =  st.executeQuery("select last_insert_id()");
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e){}
        return 0;
    }
}
