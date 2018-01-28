package jee.project.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dvd {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private List<String> productors;

    @Column(nullable = false)
    private double duration;

    @Column
    private List<String> genres;

    // Constructors
    protected Dvd() {}

    public Dvd(String title, String author) {
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
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getProductors() {
        return productors;
    }

    public void setProductors(List<String> productors) {
        this.productors = productors;
    }

    public void addProductor(String productor) {
        this.productors.add(productor);
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
