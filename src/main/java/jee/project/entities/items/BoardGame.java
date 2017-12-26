package jee.project.entities.items;

import jee.project.entities.ItemEntity;
import jee.project.entities.ItemStyle;
import jee.project.entities.genres.BoardGameGenre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="BoardGame")
public class BoardGame extends ItemEntity implements ItemStyle {
    // ATTRIBUTES
    /* Author */
    @Column(name = "author")
    private String author;

    /* Editor */
    @Column(name = "editor")
    private String editor;

    /* Minimum age restriction */

    @Column(name = "ageMin")
    private int ageMin;

    /* Minimum players */
    @Column(name = "minPlayers")
    private int minPlayers;

    /* Maximum players */
    @Column(name = "maxPlayers")
    private int maxPlayers;

    /* Duration (in minutes) */
    @Column(name = "duration")
    private int duration;

    /* Board game genres */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "boardGameGenre_id")
    @Column(name = "genres")
    private Set<BoardGameGenre> genres = new HashSet<>();

    // CONSTRUCTOR
    public BoardGame() {
    }

    // GETTERS, SETTERS AND METHODS

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null) return;
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        if (editor == null) return;
        this.editor = editor;
    }

    public void addGenre(BoardGameGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(BoardGameGenre genre) {
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

    public boolean genresContains(BoardGameGenre genre) {
        return this.genres.contains(genre);
    }
}
