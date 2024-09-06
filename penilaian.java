import java.util.ArrayList;
import java.util.List;

public class penilaian {
    public static void main(String[] args) {
        // Create some sample students and courses
        Student student1 = new Student("2341720222", "Ridho");
        Student student2 = new Student("1234567890", "Anfa'al");

        Course course1 = new Course("PBO_TI", "Object oriented programming", "M. Hasyim, S.Kom, M.Kom");
        Course course2 = new Course("PRAKT_PBO_TI", "Object oriented programming practical", "M. Hasyim, S.Kom, M.Kom");

        // Create a list to store grades
        List<Grade> grades = new ArrayList<>();

        // Add some grades
        grades.add(new Grade("G1", student1.getStudentID(), course1.getCourseID(), 85));
        grades.add(new Grade("G2", student2.getStudentID(), course2.getCourseID(), 92));

        // Print out the grades
        for (Grade grade : grades) {
            System.out.println("Student: " + grade.getStudentID() + ", Course: " + grade.getCourseID() + ", Grade: "
                    + grade.getGradeValue());
        }
    }
}

class Student {
    private String studentID;
    private String studentName;

    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }
}

class Course {
    private String courseID;
    private String courseName;
    private String lecturerName;

    public Course(String courseID, String courseName, String lecturerName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.lecturerName = lecturerName;
    }

    // Getters
    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLecturerName() {
        return lecturerName;
    }
}

class Grade {
    private String gradeID;
    private String studentID;
    private String courseID;
    private int gradeValue;

    public Grade(String gradeID, String studentID, String courseID, int gradeValue) {
        this.gradeID = gradeID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.gradeValue = gradeValue;
    }

    // Getters and setters
    public String getGradeID() {
        return gradeID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}