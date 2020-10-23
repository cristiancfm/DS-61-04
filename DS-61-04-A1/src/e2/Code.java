package e2;


public class Code {
    /**
     * Determines whether a keypad is valid . To do this , it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated . If the array
     * (or any of its subarrays ) is null it will be returned false .
     * @param keypad The keypad to be analyzed .
     * @return true if it is valid , false otherwise .
     */
    public static boolean isKeypadValid(char[][] keypad) {

        //Alphanumeric keypad
        char[] alphanumeric = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int position;
        boolean fileSequence = true;
        boolean columnSequence = true;

        if(keypad == null)
            return false;

        else{
            for(int i = 0; i < keypad.length; i++) {
                if (keypad[i] == null) //columns can not be null
                    return false;
            }

            for(int i = 0; i < keypad.length - 1; i++){
                if (keypad[i].length != keypad[i + 1].length) //columns must have the same length
                    return false;
            }

            position = 0;

            for(int i = 0; i < keypad.length; i++){
                for(int j = 0; j < keypad[i].length; j++){
                    if(keypad[i][j] == alphanumeric[position])
                        position++;
                    else{
                        fileSequence = false;
                        break;
                    }
                }
                if(!fileSequence)
                    break;
            }


            position = 0;

            for(int j = 0; j < keypad[0].length; j++) {
                for (int i = 0; i < keypad.length; i++) {
                    if(keypad[i][j] == alphanumeric[position])
                        position++;
                    else{
                        columnSequence = false;
                        break;
                    }
                }
                if(!columnSequence)
                    break;
            }

            if(!fileSequence && !columnSequence)
                return false;

        }

        return true;
    }


    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad .
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false .
     * @param movements Array of Strings representing movements .
     * @return true if it is valid , false otherwise .
     */
    public static boolean areMovementsValid(String[] movements) {


        if (movements == null) {
            return false;
        }


        for (int i = 0; i < movements.length; i++) {
            if (movements[i] == null) {
                return false;
            }


            for (int j = 0; j < movements[i].length(); j++) {

                switch (String.valueOf(movements[i].charAt(j))) {

                    case "D":
                    case "L":
                    case "U":
                    case "R":
                        continue;
                    default:
                        return false;

                }
            }
        }
        return true;
    }


    /**
     * Given a keypad and an array of movements , it returns a String with the code
     * resulting from applying the movements on the keypad .
     * @param keypad alphanumeric keypad .
     * @param movements Array with the different movements to be made for each
    number of the key .
     * @return Resulting code .
     * @throws IllegalArgumentException if the keypad of the movements are invalid .
     */
    public static String obtainCode(char[][] keypad, String[] movements) {/* ... */


        int a, b, i;
        a = 0;
        b = 0;

        StringBuilder digit = new StringBuilder(movements.length);

        if(!isKeypadValid(keypad)  || !areMovementsValid(movements) ){
            throw new IllegalArgumentException();
        }

        int fil= keypad.length, col=keypad[0].length;

        for (String mov : movements) {

            for (i = 0; i < mov.length(); i++) {

                switch (mov.charAt(i)) {

                    case 'D':
                        b = b < fil - 1 ? b + 1 : b;
                        break;
                    case 'R':
                        a = a < col - 1 ? a + 1 : a;
                        break;
                    case 'U':
                        b = b > 0 ? b - 1 : b;
                        break;
                    case 'L':
                        a = a > 0 ? a - 1 : a;
                        break;
                }

            }

            digit.append(keypad[b][a]);

        }
        return new String(digit);
    }
}