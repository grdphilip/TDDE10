class Main {

    public static void main(String[] args) {


        Animal kurre = new Cat("Kurre", 15);
        Animal vilma = new Dog("Vilma", 10);
        Animal pippi = new Bird("Pippi", 6);
        Animal bella = new Butterfly("Bella", 9);

        Toy ball = new Toy("Boll");
        Toy shoe = new Toy("Tuggsko");
        Toy mouse = new Toy("Plastmus");


        House house = new House();

        kurre.setFriend(vilma);
        vilma.setFriend(pippi);
        pippi.setFriend(kurre);

        kurre.addToy(ball);
        kurre.addToy(mouse);
        vilma.addToy(shoe);
        vilma.addToy(ball);

        house.addAnimal(kurre);
        house.addAnimal(vilma);
        house.addAnimal(pippi);
        house.addAnimal(bella);

        house.print();
        
        vilma.introduceYourself();

      }
}

//        System.out.println("==== Djuren introducerar sig ====");
//        kurre.introduceYourself();
        //  vilma.introduceYourself();
//        pippi.introduceYourself();
//        bella.introduceYourself();

//        Animal[] allAnimals = new Animal[4];
//        allAnimals[0] = kurre;
//        allAnimals[1] = vilma;
//        allAnimals[2] = pippi;
//        allAnimals[3] = bella;
//
//        System.out.println("==== Djuren gör sina ljud ====");
//        for (int i = 0; i < allAnimals.length ; i++) {
//            allAnimals[i].makeSound();
//        }
//
//        System.out.println("==== Djuren flyger (om de kan) ====");
//        for (int i = 0; i < allAnimals.length ; i++) {
//          allAnimals[i].fly();
//        }
