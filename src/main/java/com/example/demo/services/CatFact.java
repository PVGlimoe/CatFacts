package com.example.demo.services;

import java.util.Date;

public class CatFact implements Comparable<CatFact> {
    private String text;
    private Date createdAt;
    private Date updatedAt;

    public CatFact(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return  "</br>"
            +   "Cat Joke:" + "</br>"
            +   text + "<br>"
            +   "Created at: " + createdAt + "<br>"
            +   "Updated at: " + updatedAt + "</br>";
    }

    @Override
    public int compareTo(CatFact o) {
        return this.createdAt.compareTo(o.getCreatedAt());
    }
}
