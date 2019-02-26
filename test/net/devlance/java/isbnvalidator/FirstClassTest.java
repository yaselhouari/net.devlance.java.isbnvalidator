package net.devlance.java.isbnvalidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstClassTest {

    @Test
    public void checkValidISBN() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN(140449116);
        assertTrue(result);
    }

    @Test
    public void checkInvalidISBN() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN(140449117);
        assertFalse(result);
    }
}
