
import java.util.ArrayList;

public abstract class Animal {

    private String type;
    private String name;
    private int age;
   // private int year;
    private Animal friend;
    private ArrayList<Toy> toyList = new ArrayList<Toy>();
 

    Animal(String name, int age) {
        this.setType(type);
        this.setName(name);
        this.setAge(age);
    }


//    public void setYear(int year) {
//        this.year = year;
//    }

    public void setFriend (Animal friend) {
        this.friend = friend;
    }

    public Animal getFriend () {
        return friend;
    }

    public void addToy(Toy toy) {
        toyList.add(toy);
    }

    public void getToy() {
        for(int i = 0; i < toyList.size(); i++) {
            System.out.print(toyList.get(i).getName() + " ");
        }
    }


    public abstract void introduceYourself();

    public abstract void print();

    public abstract void makeSound();

    public abstract void fly();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
