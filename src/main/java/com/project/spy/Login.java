package com.project.spy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class Login extends BasePage {

    String url = "";

    public Login(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    public Login(WebDriver driver) {
        super(driver);
        this.url = "http://10.200.44.60/site/superentrance";
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="LoginForm_username")
    private WebElement usernameInput;


    @FindBy(id="LoginForm_password")
    private WebElement passwordInput;


    @FindBy(id="LoginForm_verifyCode")
    private WebElement verifycodeInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    public void login(Map<String, String> args){
        this.driver.get(this.url);

        if (!args.getOrDefault("username","").equals("")){
            input(args.get("username"), usernameInput);
        }
        if (!args.getOrDefault("password","").equals("")){
            input(args.get("password"), passwordInput);
        }
        if (!args.getOrDefault("verifycode","").equals("")){
            input(args.get("verifycode"), verifycodeInput);
        }
        click(loginButton);
        waitForAjaxLoading();
    }


    @FindBy(css = "div.myaccount")
    private WebElement myAccountLabel;


    @FindBy(id="logout")
    private WebElement logoutLabel;

    @FindBy(xpath = "//div[@role=\"dialog\"]//button[.=\"确定\"]")
    private WebElement comfirmDialog;

    public void logout(){
        click(myAccountLabel);
        click(logoutLabel);
        click(comfirmDialog);
    }



    @FindBy(id = "systemType")
    private WebElement sysType;

    public void switchSystem(String type){
        click(myAccountLabel);
        if (sysType.getAttribute("textContent").contains(type)){
            click(sysType);
        }
        waitForAjaxLoading();
    }

}
