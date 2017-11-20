package com.project.step;


import com.project.page.Stock;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StockStep extends BasicStep {
    @Autowired
    Stock sotck;

    @When("stock query")
    public void stockQuery(DataTable args) {
        sotck.query(getArgs(args));
    }

    @When("add new order")
    public void addNewOrder(DataTable args) {
        sotck.addOrder(getArgs(args));
    }


}
