public class Course {
    private String name; // private = restricted access
    private String code;
    private int maxCapacity;

    // Getter
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}