public class Course {
    public static int totalEnrolledStudents = 0; // Static variable to track total enrolled students

    private final String courseCode; // private = restricted access
    private final String name;
    private final int maxCapacity;

    // Create a class constructor for the Course class
    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public static void incrementEnrolledStudents() {
        totalEnrolledStudents++;
    }
}