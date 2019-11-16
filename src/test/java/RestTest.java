import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.*;

public class RestTest {
    public static class APITest {

        @Test
        public void openWeatherAPI() {
            RestAssured.baseURI = "http://api.openweathermap.org/";
            given()
                    .param("q", "london")
                    .param("appid", SECRETZ.WEATHER)
                    .when()
                    .request("GET", "data/2.5/weather")
                    .then().assertThat().statusCode(200)
                    .and().assertThat().body("weather.id", contains(803));
        }

        @Test
        public void googlePlacesAPI() {
            Response response = null;
            String jsonAsString;

            RestAssured.baseURI = "https://maps.googleapis.com";

            given()
                    .param("location", "-33.8670522,151.1957362")
                    .param("radius", "1500")
                    .param("type", "restaurant")
                    .param("keyword", "cruise")
                    .param("key", "AIzaSyD5BKl4A-PHYgy5ty0xaTtnKGVIbmX0xHc")
                    .when()
                    .get("/maps/api/place/nearbysearch/json")
                    .then().extract().response();

            jsonAsString = response.asString();
        }
    }
}
