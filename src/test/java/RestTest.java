import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestTest
{
    public static class MyClassTest {

        @Test
        public void testSomething() {
            RestAssured.baseURI="https://maps.googleapis.com";
            given().
                    param("location", "-33.8670522,151.1957362").
                    param("radius","1500").
                    param("type", "restaurant").
                    param("keyword", "cruise").
                    param("key", "AIzaSyD5BKl4A-PHYgy5ty0xaTtnKGVIbmX0xHc").
            when().
                    get("maps/api/place/nearbysearch/json").
            then().
                    assertThat().statusCode(200).and().contentType(ContentType.JSON);
        }
    }
}
