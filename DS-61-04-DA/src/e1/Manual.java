package e1;

public class Manual implements State {
    private static final Manual instance = new Manual();

    private Manual(){ }

    public static State getInstance() {
        return instance;
    }

    @Override
    public String update(Thermostat thermostat) {
        return (thermostat.getCurrentTemperature()+
                " Manual mode - Heating is on.");
    }

    @Override
    public String switchState(Thermostat thermostat) {
        thermostat.setState(this);
        thermostat.setOn(true);
        return ("Manual mode is activated.");
    }

    @Override
    public String info() {
        return ("M");
    }
}