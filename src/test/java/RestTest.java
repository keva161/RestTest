import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestTest
{
    public static class MyClassTest {

        @Test
        public void testSomething() {
            RestAssured.baseURI="http://api.openweathermap.org/";

            given().
                    param("q", "london").
                    param("appid", SECRETZ.WEATHER).
            when().
                    request("GET","data/2.5/weather").
            then().
                    assertThat().statusCode(200);
        }
    }
}
