package com.example.myapplication.data.Models;
public class Post {
    private int id;
    private String title;
    private String descr;
    private String img_url;
    private UserPost user;

    public Post(int id, String title, String descr, String img_url, UserPost user) {
        this.id = id;
        this.title = title;
        this.descr = descr;
        this.img_url = img_url;
        this.user = user;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public UserPost getUser() {
        return user;
    }

    public void setUser(UserPost user) {
        this.user = user;
    }
}

