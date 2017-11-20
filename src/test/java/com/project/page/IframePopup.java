package com.project.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class IframePopup extends BasePage {

    @FindBy(xpath = "//iframe[@class=\"popupBodyIfr\"]")
    private WebElement iframe;

    @FindBy(id = "enterBtn")
    private WebElement confirmButton;

    @FindBy(css = "div.search input")
    private WebElement searchInput;

    protected void search(String item) {
        switchTo(iframe);
        input(item, searchInput);
        new Actions(this.driver).sendKeys(Keys.ENTER).perform();
        findElement(By.xpath(String.format(
                "//tbody[last()]/tr/td[3][contains(text(),\"%s\")]/..//input[@name=\"items\"]", item
        )));
        click(confirmButton);
    }
}
