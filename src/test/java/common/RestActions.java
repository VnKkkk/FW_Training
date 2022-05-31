package common;

import dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.runner.Request;

import static io.restassured.RestAssured.given;

public class RestActions {

    private ConfigReader configReader;
    private Response response;
    private static String requestBody = "{\r\n" + " \"title\": \"Mr.\", \r\n" + " \"first_name\" : \"Misho\"\r\n" + " \"sir_name\" : \"Mishev\"\r\n" + " \"email\" : \"mishoss@email.com\"\r\n" + " \"password\" : \"pass123\"\r\n" + " \"country\" : \"Misho\"\r\n" + " \"city\" : \"Misho\"\r\n" + " \"is_admin\" : \"false\"\r\n" + "}";
    public RestActions() {

        configReader = new ConfigReader();
    }

    public void getResource(String path) {

        Response getResponse = RestAssured.get(configReader.getAPIUrl() + path);
        this.response = getResponse;

    }

    public void postResource(String path) {
         RequestSpecification request = RestAssured.given();
         request.header("Content-type", "application/json");
         Response response = request.body(requestBody).post(configReader.getAPIUrl() + path);
        System.out.println(response.getStatusLine());
    }

    public void returnBody() {

        System.out.println(response.getBody().asString());
    }

    public void returnStatusCode(String statusCode, String statusMessage) {

        String statusLine = response.getStatusLine();
        String[] array = statusLine.split("\\s+");
        System.out.println(array[1] + " " + array[2]);
        Assert.assertEquals(statusCode, array[1]);
        Assert.assertEquals(statusMessage, array[2]);
    }
}
