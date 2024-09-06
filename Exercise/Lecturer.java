package Exercise;

import java.util.ArrayList;

public class Lecturer {
    private String id;
    private String name;
    private ArrayList<Course> coursesTaught;

    public Lecturer(String id, String name) {
        this.id = id;
        this.name = name;
        this.coursesTaught = new ArrayList<>();
    }

    public void addCourse(Course course) {
        coursesTaught.add(course);
    }

    public void inputGrade(Student student, Course course, int marks) {
        Grade grade = new Grade(student, course, marks);
        student.addGrade(course, grade);
        System.out.println("Grade entered: " + student.getName() + " for course " + course.getName() + " -> " + marks);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
