package jee.project.entities;

import javax.persistence.*;
import java.util.ArrayList;
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

    public List<String> getProductors() {
        return productors;
    }

    public void setProductors(List<String> productors) {
        if (productors == null) throw new IllegalArgumentException();
        if (productors.size() == 0) throw new IllegalArgumentException("The list can't be void");
        this.productors = productors;
    }

    public void addProductor(String productor) {
        if (productor == null) throw new IllegalArgumentException();
        if (this.productors == null) this.productors = new ArrayList<>();
        this.productors.add(productor);
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        if (duration <= 0) throw new IllegalArgumentException();
        this.duration = duration;
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
