package common;

import com.github.javafaker.Faker;
import dataProviders.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class RestActions {

    private Response response;
    private Faker faker;
    private BaseRestClient baseRestClient;

    public RestActions() {
        faker = new Faker();
        baseRestClient = new BaseRestClient(response);
    }

    public void getResource(String path) {

        Response response = baseRestClient.getResponse(path);
        this.response = response;

    }

    public void postResourceWithJson(String path, JSONObject object) {


        Response response = baseRestClient.postResponse(path, object);
        this.response = response;
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

    public JSONObject fillInRegistrationDetails(DataTable table) {

        JSONObject requestParams = new JSONObject();
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        String email = faker.internet().emailAddress();

        requestParams.put("title", data.get(0).get("title"));
        requestParams.put("first_name", data.get(0).get("first_name"));
        requestParams.put("sir_name", data.get(0).get("sir_name"));
        requestParams.put("email", email);
        requestParams.put("password", data.get(0).get("password"));
        requestParams.put("country", data.get(0).get("country"));
        requestParams.put("city", data.get(0).get("city"));
        requestParams.put("is_admin", data.get(0).get("is_admin"));
        return requestParams;
    }
}
