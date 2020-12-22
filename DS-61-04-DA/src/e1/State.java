package e1;

public interface State {

    String update(Thermostat thermostat);
    String switchState(Thermostat thermostat);
    String info();

}
