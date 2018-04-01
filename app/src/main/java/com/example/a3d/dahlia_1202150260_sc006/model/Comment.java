package com.example.a3d.dahlia_1202150260_sc006.model;

/**
 * Created by 3D on 4/1/2018.
 */

public class Comment {

    String id;
    String username;
    String comment;
    Long timestamp;

    public Comment() {
    }

    public Comment(String id, String username, String comment, Long timestamp) {
        this.id=id;
        this.username = username;
        this.comment = comment;
        this.timestamp=timestamp;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }
}

