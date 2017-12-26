package jee.project.entities.items;

import jee.project.entities.ItemStyle;
import jee.project.entities.genres.CDGenre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CD implements ItemStyle {
    // ATTRIBUTES
    /* Title */
    private String title;

    /* Release date */
    private Date releaseDate;

    /* Record date */
    private Date recordDate;

    /* Studio */
    private String studio;

    /* Place */
    private String place;

    /* Description */
    private String description;

    /* List of labels */
    private List<String> labels;

    /* List of genres */
    private List<CDGenre> genres;

    // CONSTRUCTOR
    public CD() {
        this.labels = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    // SETERS GETERS
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
        return releaseDate;
    }

    @Override
    public void setReleaseDate(Date date) {
        this.releaseDate = date;
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

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        if (studio == null) return;
        this.studio = studio;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        if (place == null) return;
        this.place = place;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public void addLabel(String label) {
        if (label == null) return;
        this.labels.add(label);
    }

    public void removeLabel(String label) {
        if (label == null) return;
        this.labels.remove(label);
    }

    public int numberOfLabels() {
        return this.labels.size();
    }

    public List<CDGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<CDGenre> genres) {
        this.genres = genres;
    }

    public void addGenre(CDGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(CDGenre genre) {
        if (genre == null) return;
        this.genres.remove(genre);
    }

    public int numberOfGenres() {
        return this.genres.size();
    }
}
