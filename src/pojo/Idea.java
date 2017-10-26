package pojo;


import java.util.Date;

public abstract class Idea {

    private static int idea_count = 0;
    private int id;
    private String title;
    private String content;
    private Date publishDate;
    private Date evaluationDeadline;
    private boolean isDeleted;
    private String url_image;
    private Client author;
    private Category category;

    public Idea(String title, String content, Client author) {
        this.id = idea_count++;
        this.title = title;
        this.content = content;
        this.author = author;
        publishDate = new Date();
    }

    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", evaluationDeadline=" + evaluationDeadline +
                ", isDeleted=" + isDeleted +
                ", url_image='" + url_image + '\'' +
                ", author=" + author +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getEvaluationDeadline() {
        return evaluationDeadline;
    }

    public void setEvaluationDeadline(Date evaluationDeadline) {
        this.evaluationDeadline = evaluationDeadline;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Client getAuthor() {
        return author;
    }

    public void setAuthor(Client author) {
        this.author = author;
    }
}
