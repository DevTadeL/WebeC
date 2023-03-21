package ch.fhnw.webec.booklist.model;

import java.util.Set;

public class Book {
    private int id;
    private String title;
    private String description;
    private Set<Topic> topics;

    public Book(String title, String description, Set<Topic> topics) {
        this.title = title;
        this.description = description;
        this.topics = topics;
    }

    public Book(int id, String title, String description, Set<Topic> topics) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.topics = topics;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
