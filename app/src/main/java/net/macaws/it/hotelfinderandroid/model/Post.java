package net.macaws.it.hotelfinderandroid.model;

import java.io.Serializable;
import java.io.StringReader;

/**
 * Created by Rob on 10/07/2016.
 */
public class Post implements Serializable {
    private int id;
    private String title;
    private String content;
    private User user;
    private String posted_date;

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

    public Post() {
        id = 0;
        title = "";
        content = "";
        user = new User();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
