public abstract class NPC {

    private String name;
    private Location position;
    private int health;
    private String description;

    public NPC(String name, Location position, int health, String description) {
        this.setName(name);
        this.position = position;
        this.setHealth(health);
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void describeYourself() {
        System.out.println(description);
    }

    public abstract void attack();

    public abstract void interactWith();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void removeNpc(NPC removedNpc) {
        position.getNpcs().remove(removedNpc);

    }

}