package e1;

public class Off implements State {
    private static final Off instance = new Off();

    private Off(){ }

    public static State getInstance() {
        return instance;
    }

    @Override
    public String update(Thermostat thermostat) {
         return (thermostat.getCurrentTemperature()+
                " Off mode - Heating is off.");
    }

    @Override
    public String switchState(Thermostat thermostat) {
        thermostat.setState(this);
        thermostat.setOn(false);
        return ("Off mode is activated.");
    }

    @Override
    public String info() {
        return ("O");
    }
}