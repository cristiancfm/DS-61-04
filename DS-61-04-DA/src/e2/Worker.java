package e2;

import java.util.ArrayList;
import java.util.List;

public class Worker extends TeamElement{
    private final float costPerHour;
    private float hours = 0;

    //Constructor
    public Worker(String name, int costPerHour) {
        super(name);
        this.costPerHour = costPerHour;
    }


    public float getCostPerHour() {
        return costPerHour;
    }

    @Override
    public float getTotalCost(){
        return (costPerHour * hours);
    }


    @Override
    public float getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void addHours(int hours) {
        this.hours = this.hours + hours;
    }


    @Override
    public String getString() {
        return ("Worker " + this.getName() + ": " + String.format("%.1f", this.getHours()) + " hours, " +
                String.format("%.1f", this.getTotalCost()) + " €\n");
    }

}
