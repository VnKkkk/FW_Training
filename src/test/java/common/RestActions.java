package common;

import dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class RestActions {

    private ConfigReader configReader;
    private Response response;

    public RestActions() {

        configReader = new ConfigReader();
    }

    public void getResource(String path) {

        Response getResponse = RestAssured.get(configReader.getAPIUrl() + path);
        this.response = getResponse;

    }

    public void returnBody() {

        System.out.println(response.getBody().asString());

    }

    public void returnStatusCode(String statusCode, String statusMessage) {

        String statusLine = response.statusLine();
        String[] array = statusLine.split("\\s+");
        System.out.println(array[1] + " " + array[2]);
        Assert.assertEquals(statusCode, array[1]);
        Assert.assertEquals(statusMessage, array[2]);
    }
}
