package com.project.step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class HookStep {

    private static boolean initialized = false;
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        if (!initialized) {
            // initialize the driver

            String suffix = "";
            if(System.getProperty("os.name").toLowerCase().startsWith("win")){
                suffix = ".exe";
            }
            Path path = Paths.get("src","driver","geckodriver"+suffix);
            System.setProperty("webdriver.gecko.driver", path.toString());
            driver = new FirefoxDriver();

            initialized = true;
        }
    }


    @After
    public void cleanUp() throws Exception{
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
