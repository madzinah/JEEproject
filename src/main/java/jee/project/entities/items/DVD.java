package jee.project.entities.items;

import jee.project.entities.ItemEntity;
import jee.project.entities.ItemStyle;
import jee.project.entities.genres.DVDGenre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DVD")
public class DVD extends ItemEntity implements ItemStyle {
    // ATTRIBUTES

    /* List of directors */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "directors_id")
    @Column(name = "directors")
    private Set<String> directors = new HashSet<>();

    /* List of producers */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producers_id")
    @Column(name = "producers")
    private Set<String> producers = new HashSet<>();

    /* Running Time */
    @Column(name = "runningTime")
    private float runningTime;

    /* Genre(s) */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DVDGenres_id")
    @Column(name = "genres")
    private Set<DVDGenre> genres = new HashSet<>();

    /* Budget */
    @Column(name = "budget")
    private int budget;

    // CONSTRUCTOR
    public DVD() {
    }

    // SETTERS, GETTERS AND METHODS
    public void addGenre(DVDGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(DVDGenre genre) {
        if (genre == null) return;
        this.genres.remove(genre);
    }

    @Override
    public int numberOfGenres() {
        return this.genres.size();
    }

    @Override
    public void clearGenres() {
        this.genres.clear();
    }

    @Override
    public boolean genresAreEmpty() {
        return this.genres.isEmpty();
    }

    public boolean genresContains(DVDGenre genre) {
        return this.genres.contains(genre);
    }

    public float getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(float runningTime) {
        this.runningTime = runningTime;
    }

    public void addProducer(String producer) {
        if (producer == null) return;
        producers.add(producer);
    }

    public void removeProducer(String producer) {
        if (producer == null) return;
        producers.remove(producer);
    }

    public int numberOfProducers() {
        return producers.size();
    }

    public void clearProducers() {
        this.producers.clear();
    }

    public boolean producersAreEmpty() {
        return this.producers.isEmpty();
    }

    public boolean producersContains(String producer) {
        if (producer == null) return false;
        return this.producers.contains(producer);
    }

    public void addDirector(String director) {
        if (director == null) return;
        this.directors.add(director);
    }

    public void removeDirector(String director) {
        if (director == null) return;
        this.directors.remove(director);
    }

    public int numberOfDirectors() {
        return this.directors.size();
    }

    public void clearDirectors() {
        this.directors.clear();
    }

    public boolean directorsAreEmpty() {
        return this.directors.isEmpty();
    }

    public boolean directorsContains(String director) {
        if (director == null) return false;
        return this.directors.contains(director);
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
