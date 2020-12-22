package e1;

public class Program implements State {
    private final float signed;

    public Program(float signed){
        this.signed = signed;
    }

    @Override
    public String update(Thermostat thermostat) {
        if(thermostat.getCurrentTemperature()<signed){


            thermostat.setOn(true);
            return (thermostat.getCurrentTemperature()
                    +" Program mode (at "+signed+
                    " degrees) - Heating is on.");


        }else{
            thermostat.setOn(false);
            return (thermostat.getCurrentTemperature()
                    +" Program mode (at "+signed+
                    " degrees) - Heating is off.");
        }
    }

    @Override
    public String switchState(Thermostat thermostat) {
        if(thermostat.getState() instanceof Timer){
            thermostat.switchState(Off.getInstance());
        }
        thermostat.setState(this);

        if(thermostat.getCurrentTemperature()<signed)
            thermostat.setOn(true);
        else
            thermostat.setOn(false);

        return ("Program mode is activated at "+
                signed+ " degrees.");
    }

    @Override
    public String info() {
        return ("P "+signed);
    }
}