package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkGroupsTest {

    @Test
    public void test(){

        //constructors
        Project fooFighters = new Project("fooFighters");
        Team bandMembers = new Team("bandMembers");
        Team marketing = new Team("marketing");
        Team bandDrummers = new Team("bandDrummers");
        Team bandPianists = new Team("bandPianists");
        Worker daveGrohl = new Worker("daveGrohl", 6);
        Worker taylorHawkins = new Worker("taylorHawkins", 10);
        Worker kurtCobain = new Worker("kurtCobain", 12);

        daveGrohl.setHours(10);
        daveGrohl.addHours(10);
        taylorHawkins.addHours(15);
        kurtCobain.addHours(5);

        fooFighters.addTeam(bandMembers);
        fooFighters.addTeam(marketing);
        fooFighters.getTeam("bandMembers").addSubteam(bandDrummers);
        fooFighters.getTeam("bandMembers").addSubteam(bandPianists);

        fooFighters.getTeam("bandMembers").addWorker(daveGrohl);
        fooFighters.getTeam("bandMembers").getSubteam("bandDrummers").addWorker(taylorHawkins);
        fooFighters.getTeam("marketing").addWorker(kurtCobain);

        /*
        Team bandMembers: 35,0 hours, 270,0 €
		    Worker daveGrohl: 20,0 hours, 120,0 €
		    Team bandDrummers: 15,0 hours, 150,0 €
			    Worker taylorHawkins: 15,0 hours, 150,0 €
		    Team bandPianists: 0,0 hours, 0,0 €

        Team marketing: 5,0 hours, 60,0 €
            Worker kurtCobain: 5,0 hours, 60,0 €
         */


        //getTeam, getWorker, getSubteam
        assertEquals(daveGrohl, fooFighters.getTeam("bandMembers").getWorker("daveGrohl"));
        assertEquals(taylorHawkins, fooFighters.getTeam("bandMembers").getSubteam("bandDrummers").getWorker("taylorHawkins"));


        //getCoworkers
        assertTrue(fooFighters.getCoworkers().contains(daveGrohl));
        assertTrue(fooFighters.getCoworkers().contains(taylorHawkins));
        assertTrue(fooFighters.getCoworkers().contains(kurtCobain));


        //getString, getHours, getTotalCost
        String bandMembersString = "Team bandMembers: 35,0 hours, 270,0 €\n" +
                "\tWorker daveGrohl: 20,0 hours, 120,0 €\n" +
                "\tTeam bandDrummers: 15,0 hours, 150,0 €\n" +
                "\t\tWorker taylorHawkins: 15,0 hours, 150,0 €\n" +
                "\tTeam bandPianists: 0,0 hours, 0,0 €\n";
        assertEquals(bandMembersString, fooFighters.getTeam("bandMembers").getString());



        //removeTeam, removeWorker, removeSubteam
        fooFighters.removeTeam("marketing");
        fooFighters.getTeam("bandMembers").removeWorker("daveGrohl");
        fooFighters.getTeam("bandMembers").removeSubteam("bandPianists");
        assertNotEquals(marketing, fooFighters.getTeam("marketing"));
        assertNotEquals(daveGrohl, fooFighters.getTeam("bandMembers").getWorker("daveGrohl"));
        assertNotEquals(bandDrummers, fooFighters.getTeam("bandMembers").getSubteam("bandPianists"));
    }
}