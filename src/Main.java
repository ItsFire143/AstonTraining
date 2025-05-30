import java.util.*;

public class Main {
   public static void main(String[] args) {
       Set<Student> students = new HashSet<>();
       students.add(new Student("Иван", "ПКС-319", 3, Arrays.asList(4, 3, 5)));
       students.add(new Student("Мария", "ОСА-218", 2, Arrays.asList(2, 3, 2)));
       students.add(new Student("Павел", "ИС-217", 2, Arrays.asList(3, 4, 3)));
       students.add(new Student("Ольга", "ПСО-119", 1, Arrays.asList(5, 5, 5)));

       System.out.println("До ");
       students.forEach(System.out::println);

       StudentManager.removeStudent(students);
       StudentManager.upStudent(students);

       System.out.println("После ");
       students.forEach(System.out::println);

       System.out.println();

       StudentManager.printStudents(students, 2);

      
       PhoneBook pb = new PhoneBook();
       pb.add("Павлов", "123-456");
       pb.add("Семенов", "987-654");
       pb.add("Павлов", "555-555");

       System.out.println("Павлов: " + pb.get("Павлов"));

       System.out.println("Семенов: " + pb.get("Семенов"));

       System.out.println("Сидоров: " + pb.get("Сидоров"));

   }
}
