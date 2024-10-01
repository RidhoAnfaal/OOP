package Jobsheet4.Assignment;

public class Classroom {
    private Subject subject;
    private Teacher teacher;
    private Student[] students;
    private int studentCount;

    public Classroom(Subject subject, Teacher teacher, int size) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = new Student[size];
        this.studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            this.students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Classroom is full!");
        }
    }

    public String info() {
        String info = "=== Classroom Info ===\n";
        info += subject.info() + "\n";
        info += teacher.info() + "\n";
        info += "Students :\n";
        for (int i = 0; i < studentCount; i++) {
            info += students[i].info() + "\n";
        }
        return info;
    }
}
