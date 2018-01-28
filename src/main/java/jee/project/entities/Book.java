package jee.project.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private Date release;

    @Column
    private List<String> genres;

    // Constructors
    protected Book() {}

    public Book(String title, String author) {
        if (title == null || author == null) throw new IllegalArgumentException();
        this.title = title;
        this.author = author;
    }

    // Methods
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException();
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null) throw new IllegalArgumentException();
        this.author = author;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        if (genres == null) throw new IllegalArgumentException();
        if (genres.size() == 0) throw new IllegalArgumentException("The list can't be void");
        if (this.genres == null) this.genres = new ArrayList<>();
        this.genres = genres;
    }

    public void addGenre(String genre) {
        if (genre == null) throw new IllegalArgumentException();
        if (this.genres == null) this.genres = new ArrayList<>();
        this.genres.add(genre);
    }
}
