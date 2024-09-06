package Exercise;

public class Grade {
    @SuppressWarnings("unused")
    private Student student;
    @SuppressWarnings("unused")
    private Course course;
    private int marks;

    public Grade(Student student, Course course, int marks) {
        this.student = student;
        this.course = course;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}
