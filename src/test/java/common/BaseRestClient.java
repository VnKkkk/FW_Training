package common;

import dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.security.PublicKey;

import static io.restassured.RestAssured.given;

public class BaseRestClient {
    private ConfigReader configReader;
    Response response;

    public BaseRestClient(Response response){
        this.response = response;
        configReader = new ConfigReader();
    }

    public Response getResponse(String path){

        return RestAssured.get(configReader.getAPIUrl() + path);
    }

    public Response postResponse(String path, JSONObject object){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(object.toJSONString())
                .when()
                .post(configReader.getAPIUrl() + path)
                .then()
                .extract().response();

    }

    public Response postWithLombok(String path, String object){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(object)
                .when()
                .post(configReader.getAPIUrl() + path)
                .then()
                .extract().response();

    }

    public Response deleteResponse(String id){
        return given()
                .header("Content-type", "application/json")
                .delete(configReader.getAPIUrl() + "/users/" + id);
    }

    public Response putResponse(String id, String path, String body){
        return  given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .put(configReader.getAPIUrl() + path + id)
                .then()
                .extract()
                .response();
    }

}
