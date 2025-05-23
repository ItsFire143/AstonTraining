public interface Shape {
   double getArea();

   default double getPer() {
      return 0.0D;
   }

   String getFillColor();

   String getBorderColor();
}
