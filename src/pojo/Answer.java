package pojo;

public class Answer {

    private User user;
    private Option option;

    public Answer(Option option,User user) {
        this.user = user;
        this.option = option;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "user=" + user +

                ", option=" + option +
                '}';
    }
}
