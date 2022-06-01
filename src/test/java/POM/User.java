package POM;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class User {

    private String title;
    private String first_name;
    private String sir_name;
    private String email;
    private String password;
    private String country;
    private String city;
    private String is_admin;
}
