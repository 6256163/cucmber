package com.project.runByCSV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {


    private WebDriver driver;
    private String node="127.0.0.1";
    protected WebDriver getDriver(String d){

        String suffix = "";
        if(System.getProperty("os.name").toLowerCase().startsWith("win")){
            suffix = ".exe";
        }
        if (d.toUpperCase().equals("CHROME")){
            Path path = Paths.get("src","driver","chromedriver"+suffix);
            System.setProperty("webdriver.chrome.driver", path.toString());
            this.driver = new ChromeDriver();
        }
        else if(d.toUpperCase().equals("FIREFOX")){
            Path path = Paths.get("src","driver","geckodriver"+suffix);
            System.setProperty("webdriver.gecko.driver", path.toString());
            this.driver = new FirefoxDriver();
        }
        this.driver.manage().window().maximize();
        return this.driver;
    }
}
