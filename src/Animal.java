public class Animal {
   String name;
   protected int maxRunDistance;
   protected int maxSwimDistance;

   public Animal(int maxRunDistance, int maxSwimDistance) {
      this.maxRunDistance = maxRunDistance;
      this.maxSwimDistance = maxSwimDistance;
   }

   public void run(int distance) {
      if (distance <= this.maxRunDistance) {
         System.out.println(this.name + " пробежал " + distance + " м.");
      } else {
         System.out.println(this.name + " не смог пробежать " + distance + " м.");
      }

   }

   public void swim(int distance) {
      if (distance <= this.maxSwimDistance) {
         System.out.println(this.name + " проплыл " + distance + " м.");
      } else if (this.maxSwimDistance == 0) {
         System.out.println(this.name + " не умеет плавать");
      } else {
         System.out.println(this.name + " не смог проплыть " + distance + " м.");
      }

   }
}
