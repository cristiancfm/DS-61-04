package e3;

public class Defensive implements Behavior{







    @Override
    public GunslingerAction action(Gunslinger g) {


        if(g.getLoads() == 0 || g.getRivalLoads()==0){

            return GunslingerAction.RELOAD;


        } else if(g.getRivalLoads() >=3 ){

            return GunslingerAction.SHOOT;

        }else if(g.getLoads() == 5){
            return GunslingerAction.MACHINEGUN;


        }else{

            return GunslingerAction.PROTECT;
        }


    }
}
