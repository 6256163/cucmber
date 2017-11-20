package com.project.step;

import cucumber.api.DataTable;
import org.springframework.stereotype.Component;

import java.util.Map;



public class BasicStep {

    Map<String,String> getArgs(DataTable arg){
        return arg.asMap(String.class,String.class);
    }

}
