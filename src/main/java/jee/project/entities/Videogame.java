package jee.project.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Videogame {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private List<String> producers;

    @Column
    private int min_age;

    @Column
    private List<String> genres;

    // Constructors
    protected Videogame() {}

    public Videogame(String title) {
        if (title == null) throw new IllegalArgumentException();
        this.title = title;
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
        if (this.author == null) throw new IllegalArgumentException();
        this.author = author;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        if (producers == null) throw new IllegalArgumentException();
        if (producers.size() == 0) throw new IllegalArgumentException("The list can't be void");
        if (this.producers == null) this.producers = new ArrayList<>();
        this.producers = producers;
    }

    public void addProducer(String producer) {
        if (producer == null) throw new IllegalArgumentException();
        if (this.producers == null) this.producers = new ArrayList<>();
        this.producers.add(producer);
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        if (min_age < 0) throw new IllegalArgumentException();
        this.min_age = min_age;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        if (genres == null) throw new IllegalArgumentException();
        if (genres.size() == 0) throw new IllegalArgumentException("The list can't be void");
        this.genres = genres;
    }

    public void addGenre(String genre) {
        if (genre == null) throw new IllegalArgumentException();
        if (this.genres == null) this.genres = new ArrayList<>();
        this.genres.add(genre);
    }
}
