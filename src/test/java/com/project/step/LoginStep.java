package com.project.step;

import com.project.spy.Login;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class LoginStep extends BasicStep {

    public LoginStep(Context context) {
        super(context);
    }

    @When("login user")
    public void loginUser(DataTable args){
        Login login = new Login(driver);
        login.login(getArgs(args));
    }

    @When("switch system: (.*)")
    public void switchSystem(String type){
        Login login = new Login(driver);
        login.switchSystem(type);
    }
}
