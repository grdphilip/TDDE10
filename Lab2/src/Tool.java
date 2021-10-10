public class Tool extends Item {

    public Tool(String name, String description, int atributes, String cmd) {
        super(name, description, atributes, cmd);
        setWearable(false);
    }

    public void doCommand(String cmd) {
        if (cmd.equals("screwdriver")) {
            System.out.println("You can use this to unscrew your toilet and head 'east'.");

        } else if (cmd.equals("painkillers")) {
            System.out.println("Theese doesn't really do anything...");
        }
    }

}