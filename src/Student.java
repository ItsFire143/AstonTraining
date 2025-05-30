import java.awt.*;
import java.util.*;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName(){
        return name;
    }

    public int getCourse(){
        return course;
    }

    public void nextCourse(){
        this.course++;
    }

    public double getAvengeGrade(){
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum/grades.size();
    }

    public String toString(){
        return name + " " + group + " " + course + " " + getAvengeGrade();
    }
}
