package com.project.step;

import com.project.page.OrderList;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class OrderListStep extends BasicStep {
    @Autowired
    OrderList orderList;



    @Then("check order")
    public void checkOrder(DataTable args){
        Map<String, String> m = getArgs(args);
        for (String key : m.keySet()) {
            String expect = m.get(key);
            String actual = orderList.verify(key);
            Assert.assertEquals(actual,expect);
            System.out.println(String.format("Expect: %s. Actual:%s", expect, actual));
        }

    }

}
