import java.util.ArrayList;

public class Player extends Game {

	private String name;
	private int health;
	private Location currentLocation;
	private ArrayList<Item> itemsInUse;
	private Boolean isWearable = false;
	private Boolean isWearing = false;
	private int sneakySneak = 0;
	private Boolean unscrewed = false;

	public Player(String name) {
		setHealth(100);
		itemsInUse = new ArrayList<Item>();
		int drugs = 100;
		int damage = 50;
		int health = 100;
	}

	public Location getLocation() {
		return this.currentLocation;
	}

	public void setLocation(Location location) {
		this.currentLocation = location;
	}

	void doCommand(String command) {
		if (command.equals("move")) {
			System.out.println("where would you like to go?");
		}

		String[] cmdSplit = command.split(" ");

		if (cmdSplit[0].equals("move")) {

			if (getLocation().hasNeighbour(cmdSplit[1], currentLocation)) {
				Location nextlocation = getLocation().getNeighbour(cmdSplit[1]);

				setLocation(nextlocation);
				currentLocation.describeYourself();
				currentLocation.printNpc();
				currentLocation.setBeenThere(true);

				if (currentLocation.getName().contains("Yard!")) {
					currentLocation.sneakyCheck((sneakySneak));
				}

			} else {
				System.out.println("You can't go that way, try another direction.");

			}
		}
		if (cmdSplit[0].equals("look")) {
			currentLocation.printItem();
			if (currentLocation.getItemsList().isEmpty()) {
				System.out.println("This room is empty!!");
			}
		}

		if (cmdSplit[0].equals("take")) {
			Item removedItem = null;

			for (Item item : currentLocation.getItemsList()) {
				if (item.getName().equals(cmdSplit[1])) {
					addPlayerItem(item);
					removedItem = item;
				}

			}
			if (removedItem == null) {
				System.out.println("This item doesn't exist in this room!!");
			} else {
				System.out.println("You picked up " + removedItem.getName());
				currentLocation.removeItem(removedItem);
			}
		}
		if (cmdSplit[0].equals("wear")) {

			for (Item item : itemsInUse) {
				if (item.isWearable() == true) {
					System.out.println("You put on " + item.getName());
					isWearable = true;
					setSneakySneak(getSneakySneak() + item.getSneak());

				} else {
					
					System.out.println("You can't wear a " + item.getName() + ", use your head.");
					
				}
			}
		}
		if (cmdSplit[0].equals("items")) {
			System.out.println("You have the following items:");
			for (Item item : itemsInUse) {
				System.out.println(item.getName());

			}

		}
		if (cmdSplit[0].equals("use")) {
			for (Item item : itemsInUse) {

				if (cmdSplit[1].equals("painkillers")) {
					setHealth(200);
					item.doCommand(cmdSplit[1]);
					System.out.println(health + " health");
				} else {
					item.doCommand(cmdSplit[1]);
				}

			}
		}

		if (cmdSplit[0].equals("attack")) {

			for (Item item : itemsInUse) {
				if (cmdSplit[1].contains(item.getName())) {
					item.attack(cmdSplit[1], currentLocation.getNpcs());
				}
			}
			
			for (NPC npc : currentLocation.getNpcs()) {
				NPC removedNpc = npc;
				currentLocation.removeNpc(removedNpc);
				break;
			}
		}
		if (currentLocation.getName().equals("Roof!")) {
			if (cmdSplit[0].equals("jump")) {
				currentLocation.randJump(currentLocation, sneakySneak);
			}
		}
		
		if (currentLocation.getName().equals("Freedom!")) {
			currentLocation.describeYourself();
			System.exit(0);
		}

	}

	public boolean beenHere(Location location) {
		return false;
	}

	public String getName() {
		return name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void addPlayerItem(Item item) {
		itemsInUse.add(item);
	}

	public int getSneakySneak() {
		return sneakySneak;
	}

	public void setSneakySneak(int sneakySneak) {
		this.sneakySneak = sneakySneak;
	}

	public int getHealth() {
		return health;
	}

}