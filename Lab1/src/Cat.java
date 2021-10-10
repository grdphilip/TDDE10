public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void introduceYourself() {
        System.out.println("Mjau. Jag är en katt som heter " + this.getName() + ".");
        System.out.println("Jag är " + this.getAge() + " år gammal.");
    }

    public void makeSound() {
        System.out.println("Purrrrrr");
    }

    public void fly() {
        System.out.println("Jag kan inte flyga");
    }

    public void print() {
        System.out.println("Mitt namn är " + getName() + " och jag är en katt");
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
