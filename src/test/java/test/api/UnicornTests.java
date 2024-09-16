package test.api;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnicornTests {

    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/e181781a9d6a4c55a493969f8ac8c577";
    }

    @Test
    public void createUnicorn(){

        UnicornRequests.createUnicorn("{\n" + "  \"name\": \"SkyFall \",\n" + "  \"hair_color\": \"Night\"\n" + "}");
    }

    @Test
    public void updateHairUnicorn() {
        // создание единорога
        String id = UnicornRequests.createUnicorn("{\n" + "  \"name\": \"SkyFall\",\n" + "  \"hair_color\": \"Night\"\n" + "}");

        // обновление цвета волос
        UnicornRequests.updateHairUnicorn(id, "Rainbow");

        // проверка, что цвет волос изменён
        given()
                .get("/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("hair_color", equalTo("Rainbow"));
    }

    @Test
    public void deleteUnicorn(){

        // создание единорога
       String id = UnicornRequests.createUnicorn("{\n" + "  \"name\": \"SkyFall \",\n" + "  \"hair_color\": \"Night\"\n" + "}");

        // удаление единорога
       UnicornRequests.deleteUnicorn(id);

        // проверка, что единорога удалили
        given()
                .get("/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    }

