import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private int studentId;  // private = restricted access
    private String name;
    private HashMap<Course, Double> courseGrades;
    private ArrayList<Course> enrolledCourses;

    // Create a class constructor for the Main class
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        name = newName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int newStudentId) {
        studentId = newStudentId;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            // Add a new course to the ArrayList
            enrolledCourses.add(course);
            System.out.println("Enrolled in course: " + course.getName());
        } else {
            System.out.println("Already enrolled in course: " + course.getName());
        }
    }

    public void assignGrade(Course course, double grade) {
        Double value = courseGrades.get(course);
        if (value != null) {
            courseGrades.put(course, grade);
            System.out.println("Assigned grade " + grade + " for course: " + course.getName());
        } else {
            System.out.println("Student is not enrolled in course: " + course.getName());
        }
    }
}
