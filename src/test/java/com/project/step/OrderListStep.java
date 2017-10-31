package com.project.step;

import com.project.spy.OrderList;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class OrderListStep extends BasicStep {

    public OrderListStep(HookStep hook){
        super(hook);
    }

    @Then("check order")
    public void checkOrder(DataTable args){
        OrderList orderList = new OrderList(this.driver);
        Map<String, String> m = getArgs(args);
        for (String key : m.keySet()) {
            String expect = m.get(key);
            String actual = orderList.verify(key);
            Assert.assertEquals(actual,expect);
            System.out.println(String.format("Expect: %s. Actual:%s", expect, actual));
        }

    }

}
