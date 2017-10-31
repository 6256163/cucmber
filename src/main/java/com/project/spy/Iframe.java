package com.project.spy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Iframe extends BasePage {

    String xpath;
    Iframe(WebDriver driver, WebElement frame) {
        super(driver);
//        List<WebElement> eles = this.driver.findElements(By.xpath("//iframe[@class=\"popupBodyIfr\"]"));
//        WebElement e = eles.size() != 0 ? eles.get(0) : findElement(By.xpath("//iframe[@class=\"dialogBodyIfr\"]"));
        switchTo(frame);
    }

    @FindBy(xpath = "//button[@title=\"清空\"]")
    private WebElement clearButton;

    @FindBy(id = "enterBtn")
    private WebElement confirmButton;

    @FindBy(id = "cancelBtn")
    private WebElement cancelButton;

    @FindBy(css = "div.search input")
    private WebElement searchInput;


    protected void select(String[] items) {
        if (items.length == 0) {
            click(clearButton);
        }
        for (String item : items) {
            WebElement item_a = findElement(By.partialLinkText(item));
            WebElement item_i = item_a.findElement(By.xpath("../i"));
            if (item.equals(items[items.length - 1])) {
                item_a.findElement(By.xpath("../img")).click();
            } else {
                item_i.click();
            }
        }
        click(By.xpath("//button[@title=\"选择\"]"));
        click(confirmButton);
    }


    protected void search(String item) {
        input(item, searchInput);
        new Actions(this.driver).sendKeys(Keys.ENTER).perform();
        findElement(By.xpath(String.format(
                "//tbody[last()]/tr/td[3][contains(text(),\"%s\")]/..//input[@name=\"items\"]", item
        )));
        click(confirmButton);
    }


}

