package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Profile({"firefox","default"})
public class FireFox {

    @Bean
    public WebDriver setup() {
        String suffix = "";
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            suffix = ".exe";
        }
        Path path = Paths.get("src", "driver", "geckodriver" + suffix);
        System.setProperty("webdriver.gecko.driver", path.toString());
        return new FirefoxDriver();
    }
}
