package testpackage;

import myutil.*;

public class MyTestList {

    MyList<Integer> linkedList;

    public static void main(String[] args) throws Exception {

        MyList<Integer> testList = new MyList<Integer>();

        System.out.println("Mäktiga Listan");
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);


            try {
                System.out.println(testList.getElementAt(3));
            } catch (MyException e) {
                System.out.println(e.getMessage());

            }
            System.out.println("Antal element i listan " + testList.size());
            

        }

    }
