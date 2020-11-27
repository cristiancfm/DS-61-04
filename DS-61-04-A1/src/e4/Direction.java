package e4;

public enum Direction {
    NORTH("NORTH"),
    SOUTH("SOUTH"),
    EAST("EAST"),
    WEST("WEST");

    private String direction;

    //Constructor method
    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return direction;
    }
}
