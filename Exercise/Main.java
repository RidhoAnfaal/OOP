package Exercise;

public class Main {
    public static void main(String[] args) {
        GradingSystem gradingSystem = new GradingSystem();

        // Create lecturer
        Lecturer lecturer1 = new Lecturer("L001", "Dr. Smith");

        // Create courses
        Course course1 = new Course("C001", "Mathematics", lecturer1);
        Course course2 = new Course("C002", "Physics", lecturer1);

        // Add course to grading system
        gradingSystem.addCourse(course1);
        gradingSystem.addCourse(course2);

        // Create students
        Student student1 = new Student("S001", "John Doe");
        Student student2 = new Student("S002", "Jane Smith");

        // Add students to grading system
        gradingSystem.addStudent(student1);
        gradingSystem.addStudent(student2);

        // Enroll students in courses
        student1.enrollCourse(course1);
        student2.enrollCourse(course2);

        // Lecturer inputs grades
        lecturer1.inputGrade(student1, course1, 85);
        lecturer1.inputGrade(student2, course2, 90);

        // View grades for student1
        gradingSystem.getStudentReport(student1);

        // View grades for student2
        gradingSystem.getStudentReport(student2);
    }
}
