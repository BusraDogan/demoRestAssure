import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


public class testAssured {
@Test
    public void singleUserTestBDD(){
    when()
            .get("https://reqres.in/api/users/2")
            .then()
            .statusCode(200)
            .body("data.email", equalTo ("janet.weaver@reqres.in"))
            .time(lessThan(3000L));

}

    @Test
    public void createUserTest() {
        String postData = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"leader\"\n" +
                "}";
        given()
                .contentType(ContentType.JSON).
                body(postData)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"));
    }

}
