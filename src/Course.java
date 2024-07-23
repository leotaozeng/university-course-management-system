public class Course {
    private static int totalEnrolledStudents = 0;

    private final String courseCode; // private = restricted access
    private final String name;
    private final int maxCapacity;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    // Getter
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
}