package Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private ArrayList<Course> enrolledCourses;
    private Map<Course, Grade> courseGrades;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.courseGrades = new HashMap<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void addGrade(Course course, Grade grade) {
        courseGrades.put(course, grade);
    }

    public void viewGrades() {
        System.out.println("Grades for " + name + ":");
        for (Map.Entry<Course, Grade> entry : courseGrades.entrySet()) {
            Course course = entry.getKey();
            Grade grade = entry.getValue();
            System.out.println(course.getName() + ": " + grade.getMarks());
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
