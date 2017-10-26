package pojo;
import java.util.Date;
public class CommentaryAlert {

    private String reason;
    private User user;

    public CommentaryAlert(String reason, User user) {
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
        return "CommentaryAlert{" +
                "reason='" + reason + '\'' +
                ", user=" + user +
                '}';
    }
}
