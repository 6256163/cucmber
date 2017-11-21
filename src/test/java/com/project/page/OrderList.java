package com.project.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class OrderList extends BasePage {

    @FindBy(tagName = "table")
    private WebElement tab = null;
    private List<WebElement> th = null;
    Map<String,Integer> m = new HashMap<String,Integer>();



    private WebElement getTab(){
        if (this.tab == null){
            this.tab = findElement(By.tagName("table"));
        }
        return this.tab;
    }

    private List<WebElement> getTh(){
        if(this.th==null){
            this.th = this.driver.findElements(By.tagName("th"));
        }
        return this.th;
    }

    // get all tr element
    private List<WebElement> getLines(){
        return this.driver.findElements(By.xpath("//tbody//tr"));
    }

    // get all the td under the specified tr
    private List<WebElement> getLine( WebElement tr){
        return tr.findElements(By.tagName("td"));

    }

    // get all the td under the first tr
    private List<WebElement> getLine(){
        WebElement tr = getTab().findElement(By.xpath("//tbody//tr"));
        return tr.findElements(By.tagName("td"));

    }

    public void execute(String opreation){
        click(By.xpath(String.format("//tbody//tr[1]//a[@title=\"%s\"]", opreation)));
    }

    public String verify(String columns){
        sleep(2);
        List<WebElement> tds = getLine();
        int i=0;
        if (this.m.size()==0){
            for (WebElement e: getTh()){
                Actions ac = new Actions(this.driver);
                ac.moveToElement(e);
                this.m.put(e.getText(), i);
                i++;
            }
        }

        return tds.get(m.get(columns)).getText();
    }

    public void search(String order){
        inputSubmit(order,By.cssSelector("input.searchTxt"));
    }


}
