import java.util.Scanner;

public class CourseManagement {
    public static int getIntInput(Scanner input) {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    public static void addNewCourse() {}

    public static void enrollStudentInCourse() {}

    public static void assignGrades() {}

    public static void calculateOverallCourseGrades() {}
}
