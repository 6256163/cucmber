package com.project.page;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Menu extends BasePage {

    private Map<String,By[]> map = new HashMap<String,By[]>();
    public Menu() {
        this.map.put("index", new By[]{By.partialLinkText("首页")});
        this.map.put("order", new By[]{By.partialLinkText("订单管理")});
        this.map.put("order_list", new By[]{map.get("order")[0], By.partialLinkText("订单列表")});
        this.map.put("order_audit", new By[]{map.get("order")[0], By.partialLinkText("订单审核概览")});
        this.map.put("price_list", new By[]{map.get("order")[0], By.partialLinkText("价格政策列表")});
        this.map.put("price_audit", new By[]{map.get("order")[0], By.partialLinkText("价格政策审批概览")});
        this.map.put("source", new By[]{By.partialLinkText("资源管理")});
        this.map.put("stock_booked", new By[]{map.get("source")[0], By.partialLinkText("库存预定")});
        this.map.put("stock_set", new By[]{map.get("source")[0], By.partialLinkText("库存设置")});
        this.map.put("report", new By[]{By.partialLinkText("数据报表")});
        this.map.put("order_report", new By[]{map.get("report")[0], By.partialLinkText("广告销售报表")});
        this.map.put("ad_report", new By[]{map.get("report")[0], By.partialLinkText("媒体资源报表")});
        this.map.put("system", new By[]{By.partialLinkText("系统管理")});
        this.map.put("user_list", new By[]{map.get("system")[0], By.partialLinkText("用户管理")});
        this.map.put("order_process", new By[]{map.get("system")[0], By.partialLinkText("订单审批设置")});
        this.map.put("price_process", new By[]{map.get("system")[0], By.partialLinkText("议价审批设置")});
        this.map.put("role_list", new By[]{map.get("system")[0], By.partialLinkText("角色管理")});
        this.map.put("suning", new By[]{By.partialLinkText("易购资源")});
        this.map.put("stock_report", new By[]{map.get("suning")[0], By.partialLinkText("库存报表")});
        this.map.put("price_policy", new By[]{map.get("suning")[0], By.partialLinkText("价格政策管理")});
    }


    public void clickMenu(String menuName){
        for(By by: this.map.get(menuName)){
            click(by);
        }

//        switch (menuName){
//            case "order_list":
//                return new Order(this.driver);
//        }
    }






}
