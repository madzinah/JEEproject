package jee.project.entities.support;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ISBNTest {

    // TODO : Refacto with good names
    @Test
    public void oekfoekfoekfoke() {
        assertTrue(ISBN.isISBN("2-7201-0011-0"));
        assertTrue(ISBN.isISBN("0-9752298-0-X"));
        assertTrue(ISBN.isISBN("99921-58-10-7"));
        assertTrue(ISBN.isISBN("9971-5-0210-0"));
        assertTrue(ISBN.isISBN("0-85131-041-9"));

        assertFalse(ISBN.isISBN(null));
        assertFalse(ISBN.isISBN("978-1-2345-6789-7"));
        assertFalse(ISBN.isISBN("0-5961-52068"));
        assertFalse(ISBN.isISBN(""));
    }
}