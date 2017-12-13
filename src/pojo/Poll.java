package pojo;

import java.util.List;

public class Poll extends Idea {

    private String topic;
    private List<Option> options;
    public Poll(String title, String content, Client author) {
        super(title, content, author);
    }

    public Poll(String title, String content, Client author, String topic) {
        super(title, content, author);
        this.topic = topic;
    }

    public void addOption(Option o){this.options.add(o);}
    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
