package jee.project.entities.support;

import org.junit.Test;

import static org.junit.Assert.*;

public class ISBNTest {
    // TEST ISBN

    @Test
    public void Should_return_true_when_given_simple_values() {
        assertTrue(ISBN.isISBN("2-7201-0011-0"));
        assertTrue(ISBN.isISBN("0-85131-041-9"));
        assertTrue(ISBN.isISBN("9971-5-0210-0"));
        assertTrue(ISBN.isISBN("99921-58-10-7"));
    }

    @Test
    public void Should_return_true_when_last_value_is_X() {
        assertTrue(ISBN.isISBN("0-9752298-0-X"));
    }

    @Test
    public void Should_return_false_when_null_value() {
        assertFalse(ISBN.isISBN(null));
    }

    @Test
    public void Should_return_false_when_few_values() {
        assertFalse(ISBN.isISBN("978-1-2345-6789-7"));
    }

    @Test
    public void Should_return_false_when_less_values() {
        assertFalse(ISBN.isISBN("0-5961-52068"));
    }

    @Test
    public void Should_return_false_when_empty_value() {
        assertFalse(ISBN.isISBN(""));
    }

    // TEST INSTANCIATION

    @Test
    public void Should_work_when_instanciate_correct_class_without_args() throws IllegalISBNException {
        ISBN isbn = new ISBN();
        assertEquals(isbn.getIsbn(), null);
        isbn.setIsbn("99921-58-10-7");
        assertEquals(isbn.getIsbn(), "99921-58-10-7");
        assertTrue(ISBN.isISBN(isbn.getIsbn()));
    }

    @Test(expected = IllegalISBNException.class)
    public void Should_catch_exception_when_few_values_given_to_method() throws IllegalISBNException {
        ISBN isbn = new ISBN();
        isbn.setIsbn("1234-1234-1234-1234-1234");
    }

    @Test(expected = IllegalISBNException.class)
    public void Should_catch_exception_when_few_values_given_to_constructor() throws IllegalISBNException {
        ISBN isbn = new ISBN("1234-1234-1234-1234-1234");
    }
}