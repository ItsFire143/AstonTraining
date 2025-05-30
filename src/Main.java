import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {

       Park park = new Park();

       park.addAttraction("Пивной ларек", "10:00-22:00", 75.59);

       List<Park.Attraction> attract = new ArrayList<>();
       attract.add(park.new Attraction("Ларек с шавермой", "12:00-20:00", 156.0));
       attract.add(park.new Attraction("Туалет", "00:00-00:01", 100.50));

       park.addAttractions(attract);

       for (Park.Attraction attraction : park.getAttractions()) {
           System.out.println(attraction);
       }
   }
}
