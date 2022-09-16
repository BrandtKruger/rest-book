package org.agoncal.quarkus.starting;

public class Book {
    public int id;
    public String title;
    public String author;
    public int yearOffPublication;
    public String genre;

    public Book(int id, String title, String author, int yearOffPublication, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOffPublication = yearOffPublication;
        this.genre = genre;
    }
}
