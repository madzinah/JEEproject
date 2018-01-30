package jee.project.entities.support;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.regex.Pattern;

@Entity
@Table(name = "ISBN")
public class ISBN {
    // ATTRIBUTES
    @Column(name = "isbn", unique = true)
    private String isbn;
    private static final String ISBN_PATTERN = "[0-9]{1,5}[-][0-9]{1,7}[-][0-9]{1,5}[-][0-9X]{1}";

    // CONSTRUCTORS
    public ISBN() {
    }
    public ISBN(String isbn) throws IllegalISBNException {
        if (isbn == null) throw new IllegalISBNException();
        if (isISBN(isbn)) {
            this.isbn = isbn;
        } else {
            throw new IllegalISBNException();
        }
    }

    // SETTERS, GETTERS AND METHODS
    public static boolean isISBN(String isbn) {
        if (isbn == null) return false;
        return (Pattern.matches(ISBN_PATTERN, isbn));
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws IllegalISBNException {
        if (isbn == null) throw new IllegalISBNException();
        if (isISBN(isbn)) {
            this.isbn = isbn;
        } else {
            throw new IllegalISBNException();
        }
    }
}
