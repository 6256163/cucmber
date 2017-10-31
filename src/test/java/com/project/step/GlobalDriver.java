package com.project.step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GlobalDriver {
    private GlobalDriver() {}
    private static WebDriver driver=null;
    //静态工厂方法
    public static WebDriver getDriver() {
        if (driver == null) {
            String suffix = "";
            if(System.getProperty("os.name").toLowerCase().startsWith("win")){
                suffix = ".exe";
            }
            Path path = Paths.get("src","driver","geckodriver"+suffix);
            System.setProperty("webdriver.gecko.driver", path.toString());
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
