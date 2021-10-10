import java.util.*;

public class OutdoorsArea extends Location {

    private ArrayList<String> weathers;
    // private String weather;
    int min = 1;
    int max = 4;

    OutdoorsArea(String name, String shortDescription, String longDescription) {
        super(name, shortDescription, longDescription);
        weathers = new ArrayList<String>();
        weathers.add("rain");
        weathers.add("sunny");
        weathers.add("freaking disgusting");
        weathers.add("windy");
    }

    public void doCommand(String command) {

    }

    private static int randWeather(int min, int max) {

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void describeYourself() {
        if (hasBeen() == true) {
            System.out.println(getName() + " " + getShortDescription());
            System.out.println("The weather is: " + weathers.get(randWeather(min, max)));
        } else {
            System.out.println(getName() + " " + getLongDescription());
            System.out.println("The weather is: " + weathers.get(randWeather(min, max)));

        }
    }

    void nearbyLocation(String string, Location freeedom) {

    }

    public int randJump(Location location, int sneakySneak) {

        int min = 1;
        int max = 4;

        if (location.sneakyCheck(sneakySneak)) {
            if (sneakySneak > 100) {
                max = max - 2;
            }
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

}