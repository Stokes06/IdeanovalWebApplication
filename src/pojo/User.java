package pojo;

import java.util.Date;

public class User {

    public static int user_count = 0;
    private int id;
    private String login;
    private String password;
    private String pseudo;
    private Date registerDate;

    public User() {
    }
    public User(User u){
        setId(u.id);
        setLogin(u.login);
        setRegisterDate(u.registerDate);
        setPseudo(u.pseudo);
        setPassword(u.password);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pseudo != null ? pseudo.equals(user.pseudo) : user.pseudo == null;
    }
}
