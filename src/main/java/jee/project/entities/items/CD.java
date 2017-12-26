package jee.project.entities.items;

import jee.project.entities.ItemEntity;
import jee.project.entities.ItemStyle;
import jee.project.entities.genres.CDGenre;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CD")
public class CD extends ItemEntity implements ItemStyle {
    // ATTRIBUTES
    /* Record date */
    @Column(name = "recordDate")
    private Date recordDate;

    /* Studio */
    @Column(name = "studio")
    private String studio;

    /* Place */
    @Column(name = "place")
    private String place;

    /* List of labels */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Labels_id")
    @Column(name = "labels")
    private Set<String> labels = new HashSet<String>();

    /* List of genres */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CDGenre_id")
    @Column(name = "genres")
    private Set<CDGenre> genres = new HashSet<CDGenre>();

    // CONSTRUCTOR
    public CD() {
    }

    // SETTERS, GETTERS AND METHODS
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

    public void clearLabels() {
        this.labels.clear();
    }

    public boolean labelsAreEmpty() {
        return this.labels.isEmpty();
    }

    public boolean labelsContains(String label) {
        if (label == null) return false;
        return this.labels.contains(label);
    }

    public void addGenre(CDGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(CDGenre genre) {
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

    public boolean genresContains(CDGenre genre) {
        return this.genres.contains(genre);
    }
}
