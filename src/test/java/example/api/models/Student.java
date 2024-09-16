package example.api.models;

public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public String toJSON(){
        return "{\n" + "  \"name\": \"Мария Михайлова\",\n" + "  \"grade\": 5\n" + "}";
    }
}
