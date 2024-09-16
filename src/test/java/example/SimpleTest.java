package example;

import example.api.StudentRequests;
import example.api.models.Student;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {

    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/e181781a9d6a4c55a493969f8ac8c577";
    }

    @Test
    public void createStudent(){
        Student student = new Student("Николай Иванов", 2, "");
        StudentRequests.createStudent(student);
    }

    @Test
    public void deleteExistingStudent(){

        //создаем юзера
        Student student = new Student("Ирина Михайлова",4, "");
       Student createdStudent = StudentRequests.createStudent(student);

       //создание через билдер
       // Student student1 = Student.builder().name("Ира Николаева").grade(1).build();

        //удаляем юзера
        StudentRequests.deleteStudents(createdStudent.getId());

        // проверить что юзер больше не существует
        given().get("/student/" + createdStudent.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
