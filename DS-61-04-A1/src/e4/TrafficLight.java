package e4;

public class TrafficLight {
    private Color color;
    private boolean blink;
    private int time;

    //Constructor
    TrafficLight(Color color, boolean blink, int time){
        this.color = color;
        this.blink = blink;
        this.time = time;
    }

    //Getters and setters
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isBlink() {
        return blink;
    }
    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
}
