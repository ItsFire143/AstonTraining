public class Bowl {
   private int food;

   public Bowl(int food) {
      this.food = food;
   }

   public boolean eatFood(int count) {
      if (this.food >= count) {
         this.food -= count;
         return true;
      } else {
         return false;
      }
   }

   public void addFood(int count) {
      this.food += count;
      System.out.println("Теперь в миске " + this.food);
   }

   public int getFood() {
      return this.food;
   }
}
