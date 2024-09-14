package org.example.task1.University;

public class Students implements Printable{

    private String studentName;
    private int studentNumber;
    private int averageRate;

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public void setStudentNumber(int studentNumber){
        this.studentNumber = studentNumber;
    }

    public void setAverageRate(int averageRate){
        this.averageRate = averageRate;
    }

    public String getStudentName(){
        return this.studentName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public int getAverageRate() {
        return averageRate;
    }


    @Override
    public void printable() {
        System.out.println("Студент " + getStudentName() + " с номером книжки " + getStudentNumber() + " имеет среднюю оценку " + getAverageRate());
    }
}
