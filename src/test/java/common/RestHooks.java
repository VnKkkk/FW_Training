package common;

import io.cucumber.java.After;

public class RestHooks {

    private RestActions restActions;

    public RestHooks() {
        restActions = new RestActions();

    }

    @After("@rest")
    public void deleteUser(){
        restActions.deleteUser();
    }
}
