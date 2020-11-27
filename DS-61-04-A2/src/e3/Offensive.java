package e3;

public class Offensive implements Behavior {

    @Override
    public GunslingerAction action(Gunslinger g) {

        if (g.getRivalLoads() == 0) {

            return GunslingerAction.RELOAD;

        } else if (g.getLoads() == 0 || g.getLoads() == 4) {

            return GunslingerAction.RELOAD;

        } else if (g.getRivalLoads() >= 4 ) {

            return GunslingerAction.PROTECT;

        } else if (g.getLoads() == 5) {

            return GunslingerAction.MACHINEGUN;

        } else {

            return GunslingerAction.SHOOT;
        }

    }
}