package pojo;

public class Admin extends User {

    public Admin() {
    }

    public Admin(User u) {
        super(u);
    }

    public Admin(String login, String password, String pseudo) {
        super(login, password, pseudo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
