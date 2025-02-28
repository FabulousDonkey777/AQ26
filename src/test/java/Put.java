import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Put {
    @Test
    public void testPut() {
        Response response = RestAssured.given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .put("https://postman-echo.com/put");

        Assert.assertEquals(response.getStatusCode(), 200);

        String foo1 = response.jsonPath().getString("form.foo1");
        String foo2 = response.jsonPath().getString("form.foo2");

        Assert.assertEquals(foo1, "bar1");
        Assert.assertEquals(foo2, "bar2");
    }
}