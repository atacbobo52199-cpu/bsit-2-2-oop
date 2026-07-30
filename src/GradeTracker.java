import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    static int[] cutoffs = {90, 80, 70, 60, 0};
    static char[] letters = {'A', 'B', 'C', 'D', 'F'};

    public static char letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i]) {
                return letters[i];
            }
        }
        return 'F';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> roster = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Class Average");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Student Name: ");
                String name = sc.next();

                System.out.print("Grade: ");
                double grade = sc.nextDouble();

                roster.add(new Student(name, grade));

                System.out.println("Student Added!");

            } else if (choice == 2) {

                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    System.out.println("\nStudent List");
                    for (Student s : roster) {
                        System.out.println(s.name + " - " + s.grade + " - " + letterFor(s.grade));
                    }
                }

            } else if (choice == 3) {

                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {

                    double total = 0;

                    for (Student s : roster) {
                        total += s.grade;
                    }

                    double average = total / roster.size();

                    System.out.printf("Class Average: %.2f%n", average);
                }

            } else if (choice == 4) {

                System.out.println("Goodbye!");
                break;

            } else {

                System.out.println("Invalid Choice!");

            }
        }

        sc.close();
    }
}

class Student {

    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}