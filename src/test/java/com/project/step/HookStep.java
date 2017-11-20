package com.project.step;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class HookStep extends BasicStep {


    @Autowired
    private WebDriver webDriver;
    @Before
    public void setUp(Scenario scenario) throws Exception {

    }

    @After
    public void cleanUp() throws Exception{
        webDriver.close();
    }


}
