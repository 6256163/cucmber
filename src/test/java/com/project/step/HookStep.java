package com.project.step;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class HookStep extends BasicStep {

    public HookStep(Context context) {
        super(context);
    }

    @Before
    public void setUp(Scenario scenario) throws Exception {
        String browser;
        if (scenario.getSourceTagNames().contains("@firefox")){
            context.initDriver("firefox");
        }
        else{

        }
    }

    @After
    public void cleanUp() throws Exception{
        this.driver.quit();
    }


}
