package e3;

import java.util.ArrayList;
import java.util.List;


public class Gunfight {



    public static List<String> duel(Gunslinger g1, Gunslinger g2){



        int turns=1;
        int count=0;
        List<String> gameStrings = new ArrayList<>();




        while( turns<=50 && count<=0){


            gameStrings.add("Round "+turns+"--------------------");

            turns++;



            if(g1.action() ==  GunslingerAction.RELOAD ) {

                gameStrings.add("Gunslinger 1 : RELOAD");

                if (g2.action() == GunslingerAction.SHOOT) {
                    gameStrings.add("Gunslinger 2 : SHOOT");
                    gameStrings.add("WINNER : GUNSLINGER 2\n");
                    count = 1;
                    g1.rivalAction(GunslingerAction.SHOOT);
                    g2.setLoads(g2.getLoads() - 1);
                    g1.setRivalloads(g1.getRivalLoads() - 1);

                } else if (g2.action() == GunslingerAction.PROTECT) {

                    gameStrings.add("Gunslinger 2 : PROTECT");

                    gameStrings.add("The duel continues...");

                    g1.rivalAction(GunslingerAction.PROTECT);


                } else if (g2.action() == GunslingerAction.RELOAD) {
                    gameStrings.add("Gunslinger 2 : RELOAD");
                    gameStrings.add("The duel continues...");
                    g1.rivalAction(GunslingerAction.RELOAD);
                    g2.setLoads(g2.getLoads() + 1);
                    g1.setRivalloads(g1.getRivalLoads() + 1);


                } else if (g2.action() == GunslingerAction.MACHINEGUN) {

                    gameStrings.add("Gunslinger 2 : MACHINE-GUN");
                    gameStrings.add("WINNER : GUNSLINGER 2");
                    count = 2;
                    g1.rivalAction(GunslingerAction.MACHINEGUN);
                }

            break;

            }
            else if (g1.action() == GunslingerAction.SHOOT) {

                gameStrings.add("Gunslinger 1 : SHOOT");

                if (g2.action() == GunslingerAction.SHOOT) {

                    gameStrings.add("Gunslinger 2 : SHOOT");

                    gameStrings.add("Stalemate\n");

                    g1.rivalAction(GunslingerAction.SHOOT);
                    g2.setLoads(g2.getLoads() - 1);
                    g1.setRivalloads(g1.getRivalLoads() - 1);
                    count = 3;


                } else if (g2.action() == GunslingerAction.RELOAD) {

                    gameStrings.add("Gunslinger 2 : RELOAD");
                    gameStrings.add("WINNER : GUNSLINGER 1");
                    g1.rivalAction(GunslingerAction.RELOAD);
                    g2.setLoads(g2.getLoads() + 1);
                    g1.setRivalloads(g1.getRivalLoads() + 1);
                    count = 2;


                } else if (g2.action() == GunslingerAction.PROTECT) {


                    gameStrings.add("Gunslinger 2 : PROTECT");
                    gameStrings.add("The duel continues...");
                    g1.rivalAction(GunslingerAction.PROTECT);


                } else if (g2.action() == GunslingerAction.MACHINEGUN) {


                    gameStrings.add("Gunslinger 2 : MACHINE-GUN");
                    gameStrings.add("WINNER : GUNSLINGER 2");

                    count =3;

                    g1.rivalAction(GunslingerAction.MACHINEGUN);


                }

             break;

            }
            else if(g1.action() == GunslingerAction.PROTECT) {

                gameStrings.add("Gunslinger 1 : PROTECT");

                if (g2.action() == GunslingerAction.PROTECT) {

                    gameStrings.add(" Gunslinger 2 : PROTECT");
                    gameStrings.add("The duel continues...");
                    g1.rivalAction(GunslingerAction.PROTECT);


                } else if (g2.action() == GunslingerAction.SHOOT) {


                    gameStrings.add("Gunslinger 2 : SHOOT");
                    gameStrings.add("The duel continues...");
                    g1.rivalAction(GunslingerAction.SHOOT);
                    g2.setLoads(g2.getLoads() - 1);
                    g1.setRivalloads(g1.getRivalLoads() - 1);


                } else if (g2.action() == GunslingerAction.RELOAD) {


                    gameStrings.add("Gunslinger 2 : RELOAD");
                    gameStrings.add("The duel continues...");
                    g1.rivalAction(GunslingerAction.RELOAD);
                    g2.setLoads(g2.getLoads() + 1);
                    g1.setRivalloads(g1.getRivalLoads() + 1);


                } else if (g2.action() == GunslingerAction.MACHINEGUN) {

                    gameStrings.add("Gunslinger 2: MACHINE-GUN");
                    gameStrings.add("WINNER : GUNSLINGER 2");
                    count = 1;
                    g1.rivalAction(GunslingerAction.MACHINEGUN);


                }

            break;

            }
            else if(g1.action() == GunslingerAction.MACHINEGUN){

                gameStrings.add("Gunslinger 1 : MACHINE-GUN");

                if (g2.action() == GunslingerAction.SHOOT) {
                    gameStrings.add("Gunslinger 2 : SHOOT");
                    gameStrings.add("WINNER : GUNSLINGER 1\n");
                    g1.rivalAction(GunslingerAction.SHOOT);
                    g2.setLoads(g2.getLoads() - 1);
                    g1.setRivalloads(g1.getRivalLoads() - 1);


                }
                else if (g2.action() == GunslingerAction.PROTECT) {

                    gameStrings.add("Gunslinger 2 : PROTECT");
                    gameStrings.add("WINNER : GUNSLINGER 1");
                    g1.rivalAction(GunslingerAction.PROTECT);



                } else if (g2.action() == GunslingerAction.RELOAD) {
                    gameStrings.add("Gunslinger 2 : RELOAD");
                    gameStrings.add("WINNER : GUNSLINGER 1");
                    g1.rivalAction(GunslingerAction.RELOAD);
                    g2.setLoads(g2.getLoads() + 1);
                    g1.setRivalloads(g1.getRivalLoads() + 1);



                } else if (g2.action() == GunslingerAction.MACHINEGUN) {

                    gameStrings.add("Gunslinger 2 : MACHINE-GUN");
                    gameStrings.add("Stalemate\n");
                    g1.rivalAction(GunslingerAction.MACHINEGUN);
                    count =1;
                }


            }
        }

        return gameStrings;

    }

}
