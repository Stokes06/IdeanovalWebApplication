package pojo;

public class Mark {

    private User user;
    private EvaluableIdea idea;
    private boolean like;

    /**
     *
     * @param user
     * @param idea
     * @param like true pour top / false pour flop
     */
    public Mark(User user, EvaluableIdea idea, boolean like) {
        this.user = user;
        this.idea = idea;
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EvaluableIdea getIdea() {
        return idea;
    }

    public void setIdea(EvaluableIdea idea) {
        this.idea = idea;
    }

    public boolean isTop() {
        return like;
    }

    public void setGrade(boolean grade) {
        this.like = grade;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "user=" + user +
                ", idea=" + idea +
                ", grade=" + ((like)? "top" : "flop") +
                '}';
    }
}
