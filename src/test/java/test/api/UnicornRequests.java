package test.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    public static String  createUnicorn(String body){
        return given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("/unicorns")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract().path("_id");
    }

    public static void updateHairUnicorn(String id, String newHairColor) {
        String body = String.format("{\"hair_color\": \"%s\"}", newHairColor);

        given()
                .body(body)
                .contentType(ContentType.JSON)
                .put("/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

        public static void deleteUnicorn(String id){
        given().delete("/unicorns/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
