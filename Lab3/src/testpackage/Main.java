package testpackage;

import myutil.*;

public class Main {

    MyStack<Integer> sList;

    public static void main(String[] args) {

        MyStack<Integer> stackList = new MyStack<Integer>();
       // MyQueue<Integer> queueList = new MyQueue<Integer>();
        
        System.out.println("Mäktiga stacken");
        stackList.push(2);
        stackList.push(1);
        stackList.push(45);
        stackList.push(12);
        
        while (!stackList.isEmpty()) {
        	try {
        System.out.println(stackList.pop());
        	} catch (MyException e) {
        	System.out.println(e.getMessage());
        		
        	}
        
        }
        System.out.println("Antal element i listan " + stackList.size());
        System.out.println("");
        

    }

}
