import java.util.Random;

public class Cat extends Animal {
   private String name;
   public boolean isFull;
   private int hunger;

   public Cat(String name) {
      super(200, 0);
      this.name = name;
      this.isFull = false;
      Random random = new Random();
      this.hunger = 15 + random.nextInt(6);
   }

   public boolean takeFull() {
      return this.isFull;
   }

   public boolean eat(Bowl bowl) {
      if (this.isFull) {
         System.out.println(this.name + " уже сыт");
         return true;
      } else if (bowl.eatFood(this.hunger)) {
         this.isFull = true;
         System.out.println(this.name + " поел");
         return true;
      } else {
         System.out.println(this.name + " не хватило еды, ему/ей нужно " + this.hunger);
         return false;
      }
   }
}
