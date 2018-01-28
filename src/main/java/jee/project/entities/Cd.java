package jee.project.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cd {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String producer;

    @Column(nullable = false)
    private double duration;

    @Column
    private Date release;

    @Column
    private List<String> genres;

    // Constructors
    protected Cd() {}

    public Cd(String title, String producer) {
        this.title = title;
        this.producer = producer;
    }

    // Methods
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
        this.genres = genres;
    }

    public void addGenre(String genre) {
        this.genres.add(genre);
    }
}
