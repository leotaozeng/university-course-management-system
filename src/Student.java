import java.util.ArrayList;

public class Student {
    private int studentId;  // private = restricted access
    private String name;
    // Create an ArrayList called enrolledCourses, which initially holds []
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

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
}
