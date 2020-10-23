package e4;

public enum Color {
    RED("RED"),
    AMBER("AMBER"),
    GREEN("GREEN");

    private String color;

    //Getters
    public String getColorString() {
        return color;
    }

    //Constructor method
    Color(String color) {
        this.color = color;
    }
}
