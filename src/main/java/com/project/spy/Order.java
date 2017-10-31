package com.project.spy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class Order extends BasePage{

    public Order(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "我要下单")
    public WebElement newOrder;

    @FindBy(id = "order_orderName")
    public WebElement orderNameInput;

    @FindBy(xpath = "//button[@title=\"选择\"]")
    public WebElement advSelectButton;

    @FindBy(id = "order_productLine")
    public WebElement productLineSelect;

    @FindBy(id = "order_orderType")
    public WebElement orderTypeSelect;

    @FindBy(id = "order_IsSpecialFlowFlag_0")
    public WebElement specialFlowRadio;

    @FindBy(xpath = "//input[@value = \"提交\"]")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@value = \"审批\"]")
    public WebElement auditButton;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[.=\"关闭\"]")
    private WebElement comfirmDialog;

    @FindBy(xpath = "//iframe[@class=\"popupBodyIfr\"]")
    private WebElement iframe;

    public void createOrder() {
        waitForDatelistLoading();
        click(newOrder);
    }

    protected void inputName(String name) {
        input(name, orderNameInput);
    }

    protected void inputAdv(String adv) {
        click(advSelectButton);
        click(advSelectButton);

        Iframe ifr = new Iframe(this.driver, iframe);
        ifr.search(adv);
        this.driver.switchTo().defaultContent();
        while (productLineSelect.getText().equals("")) {
            sleep(1);
        }
    }

    protected void inputOrderType(String type) {
        Select sel = new Select(orderTypeSelect);
        sel.selectByValue(type);
    }

    protected void setSpecialFlow() {
        click(specialFlowRadio);
    }

    protected void submit() {
        click(submitButton);
        sleep(10);
        click(comfirmDialog);
    }

    protected void audit() {
        click(auditButton);
        click(comfirmDialog);
    }


    public void fill(Map<String, String> args) {
        if (!args.getOrDefault("name","").equals("")){
            inputName(args.get("name"));
        }
        if (!args.getOrDefault("adv","").equals("")){
            inputAdv(args.get("adv"));
        }
        if (!args.getOrDefault("ordertype","").equals("")){
            inputOrderType(args.get("ordertype"));
        }
        if (!args.getOrDefault("specialflow","").equals("")){
            setSpecialFlow();
        }
        if (!args.getOrDefault("submit","").equals("")){
            submit();
        }
        if (!args.getOrDefault("audit","").equals("")){
            audit();
        }

    }
}


