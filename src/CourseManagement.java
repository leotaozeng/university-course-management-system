import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CourseManagement {
    private static final ArrayList<Course> courseList = new ArrayList<>();
    private static final HashMap<Student, Course> studentGrades = new HashMap<>();

    public static void addCourse(Scanner input) {
        System.out.print("Enter course code: ");
        String courseCode = input.nextLine();

        System.out.print("Enter course name: ");
        String name = input.nextLine();

        System.out.print("Enter course maximum capacity: ");
        int maxCapacity = getIntInput(input);

        // Create a new Course object and add the course to the list of courses
        Course course = new Course(courseCode, name, maxCapacity);
        courseList.add(course);

        System.out.println("Course added successfully.");
    }

    public static void enrollStudent(Scanner input) {
        System.out.print("Enter student ID: ");
        int studentId = getIntInput(input);

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        // Create a new Student object
        Student student = new Student(studentId, name);

        System.out.print("Enter course code: ");
        String courseCode = input.nextLine();
        Course course = findCourseByCode(courseCode);

        if (course != null) {
            student.enrollInCourse(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    public static void assignGrade(Scanner input) {
        System.out.print("Enter student ID: ");
        int studentId = getIntInput(input);

        System.out.print("Enter course code: ");
        String courseCode = input.nextLine();

        System.out.print("Enter grade: ");
        double grade = input.nextDouble();

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            student.assignGrade(course, grade);
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public static void calculateOverallGrade() {}

    public static int getIntInput(Scanner input) {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudentById(int studentId) {
        for (Student student : studentGrades.keySet()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
