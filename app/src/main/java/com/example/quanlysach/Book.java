package com.example.quanlysach;

import java.io.Serializable;

/** Dữ liệu của một cuốn sách trong thư viện cá nhân. */
public class Book implements Serializable {
    private String title, author, category, readingStatus, note;
    private float rating;

    public Book(String title, String author, String category, String readingStatus, float rating, String note) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.readingStatus = readingStatus;
        this.rating = rating;
        this.note = note;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getReadingStatus() { return readingStatus; }
    public String getNote() { return note; }
    public float getRating() { return rating; }
    public void setReadingStatus(String readingStatus) { this.readingStatus = readingStatus; }
    public void setRating(float rating) { this.rating = rating; }
}
