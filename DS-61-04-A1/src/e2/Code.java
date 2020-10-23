package e2;

public class Code {

    /**
     * Determines whether a keypad is valid. To do this, it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated. If the array
     * (or any of its subarrays) is null it will be returned false.
     * @param keypad The keypad to be analyzed.
     * @return true if it is valid , false otherwise .
     */
    public static boolean isKeypadValid(char[][] keypad) {

        //Alphanumeric keypad
        char[] alphanumeric = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


        if (keypad == null) {
            return false;
        }

        else {

            //Checking if the subarrays are null

            for (int i = 0; i <= keypad.length; i++) {
                if (keypad[i] == null) {
                    return false;
                }
            }


            //Checking that it is a rectangle

            for (int i = 0; i <= keypad.length; i++) {
                if (keypad[i].length != keypad[i+1].length) {  //Comparing dimensions of column i and column i+1
                    return false;
                }
            }


            //Alphanumeric sequence

            int position = 0;

            for (int i = 0; i <= keypad.length; i++) {
                for (int j = 0; j <= keypad[i].length; j++) {

                    if (keypad[i][j] != alphanumeric[position]) {
                        return false;
                    } else {
                        position += 1;
                    }
                }
            }

            //Reversed matrix

            position = 0;


            for (int i = 0; i <= keypad[i].length; i++) {
                for (int j = 0; j <= keypad.length; j++) {
                    if (keypad[j][i] != alphanumeric[position]) {
                        return false;
                    }


                    else {
                            position += 1;
                        }
                    }
                }

            return true;
        }
    }





    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad.
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false.
     * @param movements Array of Strings representing movements.
     * @return true if it is valid, false otherwise.
     */
    public static boolean areMovementsValid(String[] movements) {


        if (movements == null) {
            return false;
        } else {


            char[][] validmov = new char[movements.length][110];


            for (int i = 0; i < movements.length; i++) {

                if (movements[i] == null)
                    return false;


                else {

                    for (i = 0; i < movements.length; i++) {

                        System.arraycopy(movements[i], 0, validmov[i], 0, movements[i].length());

                    }


                    for (i = 0; i < movements.length; i++) {
                        for (int j = 0; j < movements[i].length(); j++) {

                            if (validmov[i][j] != 'U') {
                                return false;
                            }

                            if (validmov[i][j] != 'D') {
                                return false;
                            }

                            if (validmov[i][j] != 'L') {
                                return false;
                            }

                            if (validmov[i][j] != 'R') {
                                return false;
                            }


                        }


                    }


                }
            }

            return true;
        }
    }





        /**
         * Given a keypad and an array of movements, it returns a String with the code
         * resulting from applying the movements on the keypad.
         * @param keypad alphanumeric keypad.
         * @param movements Array with the different movements to be made for each
        number of the key.
         * @return Resulting code.
         * @throws IllegalArgumentException if the keypad of the movements are invalid.
         */
        public static String obtainCode ( char[][] keypad, String[] movements){/* ... */

            char[][] validmov = new char[movements.length][110];


            for(int i=0; i< movements.length;i++){

                System.arraycopy(movements[i],0,validmov[i],0,movements[i].length());
            }


            StringBuffer direct= new StringBuffer(110);

            int a,b;
            a=0;
            b=0;

            for( int i=0;i< movements.length;i++){
                for(int j=0; j<movements[i].length();j++){


                    while(validmov[i][j]== 'U') {
                        if (b>=1 || b<= -1) {
                            b -= 1;
                        }
                    }


                    while(validmov[i][j] == 'D'){

                        if(b!= keypad.length-1){
                            b+=1;
                        }
                    }

                    while (validmov[i][j] == 'L') {
                        if(a>=1 || a<= -1){
                            a-=1;
                        }
                    }


                    while (validmov[i][j]== 'R'){
                        if(a!= keypad[0].length-1){
                            a+=1;
                        }
                    }


                    }

                direct.append(keypad[b][a]);


                }
            return direct.toString();

            }

        }

