package e1;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void setDamageCharacteristics(Hero currentHero, Beast currentBeast){
        if(currentHero instanceof Elf){
            if(currentBeast instanceof Orc){
                currentHero.setAttackForce(currentHero.getAttackForce()+10);
            }
        }

        if(currentHero instanceof Hobbit){
            if(currentBeast instanceof Goblin){
                currentHero.setAttackForce(currentHero.getAttackForce()-5);
            }
        }

        if(currentBeast instanceof Orc){
            currentHero.setArmorLevel((int) (currentHero.getArmorLevel() - (currentHero.getArmorLevel()*0.10)));
        }
    }



    public static List<String> battle(boolean useLoadedDice, List<Hero> heroesList, List<Beast> beastsList){

        //Game creation
        int numberOfTurns = 0;
        List<String> gameStrings = new ArrayList<>();

        while(heroesList.size() != 0 && beastsList.size() != 0){

            //Perform a turn
            numberOfTurns++;
            gameStrings.add("Turn " + numberOfTurns + ":");

            int numberOfPairs = Math.min(heroesList.size(), beastsList.size());
            List<Hero> currentTurnHeroesList = new ArrayList<>();
            List<Beast> currentTurnBeastsList = new ArrayList<>();

            //Copy the characters that are going to fight into current turn lists
            for(int i=0; i<numberOfPairs; i++){
                currentTurnHeroesList.add(heroesList.get(i));
                currentTurnBeastsList.add(beastsList.get(i));
            }

            for(int i=0; i<numberOfPairs; i++){

                Hero currentHero = currentTurnHeroesList.get(i);
                Beast currentBeast = currentTurnBeastsList.get(i);


                //Current hero attack force generation
                currentHero.setAttackForce(useLoadedDice);


                //Current beast attack force generation
                currentBeast.setAttackForce(useLoadedDice);


                //Damage characteristics
                setDamageCharacteristics(currentHero, currentBeast);


                //BATTLE!
                //Print current fighters
                gameStrings.add("    Fight between " + currentHero.getName() + " (Energy: " + currentHero.getEnergy()
                        + ") and " + currentBeast.getName() + " (Energy: " + currentBeast.getEnergy() + ")");

                //Calculate resulting energies
                if(currentHero.getAttackForce() > currentBeast.getArmorLevel()){
                    currentBeast.setEnergy(currentBeast.getEnergy() - currentHero.getAttackForce());
                }

                if(currentBeast.getAttackForce() > currentHero.getArmorLevel()){
                    currentHero.setEnergy(currentHero.getEnergy() - currentBeast.getAttackForce());
                }

                //Reset armor level of current hero if the current beast is an Orc
                if(currentBeast instanceof Orc){
                    currentHero.setArmorLevel((int) (currentHero.getArmorLevel() + (currentHero.getArmorLevel()*0.10)));
                }
            }

            //Remove dead characters in the main lists
            for(Hero currentHero: currentTurnHeroesList){
                if(currentHero.getEnergy() <= 0){
                    gameStrings.add("    " + currentHero.getClass().getSimpleName() + " " + currentHero.getName()
                            + " dies");
                    heroesList.remove(currentHero);
                }
            }

            for(Beast currentBeast: currentTurnBeastsList){
                if(currentBeast.getEnergy() <= 0){
                    gameStrings.add("    " + currentBeast.getClass().getSimpleName() + " " + currentBeast.getName()
                            + " dies");
                    beastsList.remove(currentBeast);
                }
            }

            //Empty current turn lists for the next turn
            currentTurnHeroesList.clear();
            currentTurnBeastsList.clear();
        }

        //Print winner army
        if(heroesList.size() != 0) {
            gameStrings.add("HEROES WIN");
        }
        else if(beastsList.size() != 0) {
            gameStrings.add("BEASTS WIN");
        }
        else{
            gameStrings.add("NOBODY WINS");
        }

        return gameStrings;

    }


}
