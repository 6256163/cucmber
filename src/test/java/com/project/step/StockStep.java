package com.project.step;

import com.project.spy.Stock;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class StockStep extends BasicStep {

    public StockStep(HookStep hook){
        super(hook);
    }

    @When("stock query")
    public void stockQuery(DataTable args){
        Stock sotck = new Stock(this.driver);
        sotck.query(getArgs(args));
    }

    @When("add new order")
    public void addNewOrder(DataTable args){
        Stock sotck = new Stock(this.driver);
        sotck.addOrder(getArgs(args));
    }





}
