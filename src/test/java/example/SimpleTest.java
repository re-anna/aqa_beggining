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

    //сериализация из JSON в объект и наоборот
    public void createStudent(){
        Student student = new Student("Николай Иванов", 5);
        StudentRequests.createStudent(student.toJSON());

    }

    @Test
    public void deleteExistingStudent(){

        //создаем юзера
        Student student = new Student("Ирина Михайлова",4);
       String id = StudentRequests.createStudent(student.toJSON());

        //удаляем юзера
        StudentRequests.deleteStudents(id);

        // проверить что юзер больше не существует
        given().get("/student/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
