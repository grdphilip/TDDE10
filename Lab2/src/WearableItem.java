public class WearableItem extends Item{
	
	private boolean gotUniform = false;

 

    public WearableItem(String name, String description, int atributes, String cmd) {
        super(name, description, atributes, cmd);
        super.setSneak(100);
        setWearable(true);
    }

    public void doCommand(String cmd) {

    }
    

		
    	
    	
    	
    



}


