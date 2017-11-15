package com.project.step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Context {

    private WebDriver driver;

    public void initDriver(String browser) {
        String suffix = "";
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            suffix = ".exe";
        }
        if (browser.toUpperCase().equals("CHROME")) {
            Path path = Paths.get("src", "driver", "chromedriver" + suffix);
            System.setProperty("webdriver.chrome.driver", path.toString());
            this.driver = new ChromeDriver();
        } else {
            Path path = Paths.get("src", "driver", "geckodriver" + suffix);
            System.setProperty("webdriver.gecko.driver", path.toString());
            this.driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
