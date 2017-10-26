package pojo;

public class IdeaAlert {

    private String reason;
    private User user;

    public IdeaAlert(String reason, User user) {
        this.reason = reason;
        this.user = user;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "IdeaAlert{" +
                "reason='" + reason + '\'' +
                ", user=" + user +
                '}';
    }
}
