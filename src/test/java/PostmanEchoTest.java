import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    static {
        baseURI = "https://postman-echo.com";
    }

    @Test public void testGetRequest(){
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {
        String body = "check body data";
        given()
                .body(body)
                .header("Content-Type", "text/plain")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void restPutRequest(){
        String body = "check body data";
        given()
                .body(body)
                .header("Content-Type", "text/plain")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    public void testPatchRequest() {
        String body = "check body data";
        given()
                .body(body)
                .header("Content-Type", "text/plain")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .queryParam("confirm", "yes")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.confirm", equalTo("yes"));
    }


}
