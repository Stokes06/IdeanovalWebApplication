package pojo;

public class Answer {

    private User user;
    private Poll poll;
    private Option option;

    public Answer(Poll poll, Option option,User user) {
        this.user = user;
        this.poll = poll;
        this.option = option;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
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
                ", poll=" + poll +
                ", option=" + option +
                '}';
    }
}
