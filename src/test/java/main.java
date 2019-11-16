import com.google.gson.Gson;
import io.restassured.RestAssured;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minidev.json.JSONArray;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.security.SignedObject;
import java.util.List;

import static io.restassured.RestAssured.given;

public class main {

    public static Response response;
    public static JsonPath jsonPath;
    public static String firstObject;


    public static void main(String[] args) {


        RestAssured.baseURI = "https://www.omdbapi.com/";

        JsonArray jsonarray = new JsonArray();

        response =
        given()
                .param("s", "Toy Story")
                .param("apikey", SECRETZ.MOVIES)
                .when()
                .get()
                //.as(Movie.class);
                .then().extract().response();

        String responseString = response.asString();

        JsonPath jsonPathEvaluator = response.jsonPath();

        // Locate exact set of rows
        List<String> facts = jsonPathEvaluator.getList("Search.Title");

        for (String title : facts) {
            System.out.println(title);
        }

        // Number of objects in a JSON response

        List<String> factsSize = jsonPathEvaluator.getList("Search");

        System.out.println("There are: " + factsSize.size() + " objects returned by the query");


    }
}
