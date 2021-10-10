package myutil;

public class MyStack<E> {
	
	private Node<E> current;
	private int size = 0;

	
	public void push(E e) {
		
		Node<E> node = new Node<>(e, current);
		 current = node;
		 ++size;
		 System.out.println(current.getData());
		}
	
	
	public E pop() throws MyException { 
		if (!isEmpty()) {
			E value = current.getData();
			current = current.getNext();
			size--;
	
			return value;
		} else { 
			throw new MyException("The stack is Empty");
		}
	}
	

	
	public boolean isEmpty() {
		
		return(size == 0); 
}
	
	public int size() {
		return size;
	}
	
}
