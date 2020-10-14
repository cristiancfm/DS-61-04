package e1;

import java.util.Random;

public class StringUtilities {

    /**
     * Checks if a given string is a valid c of two others . That is, it contains
     * all characters of the other two and order of all characters in the individual
     * strings is preserved.
     *
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @param c Mix of the two other Strings
     * @return true if the c is valid , false otherwise
     */
    public static boolean isValidMix(String a, String b, String c) {
        /* PSEUDOCODE:
         - for the number of characters of c:
            - read a character of string c
            - search in a and b the same character
            - if the character was found, append the character in a2 if it was found in a, or the same for b
         - if a2 equals a and b2 equals b, return true
         */

        char currentChar;
        StringBuilder a2 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();

        for (int i = 0; i < c.length(); i++) {
            currentChar = c.charAt(i);

            if (a.contains(Character.toString(currentChar))) {
                a2.append(currentChar);
            }

            if (b.contains(Character.toString(currentChar))) {
                b2.append(currentChar);
            }
        }

        return a2.toString().equals(a) && b2.toString().equals(b);
    }


    /**
     * Generates a random valid mix for two Strings
     *
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two.
     */
    public static String generateRandomValidMix(String a, String b) {
        /* PSEUDOCODE:
        - while the (char counters) of a and b are less than the length of strings a and b respectively:
            - select randomly a or b
            - append the character no. (char counter) of the string selected
            - add 1 to (char counter) of the string selected
            - if (character counter) of the string selected equals the length of the string,
                append the rest of characters of the other string
        - return the mixed string
         */

        int charCounterA, charCounterB, randomInt;
        Random randomSelector = new Random();
        StringBuilder mixedString = new StringBuilder();

        charCounterA = 0;
        charCounterB = 0;

        while(charCounterA < a.length() && charCounterB < b.length()) {
            randomInt = randomSelector.nextInt(2); //randomly selects 0 (string a) or 1 (string b)

            if (randomInt == 0) {
                mixedString.append(a.charAt(charCounterA));
                charCounterA++;
            }
            if (randomInt == 1) {
                mixedString.append(b.charAt(charCounterB));
                charCounterB++;
            }
        }
        if (charCounterA == a.length()) //string A is in the mixed string
            mixedString.append(b.substring(charCounterB)); //appends the rest of string B

        if (charCounterB == b.length()) //string B is in the mixed string
           mixedString.append(a.substring(charCounterA)); //appends the rest of string A

        return mixedString.toString();
    }

    //checking
    public static void main(String[] args) {
        String a = "Bye";
        String b = "World";
        String c = null;

        c = StringUtilities.generateRandomValidMix(a,b);
        System.out.println(c);
        if(StringUtilities.isValidMix(a,b,c))
            System.out.println("Valid mix");
    }
}
