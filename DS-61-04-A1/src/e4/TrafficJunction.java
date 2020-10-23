package e4;

import java.util.EnumMap;

public class TrafficJunction {
    //Create enummap
    private EnumMap<Direction, TrafficLight> junctionMap = new EnumMap<>(Direction.class);

    //Create Traffic Lights
    TrafficLight north = new TrafficLight(Color.GREEN, false, 0);
    TrafficLight south = new TrafficLight(Color.RED, false, 0);
    TrafficLight east = new TrafficLight(Color.RED, false, 0);
    TrafficLight west = new TrafficLight(Color.RED, false, 0);

    /**
     * Creates a traffic junction with four traffic lights named north , south ,
     * east and west . The north traffic light has just started its green cycle .
     */
    public TrafficJunction () {

        junctionMap.put(Direction.NORTH, north);
        junctionMap.put(Direction.SOUTH,south);
        junctionMap.put(Direction.EAST, east);
        junctionMap.put(Direction.WEST, west);
    }

    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy () {

        if(!north.isBlink() || !south.isBlink() || !east.isBlink() || !west.isBlink()) {

            //Time increasing
            if(north.getColor() == Color.GREEN || north.getColor() == Color.AMBER)
                north.setTime(north.getTime() + 1);

            if(south.getColor() == Color.GREEN || south.getColor() == Color.AMBER)
                south.setTime(south.getTime() + 1);

            if(east.getColor() == Color.GREEN || east.getColor() == Color.AMBER)
                east.setTime(east.getTime() + 1);

            if(west.getColor() == Color.GREEN || west.getColor() == Color.AMBER)
                west.setTime(west.getTime() + 1);



            //Change to Yellow
            if(north.getTime() == 16) {
                north.setColor(Color.AMBER);
                north.setTime(0);
            }

            if(south.getTime() == 16) {
                south.setColor(Color.AMBER);
                south.setTime(0);
            }

            if(east.getTime() == 16) {
                east.setColor(Color.AMBER);
                east.setTime(0);
            }

            if(west.getTime() == 16){
                west.setColor(Color.AMBER);
                west.setTime(0);
            }



            //Change to Red and the next traffic light to Green
            if(north.getTime() == 6 && north.getColor() == Color.AMBER) {
                north.setColor(Color.RED);
                north.setTime(0);
                south.setColor(Color.GREEN);
            }

            if(south.getTime() == 6 && south.getColor() == Color.AMBER) {
                south.setColor(Color.RED);
                south.setTime(0);
                east.setColor(Color.GREEN);
            }

            if(east.getTime() == 6 && east.getColor() == Color.AMBER) {
                east.setColor(Color.RED);
                east.setTime(0);
                west.setColor(Color.GREEN);
            }

            if(west.getTime() == 6 && west.getColor() == Color.AMBER) {
                west.setColor(Color.RED);
                west.setTime(0);
                north.setColor(Color.GREEN);
            }


        }


    }

    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     * @param active true or false
     */
    public void amberJunction ( boolean active ) {

        if(active){
            for (Direction currentDir : junctionMap.keySet()) {
                TrafficLight currentTL = junctionMap.get(currentDir);

                currentTL.setColor(Color.AMBER);
                currentTL.setBlink(true);
            }
        }

        if(!active){
            north.setColor(Color.GREEN);
            south.setColor(Color.RED);
            east.setColor(Color.RED);
            west.setColor(Color.RED);

            for (Direction currentDir : junctionMap.keySet()) {
                TrafficLight currentTL = junctionMap.get(currentDir);

                currentTL.setBlink(false);
                currentTL.setTime(0);
            }
        }

    }

    /**
     * Returns a String with the state of the traffic lights .
     * The format for each traffic light is the following :
     * - For red colors : "[ name : RED ]"
     * - For green colors : "[ name : GREEN counter ]"
     * - For yellow colors with blink at OFF : "[ name : YELLOW OFF counter ]
     * - For yellow colors with blink at ON: "[ name : YELLOW ON]
     * Examples :
     * [ NORTH : GREEN 2][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER OFF 5][ SOUTH : RED ][ EAST : RED ][ WEST : RED ]
     * [ NORTH : AMBER ON ][ SOUTH : AMBER ON ][ EAST : AMBER ON ][ WEST : AMBER ON]
     * @return String that represents the state of the traffic lights
     */
    @Override
    public String toString () {

        StringBuilder state = new StringBuilder();

        for (Direction currentDir : junctionMap.keySet()){
            TrafficLight currentTL =  junctionMap.get(currentDir);

            if(currentTL.getColor() == Color.RED)
                state.append("[" + currentDir.toString() + ": " + currentTL.getColor().toString() + "]");

            if(currentTL.getColor() == Color.GREEN)
                state.append("[" + currentDir.toString() + ": " + currentTL.getColor().toString() + " " +
                        currentTL.getTime() + "]");

            if(currentTL.getColor() == Color.AMBER) {
                if(currentTL.isBlink())
                    state.append("[" + currentDir.toString() + ": " + currentTL.getColor().toString() +
                        " ON]");
                else
                    state.append("[" + currentDir.toString() + ": " + currentTL.getColor().toString() +
                            " OFF " + currentTL.getTime() + "]");
            }
        }

        return state.toString();

    }
}