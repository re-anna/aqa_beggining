package example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import example.api.models.Student;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {



    public static Student createStudent(Student student) {

        String studentJson = "";
        try {
           studentJson = new ObjectMapper().writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return given()
                .body(studentJson)
                .contentType(ContentType.JSON)
                .when()
                .post("/student")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract().as(Student.class, ObjectMapperType.GSON);
    }

    public static void deleteStudents(String id){
        given().delete("/student/" + id)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
