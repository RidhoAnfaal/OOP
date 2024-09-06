package Exercise;

public class Course {
    private String id;
    private String name;
    private Lecturer lecturer;

    public Course(String id, String name, Lecturer lecturer) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }
}
