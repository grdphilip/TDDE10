package testpackage;
import myutil.*;


public class MyQueueTest {
	
	  MyQueue<Integer> qList;
	  
	  public static void main(String[] args) throws Exception {
		  
		  MyQueue<Integer> queueList = new MyQueue<Integer>();
		  
		  System.out.println("Mäktiga kön");
	        queueList.enqueue(1);
	        queueList.enqueue(4);
	        queueList.enqueue(5);
	        queueList.enqueue(7);
	        
	        System.out.println("Kika på första");
	        System.out.println(queueList.peek());
	       
	        
	        System.out.println("Ta bort ett element i taget med början på första");
	        while (!queueList.isEmpty()) {
	        	try {
	        		
	        	queueList.dequeue();
	        	} catch (MyException e) {
	        		System.out.println("Listan är tom");
	        	}
	       }
	        
	        if (queueList.isEmpty()) {
	       System.out.println("Antal element i listan " + queueList.size());
	       
	        }

	  }

}
