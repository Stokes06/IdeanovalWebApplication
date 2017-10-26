package pojo;

import java.util.Date;

public class Commentary {

    private static int commentary_count=0;
    private int id;
    private User author;
    private Idea idea;
    private String content;
    private Date commentDate;

    public Commentary(User author, Idea idea, String content) {
        this.id = commentary_count++;
        this.author = author;
        this.idea = idea;
        this.content = content;
        this.commentDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Idea getIdea() {
        return idea;
    }

    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
