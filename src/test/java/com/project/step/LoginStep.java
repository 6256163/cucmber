package com.project.step;


import com.project.page.Login;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginStep extends BasicStep {
    @Autowired
    Login login;


    @When("login user")
    public void loginUser(DataTable args){
        assert  args != null;
        this.login.login(getArgs(args));
    }

    @When("switch system: (.*)")
    public void switchSystem(String type){
        this.login.switchSystem(type);
    }
}
