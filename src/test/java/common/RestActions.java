package common;

import POM.User;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Assert;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;

public class RestActions {

    private Response response;
    public static String id;
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

    public void postResourceWithLombok(String path, String text) {


        Response response = baseRestClient.postWithLombok(path, text);
        this.response = response;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String string = response.andReturn().getBody().asString();
        Object object = JSONValue.parse(string);
        JSONObject jsonObject = (JSONObject)object;


        String ID = ((JSONObject)object).get("id").toString();
        this.id = ID;

        String body = gson.toJson(string);
        System.out.println(body);
    }

        public void putResource(String path, String body){
        Response response = baseRestClient.putResponse(id, path, body);
            System.out.println(body);
        }

    public void deleteUser(){
        baseRestClient.deleteResponse(id);
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

    public String fillInRegistrationWithLombok(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(data.get(0), User.class);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(user);

    }
}
