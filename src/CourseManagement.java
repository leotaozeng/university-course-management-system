import java.util.ArrayList;
import java.util.HashMap;

public class CourseManagement {
    private static final ArrayList<Course> courseList = new ArrayList<>();
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final HashMap<Student, HashMap<Course, Double>> studentGrades = new HashMap<>();

    public static Student findStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public static Course findCourseByCode(String courseCode) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    // The addCourse method should accept parameters for course information and create a new Course object
    // It should add the course to the list of courses
    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course course = new Course(courseCode, name, maxCapacity);
        courseList.add(course);
        System.out.println("Course added successfully.");
    }

    // The enrollStudent method should accept a Student object and a Course object
    // It should enroll the student in the course by calling the appropriate method in the Student class
    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
        studentList.add(student);
    }

    // The assignGrade method should accept a Student object, a Course object, and a grade
    // It should assign the grade to the student for that course by calling the appropriate method in the Student class
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
        studentGrades.computeIfAbsent(student, k -> new HashMap<>()).put(course, grade);
    }

    // The calculateOverallGrade method should accept a Student object
    // calculate the overall course grade for that student based on the grades assigned to them
    public static void calculateOverallGrade() {}
}
