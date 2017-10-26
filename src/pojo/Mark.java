package pojo;

public class Mark {

    private User user;
    private EvaluableIdea idea;
    private boolean grade;

    /**
     *
     * @param user
     * @param idea
     * @param grade true pour top / false pour flop
     */
    public Mark(User user, EvaluableIdea idea, boolean grade) {
        this.user = user;
        this.idea = idea;
        this.grade = grade;
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
        return grade;
    }

    public void setGrade(boolean grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "user=" + user +
                ", idea=" + idea +
                ", grade=" + ((grade)? "top" : "flop") +
                '}';
    }
}
