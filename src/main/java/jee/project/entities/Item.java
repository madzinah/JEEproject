package jee.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
/**
 * This abstract class represent an item.
 * For example : a video game or a movie.
 */
public abstract class Item extends EntityObject {
    // ATTRIBUTE
    @Column
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        mappedBy = "items")
    private List<Genre> genres;

    // METHODS

    /**
     * Get genres
     * @return List
     */
    public List<Genre> getGenres() {
        return this.genres;
    }

    /**
     * Set genres
     * @param genres List
     */
    public void setGenres(List<Genre> genres) {
        if (genres == null) throw new IllegalArgumentException();
        this.genres = genres;
    }

    /**
     * Add a genre to the list
     * @param genre Genre
     */
    public void addGenre(Genre genre) {
        if (genre == null) throw new IllegalArgumentException();
        if (this.genres == null) this.genres = new ArrayList<>();
        this.genres.add(genre);
    }

    /**
     * Remove a genre from the list
     * @param genre Genre
     */
    public void removeGenre(Genre genre) {
        if (genre == null) throw new IllegalArgumentException();
        if (this.genres == null) {
            this.genres = new ArrayList<>();
            return;
        }
        this.genres.remove(genre);
    }

    /**
     * Return the number of actual genres
     * @return int
     */
    public int numberOfGenres() {
        if (this.genres == null) {
            return 0;
        } else return this.genres.size();
    }

    /**
     * Clear the list of genres
     */
    public void clearGenres() {
        if (this.genres == null) {
            this.genres = new ArrayList<>();
        } else this.genres.clear();
    }

    /**
     * Show if genre is in the list of genres
     * @param genre Genre
     * @return boolean
     */
    public boolean containGenre(Genre genre) {
        if (genre == null) throw new IllegalArgumentException();
        if (this.genres == null) this.genres = new ArrayList<>();
        return this.genres.contains(genre);
    }

    /**
     * Show if the list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        if (this.genres == null) this.genres = new ArrayList<>();
        return this.genres.isEmpty();
    }
}
