package e3;

import  java.util.ArrayList;
import java.util.List;


public class Gunslinger {

    //Attributes
    private int loads = 0;
    private int Rivalloads =0;
    private  Behavior behavior;


    public ArrayList<GunslingerAction> action = new ArrayList<>();

    ArrayList<GunslingerAction> rivalActions = new ArrayList<>();

    public int getLoads(){ return this.loads; }
    
    public void setLoads(int loads) {
        this.loads = loads;
    }

    public void setRivalloads(int Rivalloads) { this.Rivalloads = Rivalloads; }


    public GunslingerAction action(){

            GunslingerAction action;

            action = behavior.action(this);

            if(action.equals(GunslingerAction.SHOOT)){
                loads--;
            }else if(action.equals(GunslingerAction.RELOAD)){
                loads++;
            }
            return action;
    }




    public void rivalAction(GunslingerAction action){
        getRivalActions().add(action);

    }


    public List<GunslingerAction> getRivalActions(){

      return rivalActions;
    }


    public int getRivalLoads(){

        return this.Rivalloads;
    }


    public void setBehavior(Behavior behavior){

        this.behavior = behavior;
    }


}













