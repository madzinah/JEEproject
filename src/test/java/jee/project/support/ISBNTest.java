package jee.project.support;

import jee.project.entities.support.ISBN;
import jee.project.entities.support.IllegalISBNException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ISBNTest {

    // ASSERT TRUE

    @Test
    public void Should_work_fine_with_simple_tests() {
        assertTrue(ISBN.isISBN("2-7201-0011-0"));
        assertTrue(ISBN.isISBN("99921-58-10-7"));
        assertTrue(ISBN.isISBN("9971-5-0210-0"));
        assertTrue(ISBN.isISBN("0-85131-041-9"));
    }

    @Test
    public void Should_be_true_when_simple_test_with_letters() {
        assertTrue(ISBN.isISBN("0-9752298-0-X"));
        assertTrue(ISBN.isISBN("123-1245-1547-X"));
    }

    // ASSERT FALSE

    @Test
    public void Should_be_false_when_null() {
        assertFalse(ISBN.isISBN(null));
    }

    @Test
    public void Should_be_false_when_empty() {
        assertFalse(ISBN.isISBN(""));
    }

    @Test
    public void Sould_be_false_when_too_few_numbers() {
        assertFalse(ISBN.isISBN("0-5961-52068"));
        assertFalse(ISBN.isISBN("958-5846-6854"));
    }

    @Test
    public void Should_be_false_when_too_much_numbers() {
        assertFalse(ISBN.isISBN("978-1-2345-6789-7"));
        assertFalse(ISBN.isISBN("123-458-487-4-9"));
    }

    @Test
    public void Should_return_exception_when_instantiate_with_null() {
        ISBN test01;
        try {
            test01 = new ISBN(null);
            assertTrue(false);
        } catch (IllegalISBNException ie) {
            assertTrue(true);
        }
    }
}