package jee.project.entities.items;

import jee.project.entities.ItemStyle;
import jee.project.entities.genres.DVDGenre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DVD implements ItemStyle {
    // ATTRIBUTES
    /* Title */
    private String title;

    /* List of directors */
    private List<String> directors;

    /* List of producers */
    private List<String> producers;

    /* Release date */
    private Date dateRelease;

    /* Resume */
    private String description;

    /* Running Time */
    private float runningTime;

    /* Genre(s) */
    private List<DVDGenre> genres;

    /* Budget */
    private int budget;

    // CONSTRUCTOR
    public DVD() {
        this.producers = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    // SETES GETERS
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        if (title == null) return;
        this.title = title;
    }

    @Override
    public Date getReleaseDate() {
        return dateRelease;
    }

    @Override
    public void setReleaseDate(Date date) {
        this.dateRelease = date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        if (description == null) return;
        this.description = description;
    }

    public List<DVDGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<DVDGenre> genres) {
        this.genres = genres;
    }

    public void addGenre(DVDGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(DVDGenre genre) {
        if (genre == null) return;
        this.genres.remove(genre);
    }

    public int numberOfGenres() {
        return this.genres.size();
    }

    public float getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(float runningTime) {
        this.runningTime = runningTime;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
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

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
