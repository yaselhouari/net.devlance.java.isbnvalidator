package net.devlance.java.isbnvalidator;

public class ISBNValidator {
    public boolean checkISBN(String isbn) {
        int total = 0;
        if (isbn.length () == 13) {
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
        } else {
            if (isbn.length () != 10) throw new NumberFormatException ( "Less than 10 Digits are not allowed" );
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
            else return false;
        }
    }
}
