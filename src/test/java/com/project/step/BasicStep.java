package com.project.step;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;

import java.util.Map;

class BasicStep {

    public WebDriver driver;
    public Context context;

    public BasicStep(Context context){
        this.context = context;
        this.driver = this.context.getDriver();
    }
    Map<String,String> getArgs(DataTable arg){
        return arg.asMap(String.class,String.class);
    }

}
