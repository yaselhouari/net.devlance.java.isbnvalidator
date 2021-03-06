package net.devlance.java.isbnvalidator;

public class ISBNValidator {

    public static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {
        int total = 0;
        if (isbn.length () == LONG_ISBN_LENGTH) {
            return isThisValidLongISBN ( isbn, total );
        } else if(isbn.length () == SHORT_ISBN_LENGTH){
            return isThisValidShortISBN ( isbn, total );
        } else {
            throw new NumberFormatException ( "Digits that are not 10 or 13 are not allowed!" );
        }
    }
    private boolean isThisValidShortISBN(String isbn, int total) {
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit ( isbn.charAt ( i ) )) {
                if (i == 9 && isbn.charAt ( i ) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException ( "ISBN Numbers can only contain digits" );
                }
            } else {
                total += Character.getNumericValue ( isbn.charAt ( i ) ) * (SHORT_ISBN_LENGTH - i);
            }
        }
        return (total % SHORT_ISBN_MULTIPLIER == 0);
    }

    private boolean isThisValidLongISBN(String isbn, int total) {
        for(int i=0; i < LONG_ISBN_LENGTH; i++) {
            if(i%2 == 0) {
                total += Character.getNumericValue ( isbn.charAt ( i ) );
            } else {
                total += Character.getNumericValue ( isbn.charAt ( i ) ) * 3;
            }
        }
        return (total % LONG_ISBN_MULTIPLIER == 0);
    }
}
