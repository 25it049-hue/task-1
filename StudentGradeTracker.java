import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter grade: ");
            double grade = sc.nextDouble();
            sc.nextLine(); // consume newline
            students.add(new Student(name, grade));
        }

        double sum = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            sum += s.grade;
            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
          }
            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = sum / students.size();

        System.out.println("\n--- Grade Report ---");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.grade);
        }
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (by " + lowStudent + ")");
    }
}