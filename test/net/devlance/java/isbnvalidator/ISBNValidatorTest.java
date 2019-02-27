package net.devlance.java.isbnvalidator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ISBNValidatorTest {

    @Test
    public void checkTenDigitsValidISBN() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("0140449116");
        assertTrue("first value of ISBN", result);

        result = isbnValidator.checkISBN("0140177396");
        assertTrue("second value of ISBN", result);
    }
    @Test
    public void isbnTenDigitsNumbersEndingInAnXAreValid() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("012000030X");
        assertTrue(result);
    }
    @Test
    public void checkTenDigitsInvalidISBN() {
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
        ISBNValidator isbnValidator = new ISBNValidator ();
        boolean result = isbnValidator.checkISBN ( "helloworld" );
        assertFalse ( result );
    }
    @Test
    public void checkValidThirteenDigitsISBNNumbers() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("9781853267338");
        assertTrue("First 13 digits value", result);
        result = isbnValidator.checkISBN("9783161484100");
        assertTrue("Second 13 digits value", result);
    }
    @Test
    public void checkInvalidThirteenDigitsISBNNumbers() {
        ISBNValidator isbnValidator = new ISBNValidator();
        boolean result = isbnValidator.checkISBN("9781853260085");
        assertFalse("Invalid 13 digits ISBN Number", result);
    }
}
