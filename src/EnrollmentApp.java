import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EnrollmentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        HashMap<String, ArrayList<String>> enrollments = new HashMap<>();

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== LICEO ENROLLMENT SYSTEM =====");
            System.out.println("[1] Register Student");
            System.out.println("[2] Add Course");
            System.out.println("[3] Enroll Student");
            System.out.println("[4] View All Students");
            System.out.println("[5] View All Courses");
            System.out.println("[6] View Student Load (Courses + Total Units)");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Full Name: ");
                    String name = sc.nextLine();

                    System.out.print("Program: ");
                    String program = sc.nextLine();

                    System.out.print("Year Level: ");
                    int year = Integer.parseInt(sc.nextLine());

                    students.add(new Student(id, name, program, year));

                    System.out.println("Student Registered!");
                    break;

                case 2:

                    System.out.print("Course Code: ");
                    String code = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Units: ");
                    int units = Integer.parseInt(sc.nextLine());

                    System.out.print("Capacity: ");
                    int cap = Integer.parseInt(sc.nextLine());

                    courses.add(new Course(code, title, units, cap));

                    System.out.println("Course Added!");
                    break;

                case 3:

                    System.out.print("Student ID: ");
                    String sid = sc.nextLine();

                    System.out.print("Course Code: ");
                    String ccode = sc.nextLine();

                    Student student = null;
                    Course course = null;

                    for (Student s : students) {
                        if (s.getStudentId().equals(sid)) {
                            student = s;
                        }
                    }

                    for (Course c : courses) {
                        if (c.getCourseCode().equals(ccode)) {
                            course = c;
                        }
                    }

                    if (student == null || course == null) {
                        System.out.println("Student or Course not found.");
                        break;
                    }

                    enrollments.putIfAbsent(sid, new ArrayList<>());

                    if (enrollments.get(sid).contains(ccode)) {
                        System.out.println("Already Enrolled.");
                    } else if (course.isFull()) {
                        System.out.println("Course Full.");
                    } else {
                        enrollments.get(sid).add(ccode);
                        course.addOneEnrollee();
                        System.out.println("Enrollment Successful!");
                    }

                    break;

                case 4:

                    if (students.isEmpty()) {
                        System.out.println("No Students.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s.describe());
                        }
                    }

                    break;

                case 5:

                    if (courses.isEmpty()) {
                        System.out.println("No Courses.");
                    } else {
                        for (Course c : courses) {
                            System.out.println(c.getCourseCode() + " | " +
                                    c.getTitle() + " | " +
                                    c.getUnits() + " Units | " +
                                    c.getEnrolledCount() + "/" + c.getCapacity());
                        }
                    }

                    break;

                case 6:

                    System.out.print("Student ID: ");
                    String search = sc.nextLine();

                    if (!enrollments.containsKey(search)) {
                        System.out.println("No Enrollments.");
                        break;
                    }

                    int total = 0;

                    for (String courseCode : enrollments.get(search)) {
                        for (Course c : courses) {
                            if (c.getCourseCode().equals(courseCode)) {
                                System.out.println(c.getCourseCode() + " - " + c.getTitle());
                                total += c.getUnits();
                            }
                        }
                    }

                    System.out.println("Total Units: " + total);

                    break;

                case 0:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }

        sc.close();
    }
}