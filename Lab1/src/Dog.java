public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    public void introduceYourself() {
        System.out.println("Vovv!!!. Jag är en hund som kallas " + getName() + ".");
        System.out.println("Jag är " + getAge() + " år gammal.");
    }

    public void makeSound() {
        System.out.println("Vov, vov, vovv!!!");
    }

    public void fly() {
        System.out.println("Jag kan inte flyga");
    }

    public void print() {
        System.out.println("Mitt namn är " + getName() + " och jag är en hund");
        if (this.getFriend() == null) {
            System.out.println("Jag har ingen kompis");
        } else {
            System.out.println("Jag är kompis med " + getFriend().getName());
        }
        System.out.print("Jag gillar följande leksaker: ");
        getToy();
        System.out.println();
        System.out.println();
    }
}