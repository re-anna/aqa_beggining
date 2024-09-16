package test.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornTests {

    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/cbb0ae2e39f9429ea650bab05298a330";
    }

    @Test
    public void createUnicorn(){
        given()
                .body("{\n" + "  \"name\": \"SkyFall \",\n" + "  \"hair_color\": \"Night\"\n" + "}")
                .contentType(ContentType.JSON)
                .post("https://crudcrud.com/api/cbb0ae2e39f9429ea650bab05298a330/unicorns")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"));
    }


    @Test
    public void deleteUnicorn(){

        // создание единорога
       String id = given()
                .body("{\n" + "  \"name\": \"SkyFall \",\n" + "  \"hair_color\": \"Night\"\n" + "}")
                .contentType(ContentType.JSON)
                .post("https://crudcrud.com/api/cbb0ae2e39f9429ea650bab05298a330/unicorns")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().path("_id");

        // удаление единорога
        given().delete("https://crudcrud.com/api/cbb0ae2e39f9429ea650bab05298a330/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);


        // проверка, что единорога удалили
        given()
                .get("https://crudcrud.com/api/cbb0ae2e39f9429ea650bab05298a330/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
