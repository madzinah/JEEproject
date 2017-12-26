package jee.project.entities.items;

import jee.project.entities.ItemEntity;
import jee.project.entities.ItemStyle;
import jee.project.entities.genres.BookGenre;
import jee.project.entities.support.ISBN;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Book")
public class Book extends ItemEntity implements ItemStyle {
    // ATTRIBUTES
    /* Author */
    @Column(name = "author")
    private String author;

    /* Number of pages */
    @Column(name = "pages")
    private int pages;

    /* Editor */
    @Column(name = "editor")
    private String editor;

    /* List of genres */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookGenre_id")
    @Column(name = "genres")
    private Set<BookGenre> genres = new HashSet<BookGenre>();

    /* ISBN */
    @Column(name = "isbn")
    private ISBN isbn;

    // CONSTRUCTOR
    public Book() {
    }

    // GETTERS, SETTERS AND METHODS
    public void addGenre(BookGenre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public void removeGenre(BookGenre genre) {
        if (genre == null) return;
        this.genres.remove(genre);
    }

    @Override
    public int numberOfGenres() {
        return this.genres.size();
    }

    @Override
    public void clearGenres() { this.genres.clear(); }

    @Override
    public boolean genresAreEmpty() {
        return this.genres.isEmpty();
    }

    public boolean genresContains(BookGenre genre) {
        return this.genres.contains(genre);
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
