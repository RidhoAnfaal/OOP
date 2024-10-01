package Jobsheet4.Assignment;

public class MainAssignment {
    public static void main(String[] args) {
        Subject java = new Subject("Java OOP");
        Teacher teacher1 = new Teacher("Mr. Jono");
        Classroom class1 = new Classroom(java, teacher1, 5);
        Subject web = new Subject("Web Design and Programming");
        Teacher teacher2 = new Teacher("Mr. Budi");
        Classroom class2 = new Classroom(web, teacher2, 3);

        Student s1 = new Student("Agna");
        Student s2 = new Student("Bayu");
        Student s3 = new Student("Golden");
        Student s4 = new Student("Hammam");
        Student s5 = new Student("Ridho");
        class1.addStudent(s1);
        class1.addStudent(s2);
        class1.addStudent(s3);
        class1.addStudent(s4);
        class1.addStudent(s5);
        System.out.println(class1.info());

        Student s6 = new Student("Tegar");
        Student s7 = new Student("Faiz");
        Student s8 = new Student("Anton");
        Student s9 = new Student("Petrus");
        class2.addStudent(s6);
        class2.addStudent(s7);
        class2.addStudent(s8);
        class2.addStudent(s9);
        System.out.println(class2.info());
    }
}
