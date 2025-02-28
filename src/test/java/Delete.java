import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete{
    @Test
    public void testDelete() {
        Response response = RestAssured.given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .delete("https://postman-echo.com/delete");

        Assert.assertEquals(response.getStatusCode(), 200);

        String foo1 = response.jsonPath().getString("form.foo1");
        String foo2 = response.jsonPath().getString("form.foo2");

        Assert.assertEquals(foo1, "bar1");
        Assert.assertEquals(foo2, "bar2");
    }
}