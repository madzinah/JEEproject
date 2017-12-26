package jee.project.entities.items;

import jee.project.entities.ItemStyle;
import jee.project.entities.genres.BookGenre;
import jee.project.entities.support.ISBN;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements ItemStyle {
    // ATTRIBUTES
    /* Title */
    private String title;

    /* Release date */
    private Date releaseDate;

    /* Description */
    private String description;

    /* Author */
    private String author;

    /* Number of pages */
    private int pages;

    /* Editor */
    private String editor;

    /* List of genres */
    private List<BookGenre> genres;

    /* ISBN */
    private ISBN isbn;

    public Book() {
        this.genres = new ArrayList<>();
    }

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

    public List<BookGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<BookGenre> genres) {
        this.genres = genres;
    }

    public void addGenre(BookGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(BookGenre genre) {
        if (genre == null) return;
        this.genres.remove(genre);
    }

    public int numberOfGenres() {
        return this.genres.size();
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

    public ISBN getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
