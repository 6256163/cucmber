package com.project.step;


import com.project.page.Menu;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationStep extends BasicStep {
    @Autowired
    Menu menu;

    @Given("navigate: (.*)")
    public void navigate(String menu) {
        this.menu.clickMenu(menu);
    }
}
