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
                System.out.println("1. Add New Course");
                System.out.println("2. Enroll Student in a Course");
                System.out.println("3. Assign Grades");
                System.out.println("4. Calculate Course Grades");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: "); // The print() method does not move the cursor to a new line.

                // Get the user's choice
                choice = CourseManagement.getIntInput(input);

                // Switch statements to perform actions based on the user's choice
                switch (choice) {
                    case 1:
                        CourseManagement.addNewCourse();
                        break;
                    case 2:
                        CourseManagement.enrollStudentInCourse();
                        break;
                    case 3:
                        CourseManagement.assignGrades();
                        break;
                    case 4:
                        CourseManagement.calculateOverallCourseGrades();
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
}