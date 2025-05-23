public class Main {
   public static void main(String[] args) {
      Cat[] cats = new Cat[]{new Cat("Чипс"), new Cat("Коржик"), new Cat("Карамелька"), new Cat("Компот")};
      FeedCats.fillBowl(cats);
      Shape[] shapes = new Shape[]{new Circle(5.0D, "Серый", "Красный"), new Rectangle(6.0D, 12.0D, "Черный", "Желтый"), new Triangle(5.0D, 6.0D, 7.0D, "Синий", "Стрёмный")};
      Shape[] var3 = shapes;
      int var4 = shapes.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Shape shape = var3[var5];
         System.out.println();
         System.out.println("Фигура: " + shape.getClass().getSimpleName());
         System.out.println("Периметр: " + shape.getPer());
         System.out.println("Площадь: " + shape.getArea());
         System.out.println("Цвет фона: " + shape.getFillColor());
         System.out.println("Цвет границ: " + shape.getBorderColor());
      }

   }
}
