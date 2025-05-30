import java.util.ArrayList;
import java.util.List;

public class Park {
   private List<Attraction> attractions;
   public class Attraction {
      private String name;
      private String workTime;
      private double price;

      public Attraction(String name, String workTime, double price) {
         this.name = name;
         this.workTime = workTime;
         this.price = price;
      }
      public String toString() {
         return name + " " + workTime + " " + price;
      }
   }
   public Park(){
      attractions = new ArrayList<>();
   }

   public void addAttraction(String name, String workTime, double price) {
      attractions.add(new Attraction(name, workTime, price));
   }

   public void addAttractions(List<Attraction> attractionsList) {
      attractions.addAll(attractionsList);
   }
   public List<Attraction> getAttractions() {
      return attractions;
   }
}
