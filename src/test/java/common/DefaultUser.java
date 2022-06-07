package common;

import POM.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DefaultUser {

    private User user;

    public DefaultUser(){
        user = new User();
    }

    public String addingUserDetails(){
        user.setTitle("Mr.");
        user.setFirst_name("Nikolay");
        user.setSir_name("Ivanov");
        user.setEmail("niki@email.com");
        user.setPassword("pass123");
        user.setCountry("BG");
        user.setCity("Sofia");
        user.setIs_admin("0");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(user);
    }
}
