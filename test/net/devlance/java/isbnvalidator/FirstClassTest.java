package net.devlance.java.isbnvalidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstClassTest {

    @Test
    public void checkValidISBN() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("0140449116");
        assertTrue("first value of ISBN", result);

        result = isbnValidator.checkISBN("0140177396");
        assertTrue("second value of ISBN", result);
    }

    @Test
    public void checkInvalidISBN() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("0140449117");
        assertFalse(result);
    }
    @Test(expected = NumberFormatException.class)
    public void lessThanTenDigitsAreNotAllowed() {
        ISBNValidator isbnValidator = new ISBNValidator();
        isbnValidator.checkISBN("123456789");
        //assertFalse(result);
    }
    @Test(expected = NumberFormatException.class)
    public void noneNumericISBNsAreNotAllowed() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("helloworld");
        assertFalse(result);
    }
}
