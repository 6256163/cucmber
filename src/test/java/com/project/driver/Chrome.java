package com.project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Profile("chrome")
public class Chrome {

    @Bean
    public WebDriver setup() {
        String suffix = "";
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            suffix = ".exe";
        }
        Path path = Paths.get("src", "driver", "chromedriver" + suffix);
        System.setProperty("webdriver.chrome.driver", path.toString());
        return new ChromeDriver();
    }
}
