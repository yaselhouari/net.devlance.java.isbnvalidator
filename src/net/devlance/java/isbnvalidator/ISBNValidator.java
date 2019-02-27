package net.devlance.java.isbnvalidator;

public class ISBNValidator {
    public boolean checkISBN(String isbn) {
        int total = 0;
        if (isbn.length () == 13) {
            return isThisValidThirteenDigitsISBN ( isbn, total );
        } else if(isbn.length () == 10){
            return isThisValidTenDigitsISBN ( isbn, total );
        } else {
            throw new NumberFormatException ( "Digits that are not 10 or 13 are not allowed!" );
        }
    }
    private boolean isThisValidTenDigitsISBN(String isbn, int total) {
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit ( isbn.charAt ( i ) )) {
                if (i == 9 && isbn.charAt ( i ) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException ( "ISBN Numbers can only contain digits" );
                }
            } else {
                total += Character.getNumericValue ( isbn.charAt ( i ) ) * (10 - i);
            }
        }
        if (total % 11 == 0)
            return true;
        else
            return false;
    }

    private boolean isThisValidThirteenDigitsISBN(String isbn, int total) {
        for(int i=0; i<13; i++) {
            if(i%2 == 0) {
                total += Character.getNumericValue ( isbn.charAt ( i ) );
            } else {
                total += Character.getNumericValue ( isbn.charAt ( i ) ) * 3;
            }
        }
        if(total%10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
