import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        long[] id = new long[10];
        String[] name = new String[10];
        int[] age = new int[10];
        String[] course = new String[10];
        double[] grade = new double[10];
        boolean[] enrolled = new boolean[10];

        int studentCount = 0;
        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    if (studentCount == 10) {
                        System.out.println("Student list is full.");
                    } else {

                        System.out.print("Student ID (11 digits): ");
                        id[studentCount] = input.nextLong();

                        input.nextLine();

                        System.out.print("Full Name: ");
                        name[studentCount] = input.nextLine();

                        System.out.print("Age: ");
                        age[studentCount] = input.nextInt();

                        while (age[studentCount] <= 0) {
                            System.out.print("Invalid age. Enter again: ");
                            age[studentCount] = input.nextInt();
                        }

                        input.nextLine();

                        System.out.print("Course: ");
                        course[studentCount] = input.nextLine();

                        System.out.print("Grade: ");
                        grade[studentCount] = input.nextDouble();

                        while (grade[studentCount] < 0 || grade[studentCount] > 100) {
                            System.out.print("Invalid grade. Enter again: ");
                            grade[studentCount] = input.nextDouble();
                        }

                        System.out.print("Enrolled (true/false): ");
                        enrolled[studentCount] = input.nextBoolean();

                        studentCount++;

                        System.out.println("Student added successfully!");
                    }

                    break;

                case 2:

                    if (studentCount == 0) {
                        System.out.println("No student records.");
                    } else {

                        for (int i = 0; i < studentCount; i++) {

                            System.out.println("\nStudent " + (i + 1));
                            System.out.println("ID: " + id[i]);
                            System.out.println("Name: " + name[i]);
                            System.out.println("Age: " + age[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Grade: " + grade[i]);
                            System.out.println("Enrolled: " + enrolled[i]);

                            if (grade[i] >= 90) {
                                System.out.println("Standing: Dean's Lister");
                            } else if (grade[i] >= 75) {
                                System.out.println("Standing: Passed");
                            } else {
                                System.out.println("Standing: Failed");
                            }
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    long search = input.nextLong();

                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {

                        if (id[i] == search) {

                            System.out.println("\nStudent Found!");
                            System.out.println("ID: " + id[i]);
                            System.out.println("Name: " + name[i]);
                            System.out.println("Age: " + age[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Grade: " + grade[i]);
                            System.out.println("Enrolled: " + enrolled[i]);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    if (studentCount == 0) {
                        System.out.println("No student records.");
                    } else {

                        double total = 0;
                        double highest = grade[0];
                        String topStudent = name[0];

                        for (int i = 0; i < studentCount; i++) {

                            total += grade[i];

                            if (grade[i] > highest) {
                                highest = grade[i];
                                topStudent = name[i];
                            }
                        }

                        double average = total / studentCount;

                        System.out.println("\n===== STATISTICS =====");
                        System.out.println("Total Students: " + studentCount);
                        System.out.println("Average Grade: " + average);
                        System.out.println("Top Student: " + topStudent);
                        System.out.println("Top Grade: " + highest);
                    }

                    break;

                case 5:

                    System.out.println("Thank you. Goodbye!");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}