import java.awt.*;
import java.util.*;
public class StudentManager {
    public static void removeStudent(Set<Student> students) {
            students.removeIf(s -> s.getAvengeGrade() < 3.0);
    }

    public static void upStudent(Set<Student> students) {
        for (Student s : students) {
            if (s.getAvengeGrade() >= 3.0) {
                s.nextCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}
