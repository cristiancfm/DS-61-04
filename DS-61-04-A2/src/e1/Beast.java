package e1;

public abstract class Beast extends GameCharacter {

    public Beast (String name, int energy, int armorLevel){
        super(name, energy, armorLevel);
    }


    public void setAttackForce(boolean useLoadedDice){
        Dice dice3 = new Dice();

        if(useLoadedDice){
            dice3.setLoadedValue(50,91);    //it sets the number 89
        }
        else{
            dice3.setRandomValue(91);   //set a number between 0 and 90
        }

        super.setAttackForce(dice3.getValue());
    }

}
