package org.example;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private final String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String studentClass;

    public Student(String id, String firstName, String lastName, String dateOfBirth, String studentClass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.studentClass = studentClass;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName +
                ", DOB: " + dateOfBirth + ", Class: " + studentClass;
    }
}

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {1
            System.out.println("\nStudent Management Menu:");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findByLastName();
                    break;
                case 3:
                    findAndEditByFullName();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void enterStudentList() {
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < count; i++) {
            System.out.println("Enter information for student " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Class: ");
            String studentClass = scanner.nextLine();

            students.add(new Student(id, firstName, lastName, dateOfBirth, studentClass));
        }
    }

    private static void findByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        System.out.println("Students with last name '" + lastName + "':");
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
            }
        }
    }

    private static void findAndEditByFullName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        for (Student student : students) {
            String studentFullName = student.getFirstName() + " " + student.getLastName();
            if (studentFullName.equalsIgnoreCase(fullName)) {
                System.out.println("Found student: " + student);
                System.out.println("Enter new information (leave blank to keep current):");
                System.out.print("First Name: ");
                String newFirstName = scanner.nextLine();
                if (!newFirstName.isEmpty()) student.setFirstName(newFirstName);

                System.out.print("Last Name: ");
                String newLastName = scanner.nextLine();
                if (!newLastName.isEmpty()) student.setLastName(newLastName);

                System.out.print("Date of Birth (YYYY-MM-DD): ");
                String newDateOfBirth = scanner.nextLine();
                if (!newDateOfBirth.isEmpty()) student.setDateOfBirth(newDateOfBirth);

                System.out.print("Class: ");
                String newClass = scanner.nextLine();
                if (!newClass.isEmpty()) student.setStudentClass(newClass);

                System.out.println("Updated student information: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
