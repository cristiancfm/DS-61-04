package e1;

public class Timer implements State {
    private int time;

    public Timer(int time){
        this.time = Math.max(time, 0);
    }

    @Override
    public String update(Thermostat thermostat) {
        State state;
        time-=5;
        if(time<0) {
            state = Off.getInstance();
            thermostat.switchState(state);
            return null;


        }else{
            return (thermostat.getCurrentTemperature()+
                    " Timer mode ("+time+" minutes left)"+
                    " - Heating is on.");
        }
    }

    @Override
    public String switchState(Thermostat thermostat) {
        if(thermostat.getState() instanceof Program){
          thermostat.switchState(Off.getInstance());
        }
        thermostat.setState(this);
        thermostat.setOn(true);
        return ("Timer mode is activated "+
                time+" minutes.");
    }

    @Override
    public String info() {
        return ("T "+time);
    }
}