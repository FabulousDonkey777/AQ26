import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get {
    @Test
    public void testGet() {
        Response response = RestAssured.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");

        Assert.assertEquals(response.getStatusCode(), 200);

        String foo1 = response.jsonPath().getString("args.foo1");
        String foo2 = response.jsonPath().getString("args.foo2");

        Assert.assertEquals(foo1, "bar1");
        Assert.assertEquals(foo2, "bar2");
    }
}