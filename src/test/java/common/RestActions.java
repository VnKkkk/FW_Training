package common;

import dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestActions {

    private ConfigReader configReader;

    public RestActions() {

        configReader = new ConfigReader();
    }

    public void getResource(String path) {

        Response response = RestAssured.get(configReader.getAPIUrl()+path);
        System.out.println(response.getStatusCode());
    }

}
