import java.util.ArrayList;

public class House {

    private ArrayList<Animal> animalList = new ArrayList<Animal>();

    public void addAnimal(Animal animals) {
        animalList.add(animals);
    }

    public void print() {
        System.out.println("Följande djur finns i huset:");
        System.out.println();
        for (int i = 0; i < animalList.size(); i++) {
            animalList.get(i).print();
        }

    }

}