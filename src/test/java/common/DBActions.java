package common;

import POM.UserModel;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.modelmapper.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBActions {

    private ResultSet resultSet;
    private UserModel userModel = new UserModel();
    private DefaultUser defaultUser = new DefaultUser();
    private DBQueries dbQueries = new DBQueries();
    List<UserModel> usersList = new ArrayList<>();
    private JDBCConnector jdbcConnector;
    public static String email;
    private String firstName;
    private String lastName;

    {
        try {
            jdbcConnector = new JDBCConnector();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void getAllUsers() throws SQLException {

        resultSet = jdbcConnector.getStatement().executeQuery(dbQueries.selectAll);

        settingUpUser(resultSet, userModel, usersList);

    }

    public void creatingNewUser(DataTable table) throws SQLException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        ModelMapper modelMapper = new ModelMapper();
        UserModel user = modelMapper.map(data.get(0), UserModel.class);

        String query = dbQueries.addNewUser(
                user.getId(),
                user.getIs_admin(),
                user.getFirstName(),
                user.getSirName(),
                user.getTitle(),
                user.getCountry(),
                user.getCity(),
                user.getEmail(),
                user.getPassword());


        this.email = user.getEmail();
        jdbcConnector.getStatement().executeUpdate(query);

    }

    public void assertingUserIsCreated() throws SQLException {
        resultSet = jdbcConnector.getStatement().executeQuery(dbQueries.selectWithEmail(email));

        settingUpUser(resultSet, userModel, usersList);
        Assert.assertEquals(userModel.getEmail(), email);

    }

    public void assertingUserNameAndSirNameAreUpdated() throws SQLException {
        resultSet = jdbcConnector.getStatement().executeQuery(dbQueries.selectWithEmail(email));

        settingUpUser(resultSet, userModel, usersList);

        Assertions.assertAll(
                () -> Assert.assertEquals(userModel.getEmail(), email),
                () -> Assert.assertEquals(userModel.getFirstName(), firstName),
                () -> Assert.assertEquals(userModel.getSirName(), lastName)
        );
    }

    public void asserUserIsDeleted() throws SQLException {
        resultSet = jdbcConnector.getStatement().executeQuery(dbQueries.selectWithEmail(email));

        settingUpUser(resultSet, userModel, usersList);
        Assert.assertNull(userModel.getEmail());
    }


    public void deleteUser() throws SQLException {

        jdbcConnector.getStatement().executeUpdate(dbQueries.deleteUser(email));

    }

    public void creatingNewDefaultUser() throws SQLException {

        UserModel user = defaultUser.createUserWithDB();

        String query = dbQueries.addNewUser(
                user.getId(),
                user.getIs_admin(),
                user.getFirstName(),
                user.getSirName(),
                user.getTitle(),
                user.getCountry(),
                user.getCity(),
                user.getEmail(),
                user.getPassword());

        this.email = user.getEmail();

        jdbcConnector.getStatement().executeUpdate(query);
    }

    public void updateUserDetails(String firstName, String lastName) throws SQLException {
        this.firstName = firstName;
        this.lastName = lastName;
        String query = dbQueries.updateFirstAndLastName(firstName, lastName, email);
        jdbcConnector.getStatement().executeUpdate(query);
    }

    public void assertAllUsersAreDisplayed() {
        Assert.assertTrue(usersList.size() > 6);
    }

    private void settingUpUser(ResultSet result, UserModel user, List<UserModel> usersModelList) throws SQLException {

        while (result.next()) {
            user.setTitle(result.getString("title"));
            user.setFirstName(result.getString("first_name"));
            user.setSirName(result.getString("sir_name"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setCountry(result.getString("country"));
            user.setCity(result.getString("city"));
            user.setIs_admin(result.getString("is_admin"));
            user.setId(result.getString("id"));

            usersModelList.add(user);
            System.out.println(user);
        }
    }


}
