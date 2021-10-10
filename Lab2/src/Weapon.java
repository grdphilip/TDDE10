import java.util.ArrayList;

public class Weapon extends Item {

    public Weapon(String name, String description, int atributes, String cmd) {
        super(name, description, atributes, cmd);
        setWearable(false);
    }

    public void doCommand(String cmd) {
        System.out.println("You can't -use- weapons you can only attack with them.");
    }

    public void attack(String cmd, ArrayList<NPC> npcs) {
        for (NPC npc : npcs) {
            npc.setHealth(0);
            if (npc.getHealth() < 1) {
                System.out.println("You 'got rid off' Lill-Jånny, you may now continue!");
            }
        } 

    }

}