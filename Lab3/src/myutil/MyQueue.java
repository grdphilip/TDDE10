package myutil;

public class MyQueue<E> {
	
		 
	    private Node<E> first;
	    private Node<E> last;
	    
	    private int size = 0;
	 
	
	    
	    	
	    
	
	// En queue är två stackar efter varandra, Rita upp, du skickar in till en stack och sen vidare till
	    //en annan stack. Du kommer använda first(top) och last(botten)

	    public E peek() {
	    	return this.first.getData();
	    	
	    }
	    
	    public void enqueue(E data) {
	    	if (!isEmpty()) {
	    		Node<E> temp = new Node<E> (data);
	    		last.setNext(temp);
	    		last = temp; // Skickar längst bak i kön
	    		System.out.println(temp.getData());
	    		size++; // Annars är sizen bara elementet temp hela tiden
	    		
	  
	    	} else { 
	    		Node<E> temp = new Node<E> (data);
	    		first = temp;
	    		last = temp;
	    		System.out.println(first.getData());
	    		size++;
	    		 		
	    	}
	    	
	    }
	    
		public E dequeue() throws Exception {
			if (!isEmpty()) {
				E temp = this.first.getData();
				first = first.getNext();
				size--;
				System.out.println(temp);
				return temp;
			
			} else { 
				throw new MyException("The stack is Empty");
			}
		
	    }
	    
	        //Kastar exception on det inte finns något att avköa
	        
	    public boolean isEmpty() {
			return (size == 0);
	    	
	    }
	        
	    public int size() {
	    	
			return size;
	    	
	    }
	    
	    public Node<E> getFirst() {
			return first;
		}

		public void setFirst(Node<E> first) {
			this.first = first;
		}

		public Node<E> getLast() {
			return last;
		}

		public void setLast(Node<E> last) {
			this.last = last;
		}
	    

}





	

