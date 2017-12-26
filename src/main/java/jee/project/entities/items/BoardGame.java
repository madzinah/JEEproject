package jee.project.entities.items;

import jee.project.entities.ItemStyle;
import jee.project.entities.genres.BoardGameGenre;

import java.util.Date;
import java.util.List;

public class BoardGame implements ItemStyle {
    // ATTRIBUTES
    /* Title */
    private String title;

    /* Release date */
    private Date releaseDate;

    /* Author */
    private String author;

    /* Editor */
    private String editor;

    /* Description */
    private String description;

    /* Minimum age restriction */
    private int ageMin;

    /* Minimum players */
    private int minPlayers;

    /* Maximum players */
    private int maxPlayers;

    /* Duration (in minutes) */
    private int duration;

    /* Board game genres */
    private List<BoardGameGenre> genres;

    // CONSTRUCTOR
    public BoardGame() {

    }

    // GETTERS, SETTERS AND METHODS
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        if (this.title == null) return;
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

    public List<BoardGameGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<BoardGameGenre> genres) {
        this.genres = genres;
    }

    public void addGenre(BoardGameGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(BoardGameGenre genre) {
        if (genre == null) return;
        this.genres.remove(genre);
    }

    public int numberOfGenres() {
        return this.genres.size();
    }
}
