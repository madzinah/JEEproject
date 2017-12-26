package jee.project.entities.items;

import jee.project.entities.ItemStyle;
import jee.project.entities.genres.VideoGameGenre;
import jee.project.entities.support.VideoGameSupport;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class VideoGame implements ItemStyle {
    // ATTRIBUTES

    /* Title */
    private String title;

    /* Editor */
    private String editor;

    /* Developer Team */
    private String developer;

    /* Project date */
        private Date projectDate;

    /* Release date */
    private Date releaseDate;

    /* Description */
    private String description;

    /* Age restriction */
    private int pegi;

    /* List of supports */
    private List<VideoGameSupport> supportList;

    /* List of genres */
    private List<VideoGameGenre> genres;

    // CONSTRUCTOR
    public VideoGame() {
        this.supportList = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    // SETTERS, GETTERS AND METHODS
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
        if (date == null) return;
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

    public List<VideoGameSupport> getSupportList() {
        return supportList;
    }

    public void setSupportList(List<VideoGameSupport> supportList) {
        if (supportList == null) return;
        this.supportList = supportList;
    }

    public void addSupportItem(VideoGameSupport item) {
        if (item == null) return;
        if (supportList == null) {
            supportList = new ArrayList<>();
        }
        supportList.add(item);
    }

    public void removeSupportItem(VideoGameSupport item) {
        if (item == null) return;
        supportList.remove(item);
    }

    public int numberOfSupportItems() {
        return supportList.size();
    }

    public List<VideoGameGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<VideoGameGenre> genres) {
        this.genres = genres;
    }

    public void addGenre(VideoGameGenre genre) {
        if (genre == null) return;
        if (genres == null) {
            genres = new ArrayList<>();
        }
        genres.add(genre);
    }

    public void removeGenre(VideoGameGenre genre) {
        if (genre == null) return;
        genres.remove(genre);
    }

    public int numberOfGenres() {
        return genres.size();
    }
}
