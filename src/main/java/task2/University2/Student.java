package task2.University2;

public class Student {
    private int id;
    private String name;

    //перегрузка методов
    public Student(){
        this.id = 0;
        this.name="unknown";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public void setID(int id){
        this.id = id;
    }

    public void setName( String name){

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return "Student{" +
                " id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}


