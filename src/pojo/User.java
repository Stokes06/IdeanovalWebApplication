package pojo;

import java.sql.Date;

public class User {

    public static int user_count = 0;
    private int id;
    private String login;
    private String password;
    private String pseudo;
    private Date registerDate;

    public User(String login, String password, String pseudo) {
        this.login = login;
        this.password = password;
        this.pseudo = pseudo;

        this.id = user_count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
