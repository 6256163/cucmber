package com.project.step;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;

import java.util.Map;

class BasicStep {

    WebDriver driver;
    HookStep hook;
    public BasicStep(HookStep hook){
        this.hook = hook;
        this.driver = this.hook.getDriver();
    }
    Map<String,String> getArgs(DataTable arg){
        return arg.asMap(String.class,String.class);
    }

}
