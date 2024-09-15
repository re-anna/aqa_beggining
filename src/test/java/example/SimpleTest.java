package example;

import example.api.StudentRequests;
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
        RestAssured.baseURI = "https://crudcrud.com/api/cbb0ae2e39f9429ea650bab05298a330";
    }

    @Test
    public void createStudent(){

        StudentRequests.createStudent("\n" + "{\n" + "  \"name\": \"Иван\",\n" + "  \"grade\": 4\n" + "}");

    }

    @Test
    public void deleteExistingStudent(){

        //создаем юзера
       String id = StudentRequests.createStudent("\n" + "{\n" + "  \"name\": \"Мария Михайлова\",\n" + "  \"grade\": 5\n" + "}");

        //удаляем юзера
        StudentRequests.deleteStudents(id);

        // проверить что юзер больше не существует
        given().get("/student/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
