package jee.project.entities.items;

import jee.project.entities.ItemEntity;
import jee.project.entities.ItemStyle;
import jee.project.entities.genres.VideoGameGenre;
import jee.project.entities.support.VideoGameSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VideoGame")
public class VideoGame extends ItemEntity implements ItemStyle {
    // ATTRIBUTES

    /* Editor */
    @Column(name = "editor")
    private String editor;

    /* Developer Team */
    @Column(name = "developer")
    private String developer;

    /* Project date */
    @Column(name = "projectDate")
    private Date projectDate;

    /* Age restriction */
    @Column(name = "pegi")
    private int pegi;

    /* List of supports */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "supports_id")
    @Column(name = "supports")
    private Set<VideoGameSupport> supports = new HashSet<>();

    /* List of genres */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "VideoGameGenre_id")
    @Column(name = "genres")
    private Set<VideoGameGenre> genres = new HashSet<>();

    // CONSTRUCTOR
    public VideoGame() {
    }

    // SETTERS, GETTERS AND METHODS
    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        if (editor == null) return;
        this.editor = editor;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        if (developer == null) return;
        this.developer = developer;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(Date projectDate) {
        if (projectDate == null) return;
        this.projectDate = projectDate;
    }

    public void addSupportItem(VideoGameSupport item) {
        if (item == null) return;
        supports.add(item);
    }

    public void removeSupportItem(VideoGameSupport item) {
        if (item == null) return;
        supports.remove(item);
    }

    public int numberOfSupportItems() {
        return supports.size();
    }

    public void addGenre(VideoGameGenre genre) {
        if (genre == null) return;
        genres.add(genre);
    }

    public void removeGenre(VideoGameGenre genre) {
        if (genre == null) return;
        genres.remove(genre);
    }

    @Override
    public int numberOfGenres() {
        return genres.size();
    }

    @Override
    public void clearGenres() {
        this.genres.clear();
    }

    @Override
    public boolean genresAreEmpty() {
        return this.genres.isEmpty();
    }

    public boolean genresContains(VideoGameGenre genre) {
        return this.genres.contains(genre);
    }
}
