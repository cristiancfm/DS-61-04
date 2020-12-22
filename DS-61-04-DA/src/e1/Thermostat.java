package e1;


public class Thermostat {
    private float currentTemperature;
    private boolean on;
    private State state;
    private String eventLog;


    //Getters and setters

    public void setOn(boolean on){
        this.on = on;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getEventLog() {
        return eventLog;
    }

    public void addToEventLog(String string){
        StringBuilder tmp = new StringBuilder(eventLog);
        if (string != null){
            tmp.append(string + "\n");
        }
        eventLog = tmp.toString();
    }

    public void resetEventLog(){
        eventLog = "";
    }





    public Thermostat(){
        this.state = Off.getInstance();
        this.currentTemperature = 0;
        this.eventLog = "";
    }

    public void newTemperature(float currentTemperature){
        this.currentTemperature = currentTemperature;
        this.addToEventLog(state.update(this));
    }
    public float getCurrentTemperature(){
        return currentTemperature;
    }


    public String screenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(currentTemperature);
        if(on)
            sb.append(" ON ") ;
        else
            sb.append(" OFF ") ;

        sb.append(state.info());

        return sb.toString();
    }

    public void switchState(State state){
        this.addToEventLog(state.switchState(this));
        this.addToEventLog(state.update(this));
    }


}