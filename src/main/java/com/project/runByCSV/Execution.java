package com.project.runByCSV;

import com.project.spy.*;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Execution{

    private Login login;
    private Menu menu;
    private Order order;
    private OrderList orderList;
    private Stock sotck;

    public Execution(WebDriver driver){
        this.login = new Login(driver);
        this.menu = new Menu(driver);
        this.order = new Order(driver);
        this.orderList = new OrderList(driver);
        this.sotck = new Stock(driver);
    }

    protected void action(String action, String args) throws InterruptedException {

        // process args for ACTION
        Map<String,String> actionItems = getArgs(args);

        // execute ACTION
        action = action == null?"":action.toUpperCase();
        switch (action.toUpperCase()){

            case "SWITCH_SYSTEM":
                this.login.switchSystem(actionItems.get("type"));
                break;
            case "LOGIN":
                this.login.login(actionItems);
                break;
            case "MENU":
                this.menu.clickMenu(actionItems.get("menu"));
                break;
            case "ORDER_NEW":
                this.order.createOrder();
                break;
            case "STOCK_QUERY":
                this.sotck.query(actionItems);
                break;
            case "STOCK_ADD_ORDER":
                this.sotck.addOrder(actionItems);
                break;
            case "ORDER_FILL":
                this.order.fill(actionItems);
                break;
        }
    }

    protected void expect(String expect, String args, String expectValue){

        // process args for EXPECT
        Map<String,String> expectItems = getArgs(args);

        // execute EXPECT
        String actualValue = null;
        expect = expect == null?"":expect.toUpperCase();
        switch (expect){
            case "ORDER_LIST_VERIFY":
                actualValue = this.orderList.verify(expectItems.get("column"));

        }
        assert actualValue!=null||actualValue.equals(expectValue):
                String.format("Expect: %s. Actual: %s", expectValue,actualValue);

    }

    private Map<String,String> getArgs(String args){
        Map<String,String> actionItems = new HashMap<String,String>();
        if(args!=null){
            for (String item : args.split("\\|")){
                String[] items = item.split(":");
                actionItems.put(items[0].toLowerCase(),items[1]);
            }
        }
        return actionItems;
    }
}
