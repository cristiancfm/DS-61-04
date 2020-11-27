package e1;

import java.util.Random;

public class Dice {

    private int value;

    //Getters and setters
    public int getValue() {
        return value;
    }

    public void setRandomValue(int bound) {
        Random randomSelector = new Random();
        this.value = randomSelector.nextInt(bound);
    }


    public void setLoadedValue(long seed, int bound){
        Random randomSelector = new Random(seed);
        this.value = randomSelector.nextInt(bound);
    }


}
