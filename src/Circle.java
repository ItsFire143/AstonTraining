public class Circle implements Shape {
   private double radius;
   private String fillColor;
   private String borderColor;

   public Circle(double radius, String fillColor, String borderColor) {
      this.radius = radius;
      this.fillColor = fillColor;
      this.borderColor = borderColor;
   }

   public double getArea() {
      return Math.PI * this.radius * this.radius;
   }

   public double getPer() {
      return 2 * (Math.PI) * this.radius;
   }

   public String getFillColor() {
      return this.fillColor;
   }

   public String getBorderColor() {
      return this.borderColor;
   }
}
