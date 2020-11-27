package e1;

public abstract class GameCharacter {
    private String name;
    private int energy;
    private int armorLevel;
    private int attackForce;

    //Constructor method
    public GameCharacter(String name, int energy, int armorLevel){
        this.name = name;
        this.energy = energy;
        this.armorLevel = armorLevel;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getArmorLevel() {
        return armorLevel;
    }

    public int getAttackForce() {
        return attackForce;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setArmorLevel(int armorLevel) {
        this.armorLevel = armorLevel;
    }

    public void setAttackForce(int attackForce) {
        this.attackForce = attackForce;
    }
}
