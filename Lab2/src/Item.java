
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Item {

    private String name;
    private String description;
    private boolean isWearable;
    private int sneak = 0;
    private String cmd;

    public Item(String name, String description, int atributes, String cmd) {
        this.name = name;
        this.description = description;

    }

    public abstract void doCommand(String cmd);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void describeYourself() {
        System.out.println(name);
        System.out.println(description);
    }

    public boolean isWearable() {
        return isWearable;
    }

    public void setWearable(boolean isWearable) {
        this.isWearable = isWearable;
    }

    public int getSneak() {
        return sneak;
    }

    public void setSneak(int sneak) {
        this.sneak = sneak;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd; 
        
    }

	public void attack(String string, ArrayList<NPC> npcs) {
		// TODO Auto-generated method stub
		
	}
    
  
}


