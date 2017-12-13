package pojo;

public class IdeaAlert {

    private String reason;
    private User user;
    private Idea idea;

    public IdeaAlert() {
    }

    public IdeaAlert(String reason, User user, Idea idea) {
        this.reason = reason;
        this.user = user;
        this.idea = idea;
    }

    public IdeaAlert(String reason, User user) {
        this.reason = reason;
        this.user = user;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
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
