package myutil;

public class MyList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> iterator; // bör vara lokal

    public void add(E data) {
        if (isEmpty()) {
            Node<E> temp = new Node<E>(data);
            head = temp;
            iterator = head;
            System.out.println(temp.getData());
            size++;
        } else {
            head.setNext(new Node<E>(data));
            head = head.getNext();
            System.out.println(head.getData());
            size++;
        }

    }

    public E getElementAt(int i) throws MyException {
        if (size > i) {
            int index = 0;
            while (index < i) {
                iterator = iterator.getNext();
                index++;

            }
            System.out.println("Element på plats " + i + ":");
            return iterator.getData();
        } else {
            throw new MyException("Index out of bounds");
        }
    }
    
    public E getElementAtMap(int i) throws MyException {
        if (size > i) {
            int index = 0;
            while (index < i) {
                iterator = iterator.getNext();
                index++;

            }
            return iterator.getData();
        } else {
            throw new MyException("Index out of bounds");
        }
    }

    public boolean isEmpty() {

        return size == 0;

    }

    public int size() {
        return size;
    }

    
	private Node<E> getFirst() {

		return head;
	}
	
	public int getIndex(E data) {
        Node<E> temp = this.getFirst();
        if (temp == null) {
            return 0;
        }
        int i = 0;
        while (!temp.getData().equals(data)) {

            temp = temp.getNext();
            i++;
            if (temp == null) {
                return 0;
            }
        }

        return i;
    }

}
