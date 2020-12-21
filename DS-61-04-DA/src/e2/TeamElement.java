package e2;

public abstract class TeamElement {
    private final String name;
    private static int level = 0;


    public TeamElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() { return level; }

    public void addLevel() { level++; }

    public void subtractLevel() { level--; }

    public abstract float getHours();

    public abstract float getTotalCost();

    public abstract String getString();
}
