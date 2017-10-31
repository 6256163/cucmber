package com.project.step;

import com.project.spy.Menu;
import cucumber.api.java.en.Given;

public class NavigationStep extends BasicStep {


    public NavigationStep(HookStep hook) {
        super(hook);
    }


    @Given("navigate: (.*)")
    public void navigate(String menu) {
        Menu m = new Menu(driver);
        m.clickMenu(menu);
    }
}
