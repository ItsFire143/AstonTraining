public class Rectangle implements Shape {
   private double width;
   private double height;
   private String fillColor;
   private String borderColor;

   public Rectangle(double width, double height, String fillColor, String borderColor) {
      this.width = width;
      this.height = height;
      this.fillColor = fillColor;
      this.borderColor = borderColor;
   }

   public double getArea() {
      return this.width * this.height;
   }

   public double getPer() {
      return 2.0D * this.width * this.height;
   }

   public String getFillColor() {
      return this.fillColor;
   }

   public String getBorderColor() {
      return this.borderColor;
   }
}
