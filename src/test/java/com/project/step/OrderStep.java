package com.project.step;

import com.project.spy.Order;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class OrderStep extends BasicStep {

    public OrderStep(Context context) {
        super(context);
    }

    @When("new order")
    public void newOrder(){
        Order order = new Order(this.driver);
        order.createOrder();
    }

    @When("fill order")
    public void fillOrder(DataTable args){
        Order order = new Order(this.driver);
        order.fill(getArgs(args));
    }





}
