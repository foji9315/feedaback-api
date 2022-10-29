package edu.universidadmodelo.feedback.model;

public class Feedback {

    private String id;
    private String comment;

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                '}';
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
