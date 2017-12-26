package jee.project.entities.support;

import java.util.regex.Pattern;

public class ISBN {
    // ATTRIBUTES
    private String isbn;
    private static final String ISBN_PATTERN = "[0-9]{1,5}[-][0-9]{1,7}[-][0-9]{1,5}[-][0-9X]{1}";

    // CONSTRUCTORS
    public ISBN() {
    }
    public ISBN(String isbn) {
        if (isISBN(isbn)) {
            this.isbn = isbn;
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

    public void setIsbn(String isbn) {
        if (isbn == null) return;
        if (isISBN(isbn))
            this.isbn = isbn;
    }
}
