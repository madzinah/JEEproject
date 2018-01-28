package jee.project.entities;

import javax.management.BadAttributeValueExpException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Boardgame {
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
    private int min_players;

    @Column
    private int max_players;

    @Column
    private int duration;

    @Column
    private List<String> genres;

    // Constructors
    protected Boardgame() {}

    public Boardgame(String title) {
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
        if (author == null) throw new IllegalArgumentException();
        this.author = author;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        if (producers == null) throw new IllegalArgumentException();
        if (producers.size() == 0) throw new IllegalArgumentException("The list is void");
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) throw new IllegalArgumentException();
        this.duration = duration;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        if (genres == null) throw new IllegalArgumentException();
        if (genres.size() == 0) throw new IllegalArgumentException("The list is void");
        this.genres = genres;
    }

    public void addGenre(String genre) {
        if (genre == null) throw new IllegalArgumentException();
        if (this.genres == null) this.genres = new ArrayList<>();
        this.genres.add(genre);
    }

    public int getMin_players() {
        return min_players;
    }

    public void setMin_players(int min_players) {
        if (min_players > this.max_players) throw new IllegalArgumentException("Min players can't be higher than max players");
        this.min_players = min_players;
    }

    public int getMax_players() {
        return max_players;
    }

    public void setMax_players(int max_players) {
        if (max_players < this.min_players) throw new IllegalArgumentException("Max players can't be lower than min players");
        this.max_players = max_players;
    }
}
