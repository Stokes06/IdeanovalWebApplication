package pojo;

public class Poll extends Idea {

    private String topic;

    public Poll(String title, String content, Client author) {
        super(title, content, author);
    }

    public Poll(String title, String content, Client author, String topic) {
        super(title, content, author);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
