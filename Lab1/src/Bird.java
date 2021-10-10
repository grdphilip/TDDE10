public class Bird extends Animal{

    public Bird (String name, int age) {
        super(name, age);
    }

    public void introduceYourself() {
        System.out.println("Pip Pip! Jag är en fågel vid namn " + this.getName() + ".");
        System.out.println("Jag är " + this.getAge() + " år gammal.");
    }


      public void makeSound() {
          System.out.println("Pip pip!");
      }

      public void fly() {
          System.out.println("Flax flax, jag flaxar med vingarna!");
      }

      public void print() {
          System.out.println("Mitt namn är " + getName() + " och jag är en Fågel");
          if (this.getFriend() == null) {
              System.out.println("Jag har ingen kompis");
          } else {
              System.out.println("Jag är kompis med " + getFriend().getName());
              System.out.println("");
          }
//          System.out.print("Jag gillar följande leksaker: ");
//          getToy();
//          System.out.println();
//          System.out.println();
        }
}