package edu.universidadmodelo.feedback.model;

import java.time.LocalDateTime;

public class Feedback {

    private String id;
    private String type;
    private String subject;
    private String comment;
    private int likes;
    private String password;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", subject='" + subject + '\'' +
                ", comment='" + comment + '\'' +
                ", likes=" + likes +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Feedback() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
