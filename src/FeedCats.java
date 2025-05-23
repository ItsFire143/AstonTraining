import java.util.Scanner;

public class FeedCats {
   static Scanner scanner;
   static Bowl bowl;
   static Cat[] cats;

   public static void fillBowl(Cat[] catArray) {
      cats = catArray;
      int count = reqForQuantity();
      bowl = new Bowl(count);
      System.out.println("Миска наполнена, в ней: " + count);
      feeding();
   }

   private static int reqForQuantity() {
      System.out.println("Введите количество еды, которое вы хотите положить в миску");

      while(true) {
         while(!scanner.hasNextInt()) {
            System.out.println("Нужно ввести целое число");
            scanner.next();
         }

         int count = scanner.nextInt();
         if (count > 0) {
            return count;
         }

         System.out.println("Нельзя использовать отрицательное или нулевое значение");
      }
   }

   public static void feeding() {
      System.out.println("Коты бегут на звуки корма");
      boolean allCatsFill = false;

      while(!allCatsFill) {
         allCatsFill = true;
         Cat[] catArr = cats;
         int catLen = catArr.length;

         for(int i = 0; i < catLen; ++i) {
            Cat cat = catArr[i];
            if (!cat.takeFull()) {
               boolean full = cat.eat(bowl);
               if (!full) {
                  allCatsFill = false;
               }
            }
         }

         if (!allCatsFill) {
            System.out.println("Не все наелись, в миске " + bowl.getFood());
            int addition = reqForQuantity();
            bowl.addFood(addition);
         }
      }

      System.out.println("Наконец все наелись");
   }

   static {
      scanner = new Scanner(System.in);
   }
}
