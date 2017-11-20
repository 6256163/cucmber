package com.project.step;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.page.Order;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderStep extends BasicStep {
    @Autowired
    Order order;


    @When("new order")
    public void newOrder() {
        order.createOrder();
    }

    @When("fill order")
    public void fillOrder(DataTable args) {
        order.fill(getArgs(args));
    }


}
