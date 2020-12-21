package e2;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final String name;
    private List<Team> teamsList;

    //Constructor
    public Project(String name) {
        this.name = name;
        this.teamsList = new ArrayList<>();
    }

    //Other methods
    public String getName() {
        return name;
    }

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public Team getTeam(String name) {
        for(Team team : this.getTeamsList()){
            if(team.getName().equals(name)){
                return team;
            }
        }
        return null;
    }

    public void addTeam(Team team) {
        this.teamsList.add(team);
    }

    public void removeTeam(String name) {
        this.teamsList.removeIf(team -> team.getName().equals(name));
    }

    public List<Worker> getCoworkers(){
        List<Worker> coworkersList = new ArrayList<>();

        for(Team team : teamsList){
            coworkersList.addAll(team.getCoworkers());
        }

        return coworkersList;
    }


}
