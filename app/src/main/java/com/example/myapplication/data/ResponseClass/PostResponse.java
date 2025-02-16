package com.example.myapplication.data.ResponseClass;

import com.example.myapplication.data.Models.Post;

import java.util.List;

public class PostResponse {
    private boolean success;
    private List<Post> posts;


    public PostResponse(boolean success, List<Post> posts) {
        this.success = success;
        this.posts = posts;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
