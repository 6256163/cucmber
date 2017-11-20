package com.project.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class IframeDialog extends BasePage {

    @FindBy(xpath = "//iframe[@class=\"dialogBodyIfr\"]")
    private WebElement iframe;


    @FindBy(xpath = "//button[@title=\"清空\"]")
    private WebElement clearButton;

    @FindBy(id = "enterBtn")
    private WebElement confirmButton;

    @FindBy(id = "cancelBtn")
    private WebElement cancelButton;

    @FindBy(css = "div.search input")
    private WebElement searchInput;


    protected void select(String[] items) {
        switchTo(iframe);
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

}
