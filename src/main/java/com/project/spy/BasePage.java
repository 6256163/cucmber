package com.project.spy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    /**
     * BasePage class to identify the common functions
     */
    protected WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        sleep(2);

    }

    protected WebElement findElement(By by){
        WebElement ele = (new WebDriverWait(this.driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        try{
            Actions action = new Actions(this.driver);
            action.moveToElement(ele).perform();
        }
        catch (MoveTargetOutOfBoundsException e){
            ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", ele);

        }
        System.out.println(by.toString());
        return ele;
    }

    protected void click(WebElement e){
        String txt = e.getText();
        try{
            Actions action = new Actions(this.driver);
            action.click(new WebDriverWait(this.driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(e))).perform();
        }
        catch (MoveTargetOutOfBoundsException exception){
            ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", e);
            e.click();
        }

        System.out.println("Click: "+  txt);
        sleep(1);
        //new WebDriverWait(this.driver, 10).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void click(By by){
        WebElement e = new WebDriverWait(this.driver, 10)
                .until(ExpectedConditions.elementToBeClickable(by));
        Actions action = new Actions(this.driver);
        action.click(findElement(by)).perform();
        System.out.println("Click: "+ by.toString());
        sleep(1);
        //new WebDriverWait(this.driver, 10).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void input(String value, WebElement e){
        e.clear();
        e.sendKeys(value);
        System.out.println(String.format("Input: %s to %s", value, e.getText()));

    }

    protected void inputSubmit(String value, By by){
        WebElement ele = findElement(by);
        ele.clear();
        ele.sendKeys(value);
    }

//
//
//    protected void confirmDialog(String text){
//        click(By.xpath(String.format("//div[@role=\"dialog\"]//button[.=\"%s\"]", text)));
//    }


    protected void switchTo(WebElement e){
        this.driver.switchTo().defaultContent();
        this.driver.switchTo().frame(e);
    }

    protected void sleep(float second) {
        long start = System.currentTimeMillis( );
        while (System.currentTimeMillis( ) - start <second*1000);
        //Thread.sleep(second*1000);
    }

    private void waitFor(By by){
//        try{
//            WebElement ele = (new WebDriverWait(this.driver, 10))
//                    .until(ExpectedConditions.presenceOfElementLocated(by));
//            while (ele.isDisplayed()){
//                if (by.toString().equals("By.cssSelector: div.datalist_loading_mask")){
//                    System.out.println(System.currentTimeMillis( ));;
//                }
//            }
//        }
//        catch (NoSuchElementException e){
//            System.out.println("cannot find element"+by.toString());
//        }
//        catch (TimeoutException e){
//            System.out.println("cannot find element"+by.toString());
//        }
        sleep(3);
        (new WebDriverWait(this.driver, 30))
                .until(ExpectedConditions.invisibilityOf(findElement(by)));
        while (findElement(by).isDisplayed()){
            System.out.println("Wait: "+by.toString());
        }

    }

    protected void waitForAjaxLoading(){
        waitFor(By.cssSelector("div.ajaxloading_mask"));
    }

    protected void waitForCreateTable(){
        waitFor(By.cssSelector("div.autoInfoIndicator"));
    }

    protected void waitForDatelistLoading(){
        waitFor(By.cssSelector("div.datalist_loading_mask"));
    }

    protected void waitForGridTableLoading(){
        waitFor(By.cssSelector("div#grid_table_loading"));
    }





}
