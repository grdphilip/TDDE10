public class Room extends Location {

    private int size;

    public Room(String name, String shortDescription, String longDescription) {
        super(name, shortDescription, longDescription);

    }

    public void describeYourself() {
        if (hasBeen() == true) {
            System.out.println(getName() + " " + getShortDescription());
        } else {
            System.out.println(getName() + " " + getLongDescription());
        }
    }

    public void doCommand(String command) {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void checkWeather(String command) {

    }

    void nearbyLocation(String string, Location freeedom) {

    }

	@Override
	public int randJump(Location location, int sneakySneak) {
		// TODO Auto-generated method stub
		return 0;
	}

}