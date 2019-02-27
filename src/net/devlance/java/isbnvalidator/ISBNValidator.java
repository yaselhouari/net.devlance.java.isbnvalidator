package net.devlance.java.isbnvalidator;

public class ISBNValidator {
    public boolean checkISBN(String isbn) {
        int total = 0;
        if(isbn.length() != 10 ) throw new NumberFormatException ("Less than 10 Digits are not allowed");
        for(int i=0; i<10; i++) {
            if(!Character.isDigit(isbn.charAt(i))) {
                if(i == 9 && isbn.charAt(i) == 'X') {
                    total+= 10;
                } else {
                    throw new NumberFormatException ( "ISBN Numbers can only contain digits" );
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i) ) * (10 - i);
            }
        }
        if(total%11 ==0)
            return true;
        else return false;
    }
}
