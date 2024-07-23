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
    // It should accept a Course object as a parameter and add the course to the student's enrolled courses
    public void enrollInCourse(Course course) {
        int totalEnrolledStudents = Course.getTotalEnrolledStudents();

        if (!enrolledCourses.containsKey(course) && totalEnrolledStudents < course.getMaxCapacity()) {
            enrolledCourses.put(course, null);
            Course.incrementEnrolledStudents();
            System.out.println("Student enrolled successfully in course: " + course.getName());
        } else {
            System.out.println("Course is at full capacity or already enrolled in course: " + course.getName());
        }
    }

    // Method to assign grades to students
    // It should accept a Course object and a grade for the student and update the student's grade for that course
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Cannot assign grade: not enrolled in the course.");
        }
    }
}
