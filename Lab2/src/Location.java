import java.util.ArrayList;
import java.util.HashMap;

public abstract class Location {

	private String longDescription;
	private String shortDescription;
	private String name;
	private Boolean beenThere = false;
	private ArrayList<Item> itemsList;
	private ArrayList<NPC> npcs;
//	private HashMap<String, Location> paths = new HashMap<String, Location>();
	private HashMap<String, Location> neighbours = new HashMap<String, Location>();

	Location(String name, String shortDescription, String longDescription) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		setItemsList(new ArrayList<Item>());
		setNpcs(new ArrayList<NPC>());
	}

	public Location(String name) {

	}

	public HashMap<String, String> location = new HashMap<String, String>();

	public abstract void describeYourself();
	
	public abstract void doCommand(String command);
	

	public void addNeighbour(String string, Location neighbour) {
		getNeighbour().put(string, neighbour);
	}

	abstract void nearbyLocation(String string, Location neighbour);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public HashMap<String, Location> getNeighbour() {
		return neighbours;
	}

	public void setNeighbour(HashMap<String, Location> neighbours) {
		this.neighbours = neighbours;
	}

	public Boolean hasNeighbour(String direction, Location currentLocation) {
		if (currentLocation.neighbours.containsKey(direction)) {
			return true;
		}
		return false;
	}

	public Location getNeighbour(String string) {
		return neighbours.get(string);
	}

	public Boolean hasBeen() {
		return beenThere;
	}

	public Boolean getBeenThere() {
		return beenThere;
	}

	public void setBeenThere(Boolean beenThere) {
		this.beenThere = beenThere;
	}

	public void removeItem(Item item) {
		getItemsList().remove(item);
	}

	public void printItem() {
		for (Item it : getItemsList()) {
			it.describeYourself();
		}
	}

	public void addItem(Item item) {
		getItemsList().add(item);

	}

	public ArrayList<Item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(ArrayList<Item> itemsList) {
		this.itemsList = itemsList;
	}

	public void addNpc(NPC npc) {
		getNpcs().add(npc);
	}

	public ArrayList<NPC> getNpcs() {
		return npcs;
	}

	public void setNpcs(ArrayList<NPC> npcs) {
		this.npcs = npcs;
	}

	public void removeNpc(NPC npc) {
		getNpcs().remove(npc);
	}

	public void printNpc() {
		for (NPC npc : getNpcs()) {
			npc.describeYourself();
		}
	}

	public boolean sneakyCheck(int sneakySneak) {
		if (sneakySneak < 299) {
			System.out.println("You got shot the second you stepped out, game over!");
			System.exit(0);
		} else {
			System.out.println("luckily you have your uniform on you! ");
		}
		return true;
	}
	
	public abstract int randJump(Location location, int sneakySneak); 

}
