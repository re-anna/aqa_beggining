package task2.University2;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentsArray = new ArrayList<>();

    public StudentManager(ArrayList<Student> studentsArray){
        this.studentsArray = studentsArray;
    }

    public StudentManager(){
        this.studentsArray = new ArrayList<>();
    }

    public ArrayList<Student> getStudentsArray(){
        return this.studentsArray;
    }

    public void addStudent(Student student){
        this.studentsArray.add(student);

    }

    Student targetStudent = null;

    public void deleteStudentByID(int id){
        Student targetStudent = null;
        //вариант 1. Найти студента по id и затем его удалить
        for (Student studentX : studentsArray){
            if (studentX.getId() == id){
                targetStudent = studentX;

            }
        }

        if (targetStudent != null){
            studentsArray.remove(targetStudent);
        }else {
            System.out.println("Student with id " + id + " not found");
        }
    }
}
