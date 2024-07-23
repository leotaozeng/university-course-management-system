import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        Main system = new Main();
        system.run();
    }

    public void run() {
        try {
            int choice;
            do {
                System.out.println("\nWelcome to the Course Enrollment and Grade Management System!\nHere are the options:");
                System.out.println("1. Add a new course");
                System.out.println("2. Enroll student in a course");
                System.out.println("3. Assign grades");
                System.out.println("4. Calculate overall course grades");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: "); // The print() method does not move the cursor to a new line.

                // Get the user's choice
                choice = getIntInput(input);

                // Switch statements to perform actions based on the user's choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter course code: ");
                        String courseCode = input.nextLine();

                        System.out.print("Enter course name: ");
                        String courseName = input.nextLine();

                        System.out.print("Enter course maximum capacity: ");
                        int maxCapacity = getIntInput(input);

                        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        int studentId = getIntInput(input);

                        System.out.print("Enter student name: ");
                        String name = input.nextLine();

                        System.out.print("Enter course code: ");
                        String enrollCourseCode = input.nextLine();

                        Course enrollCourse = CourseManagement.findCourseByCode(enrollCourseCode);
                        Student student = CourseManagement.findStudentById(studentId);

                        if (student == null && enrollCourse != null) {
                            Student newStudent = new Student(studentId, name);
                            CourseManagement.enrollStudent(newStudent, enrollCourse);
                        } else if (student != null && enrollCourse != null) {
                            CourseManagement.enrollStudent(student, enrollCourse);
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter student ID: ");
                        int gradeStudentId = getIntInput(input);
                        Student gradeStudent = CourseManagement.findStudentById(gradeStudentId);

                        if (gradeStudent != null) {
                            System.out.print("Enter course code: ");
                            String gradeCourseCode = input.nextLine();
                            Course gradeCourse = CourseManagement.findCourseByCode(gradeCourseCode);

                            if (gradeCourse != null) {
                                System.out.print("Enter grade: ");
                                double grade = input.nextDouble();
                                CourseManagement.assignGrade(gradeStudent, gradeCourse, grade);
                            } else {
                                System.out.println("Course not found.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        CourseManagement.calculateOverallGrade();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        // Handle invalid input and display appropriate error messages
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } finally {
            System.out.println("Goodbye!");
            // Close the input in a finally block to ensure it's always closed
            input.close();
        }
    }

    public int getIntInput(Scanner input) {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}