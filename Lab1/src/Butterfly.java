public class Butterfly extends Animal{

public Butterfly (String name, int age) {
    super(name, age);
}

public void introduceYourself() {
    System.out.println("Hej, jag är fjärilen " + this.getName() + ".");
    System.out.println("Jag är " + this.getAge() + " år gammal.");
}


  public void makeSound() {
      System.out.println("");
  }

  public void fly() {
      System.out.println("Flax flax, jag flaxar med vingarna!");
  }

  public void print() {
      System.out.println("Mitt namn är " + getName() + " och jag är en fjäril");
      if (this.getFriend() == null) {
          System.out.println("Jag har ingen kompis");
      } else {
          System.out.println("Jag är kompis med " + getFriend().getName());
      }
//      System.out.print("Jag gillar följande leksaker: ");
//      getToy();
//      System.out.println();
//      System.out.println();
    }
}
