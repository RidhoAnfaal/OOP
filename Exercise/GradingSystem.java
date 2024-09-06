package Exercise;

import java.util.ArrayList;

public class GradingSystem {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public GradingSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void assignLecturerToCourse(Course course, Lecturer lecturer) {
        course = new Course(course.getId(), course.getName(), lecturer);
        lecturer.addCourse(course);
    }

    public void getStudentReport(Student student) {
        student.viewGrades();
    }
}
