package task2.University2;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Иван Иванов");
        Student student2 = new Student(2, "Ира Васильева");
        Student student3 = new Student(3, "Катя Подбельская");
        Student student4 = new Student(9,"Test");

        System.out.println(student1.toString());
        System.out.println(student2.toString());

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);
        studentManager.addStudent(student4);

        studentManager.deleteStudentByID(2);

        //доделать
        //System.out.println(StudentManager.getStudentsArray);
    }
}