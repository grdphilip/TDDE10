package testpackage;
import myutil.*;

public class TestHashMap {
	
	public static <K, V> void main (String[] args) throws Exception {
		
	
		
		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
		map.put("Philip", 1);
		map.put("Adam", 2);
		map.put("Kalle", 3);
		map.put("Johan", 4);
		

			System.out.println(map.get("Philip"));
			
			
			
	
	}
	
	
}

	


