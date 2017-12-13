package pojo;

public class Client extends User {

    private boolean isValidated;
    private boolean isDeleted;

    public Client() {
    }

    public Client(User u) {
        super(u);
    }

    public Client(String login, String password, String pseudo) {
        super(login, password, pseudo);

        isValidated = false;
        isDeleted = false;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return super.toString()+"Client{" +
                "isValidated=" + isValidated +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
