import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
	// private sneak sneak = 100;
	private Scanner keyboard;
	private Player player;
	private ArrayList<Location> location;

	public Game() {
		keyboard = new Scanner(System.in);
		location = new ArrayList<Location>();

		Location startingLocation = new Room("Cell!",
				"Your cell door is not the optimal path, find another way if you can",
				"\nThree years in this hellhole of a cell. \nThe rock hard bed and the light beam from cellblock has been your awful reality, until tonight. \nLook for items and find way out, the cell door might not be the optimal path \nMove 'east' to go out the cell door to Cell Block! ");

		Location cellBlock = new Room("Cell Block!",
				"Move 'west' to go back into your cell.\nMove 'north' to head out to the Common Area\n",
				"An isle seen so many times before, \nMove 'west' to go back into your cell.\nMove 'north' to head out to the Common Area\n");

		Location secretPath = new Room("Secret Path!",
				"A secret passage to the roof 'north' \nor you can chicken out and go back to your cell 'east'!",
				"You've successfully made your way in to a \nsecret path, look for hidden Items\navoid being caught by the guards \nA secret passage to the roof 'north' \nor you can chicken out and go back to your cell 'east'!\n");

		Location commonArea = new Room("Common area", "Move 'north' to proceed out to the yard \nor 'south' to head back to cell block.",
				"The main block, but wait!? Why is the warden down here? \nMove 'north' to proceed out to the yard \nor 'south' to head back to cell block.\n ");

		Location yard = new OutdoorsArea("Yard!", "You can make a run for it 'north'\nclimb up to the roof 'east' \nor crawl back into your cave 'south'!",
				"\nYou can almost smell you're freedom, not far left! \nThere are two guards towers with a clear vision over the yard... \nYou can make a run for it 'north'\\nclimb up to the roof 'east' \nor crawl back into your cave 'south'! ");

		Location roof = new OutdoorsArea("Roof!", "I wonder if you could jump... ",
				"If the walls could talk you wouldn't hear them\nbecause you've made your way up to the roof! \nThere is a ladder leading down to the yard \nbut I wonder if you could jump... ");

		Location freedom = new OutdoorsArea("Freedom!", "Congratulations, enjoy the outside",
				"There has been an honor to follow your journey, you made it! ! \nGood boy!");

		location.add(startingLocation);
		location.add(cellBlock);
		location.add(secretPath);
		location.add(commonArea);
		location.add(yard);
		location.add(roof);
		location.add(freedom);

		startingLocation.addNeighbour("west", secretPath);
		startingLocation.addNeighbour("east", cellBlock);

		secretPath.addNeighbour("east", startingLocation);
		secretPath.addNeighbour("north", roof);

		roof.addNeighbour("south", secretPath);
		roof.addNeighbour("east", yard);
		roof.addNeighbour("west", freedom);

		yard.addNeighbour("west", roof);
		yard.addNeighbour("north", freedom);
		yard.addNeighbour("south", commonArea);

		cellBlock.addNeighbour("west", startingLocation);
		cellBlock.addNeighbour("north", commonArea);

		commonArea.addNeighbour("south", cellBlock);
		commonArea.addNeighbour("north", yard);

		freedom.addNeighbour("south", yard);
		freedom.addNeighbour("east", roof);

		Item guardsUniform = new WearableItem("guards-uniform", "\nSometimes you have to dress lika a pig to blend in with the boars", 50, "1");
		Item painKillers = new Tool("painkillers", "The prisons local currency may help you fight in headwinds\n", 50, "2");
		Item airMax = new WearableItem("airMax", "Rumors are in sweden they're called ainastudasare, \nbut Darwin beats Einstein within these walls\nReduces fall impact significantly, jumping of the roof may work", 1, "3");
		Item shank = new Weapon("shank", "Martha Stewart inspired, made out of a coam. \n", 1000, "4");
		Item screwDriver = new Tool("screwdriver", "Can be used to dismantle your toilet in cell and move west\n", 100, "5");

		location.get(0).addItem(screwDriver);
		location.get(3).addItem(guardsUniform);
		location.get(0).addItem(airMax);
		location.get(1).addItem(painKillers);
		location.get(2).addItem(shank);

		NPC lillJonny = new Enemy("Lill-Jånny", roof, 1500,
				"Lill-Jånny, the meanest of them all, convicted of 12 murders and he wants to add you to the list!!");
		NPC guards = new Enemy("Guards", yard, 200,
				"Guards are roaming the yard");
		NPC warden = new Person("Warden", commonArea, 100, "Sometimes warm handshake feels better than a cold shank");

		location.get(5).addNpc(lillJonny);
		location.get(4).addNpc(guards);
		location.get(3).addNpc(warden);
	
	}

	public void run() throws InterruptedException {

		System.out.print("State your name, convict.");
		String name = keyboard.nextLine();
		player = new Player(name);
		System.out.println("Hello " + name);
		TimeUnit.SECONDS.sleep(2);
		System.out.println(
				"\nYou've been innocently convicted of a hideous crime \nand you're currently located in a 2x2 meters cell  "
						+ "\nat maximum security prison facing death row. \nYou're mission is to escape the facility without being caught or killed "
						+ "\nPreparation can only take you so far. After that, you have to take a few leaps of faith.\nUse 'look' to scan a room for Items\nUse 'move + north/east/west/south' to move\nUse 'wear' to put on wearable Items\nUse 'use' to use tools \nType 'help' for instructions");
		TimeUnit.SECONDS.sleep(3);

		System.out.println("\nGame starts now");

		player.setLocation(location.get(0));
		player.getLocation().describeYourself();
		player.getLocation().setBeenThere(true);
		

		while (true) {
			System.out.println("What do you want to do?");
			String command = keyboard.nextLine();
			player.doCommand(command);
		}
	}

}