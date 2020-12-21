package e2;

import java.util.ArrayList;
import java.util.List;

public class Team extends TeamElement{
    private List<TeamElement> elementsList;

    //Constructor
    public Team(String name) {
        super(name);
        this.elementsList = new ArrayList<>();
    }

    //Other methods
    public List<TeamElement> getElementsList(){
        return elementsList;
    }

    public Worker getWorker(String name) {

        for(TeamElement element : elementsList){
            if(element.getName().equals(name) && element instanceof Worker){
               return (Worker) element;
            }
        }
        return null;
    }

    public void addWorker(Worker worker) {
        this.elementsList.add(worker);
    }

    public void removeWorker(String name) {
        this.elementsList.removeIf(element -> (element.getName().equals(name) && element instanceof Worker));
    }

    public Team getSubteam(String name) {

        for(TeamElement element : this.elementsList){
            if(element.getName().equals(name) && element instanceof Team){
                return (Team) element;
            }
        }
        return null;
    }

    public void addSubteam(Team team) {
        this.elementsList.add(team);
    }

    public void removeSubteam(String name) {
        this.elementsList.removeIf(element -> (element.getName().equals(name) && element instanceof Team));
    }

    @Override
    public float getHours(){
        float totalHours = 0;
        
        for (TeamElement element : elementsList) {
            totalHours += element.getHours();
        }

        return totalHours;
    }

    @Override
    public float getTotalCost(){
        float totalCost = 0;

        for (TeamElement element : elementsList) {
            totalCost += element.getTotalCost();
        }

        return totalCost;
    }

    @Override
    public String getString() { 
        StringBuilder teamString = new StringBuilder();

        //team
        for(int i=1; i <= this.getLevel(); i++){
            teamString.append("\t");
        }
        teamString.append("Team " + this.getName() + ": " +  String.format("%.1f ", this.getHours())
                + "hours, " +  String.format("%.1f ", this.getTotalCost()) + "€\n");

        //workers in the team
        for(TeamElement element : elementsList) {

            if(element instanceof Worker){

                for(int i=1; i <= this.getLevel(); i++){
                    teamString.append("\t");
                }
                teamString.append("\t" + element.getString());
            }
        }

        //subteams in the team
        for(TeamElement element : elementsList) {

            if(element instanceof Team){
                this.addLevel();
                teamString.append(element.getString());
                this.subtractLevel();
            }
        }

        return teamString.toString();
    }


    public List<Worker> getCoworkers() {
        List<Worker> coworkersList = new ArrayList<>();

        for(TeamElement element : elementsList){
            if(element instanceof Worker){
                coworkersList.add((Worker) element);
            }
            if(element instanceof Team){
                coworkersList.addAll(((Team) element).getCoworkers());
            }
        }

        return coworkersList;
    }
}
