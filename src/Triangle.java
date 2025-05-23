public class Triangle implements Shape {
   private double a;
   private double b;
   private double c;
   private String fillColor;
   private String borderColor;

   public Triangle(double a, double b, double c, String fillColor, String borderColor) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.fillColor = fillColor;
      this.borderColor = borderColor;
   }

   public double getArea() {
      double s = this.getPer() / 2.0D;
      return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
   }

   public double getPer() {
      return this.a + this.b + this.c;
   }

   public String getFillColor() {
      return this.fillColor;
   }

   public String getBorderColor() {
      return this.borderColor;
   }
}
