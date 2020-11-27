package e1;

public abstract class Hero extends GameCharacter {

    public Hero (String name, int energy, int armorLevel){
        super(name, energy, armorLevel);
    }


    public void setAttackForce(boolean useLoadedDice){
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        if(useLoadedDice){
            dice1.setLoadedValue(50,101); //it sets the number 90
            dice2.setLoadedValue(50,101);
        }
        else{
            dice1.setRandomValue(101);  //set a number between 0 and 100
            dice2.setRandomValue(101);
        }

        super.setAttackForce(Math.max(dice1.getValue(), dice2.getValue()));
    }

}
