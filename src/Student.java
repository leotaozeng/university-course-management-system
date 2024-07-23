import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private int studentId;  // private = restricted access
    private String name;
    private final HashMap<Course, Double> enrolledCourses; // Map to store courses and grades

    // Create a class constructor for the Student class
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new HashMap<>();
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int newStudentId) {
        studentId = newStudentId;
    }

    public HashMap<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll students in courses
    public void enrollInCourse(Course course) {
        int totalEnrolledStudents = Course.getTotalEnrolledStudents();

        if (!enrolledCourses.containsKey(course) && totalEnrolledStudents < course.getMaxCapacity()) {
            enrolledCourses.put(course, null);
            Course.incrementEnrolledStudents();
            System.out.println("Enrolled in course: " + course.getName());
        } else {
            System.out.println("Already enrolled in course: " + course.getName() + " or course is at full capacity.");
        }
    }

    // Method to assign grades to students
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        } else {
            System.out.println("Cannot assign grade: not enrolled in the course.");
        }
    }
}
