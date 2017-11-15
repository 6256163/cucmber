package com.project.spy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Stock extends BasePage{

    public Stock(WebDriver driver){
        super(driver);
    }


    protected void switchChargeType(String type){
        if(type.toUpperCase().equals("CPT")){
            type = "CPT库存报表";
        }
        else if (type.toUpperCase().equals("CPM")){
            type = "CPM库存报表";
        }
        else{
            type = null;
        }
        click(By.xpath(String.format("//ul[@class=\"page_tabs\"]/li[.=\"%s\"]", type)));
        waitForAjaxLoading();
    }

    @FindBy(css = "#filterDatepicker .icon")
    private WebElement datePicker;

    @FindBy(css = "input.start")
    private WebElement startTime;

    @FindBy(css = "input.end")
    private WebElement endTime;

    @FindBy(css = "button.enter")
    private WebElement dateEnter;

    @FindBy(xpath = "//iframe[@class=\"dialogBodyIfr\"]")
    private WebElement iframe;

    @FindBy(xpath = "//input[@data-bind=\"value: adSlot.ids\"]/following-sibling::button")
    private WebElement adrSelectButton;

    @FindBy(xpath = "//input[@data-bind=\"value: region.ids\"]/following-sibling::button")
    private WebElement areaSelectButton;

    @FindBy(xpath = "//input[@data-bind=\"value: content.ids\"]/following-sibling::button")
    private WebElement contentSelectButton;

    @FindBy(xpath = "//li[@data-search-term=\"客户端\"]/ancestor::td//button")
    private WebElement portLabel;

    @FindBy(xpath = "//li[@data-search-term=\"01:00 ~ 02:00\"]/ancestor::td//button")
    private WebElement timeLabel;

    @FindBy(xpath = "//input[@value=\"0\"][@name=\"followingExamType\"]")
    private WebElement exameDisable;

    @FindBy(xpath = "//input[@value=\"1\"][@name=\"followingExamType\"]")
    private WebElement exameEnable;

    @FindBy(css = "div.followingExam_customCRT input")
    private WebElement exameClickRate;

    @FindBy(css = "div.followingExam_customTxt input")
    private WebElement exameOthers;

    @FindBy(xpath = "//select[@data-bind=\"value: throwForm\"]")
    private WebElement thorwTypeSelect;

    @FindBy(css = "div.cpm_set input")
    private WebElement cpmInput;

    @FindBy(css = "div.btnbar button.enterBtn")
    private WebElement cpmEnter;




    protected void selectDate(String dates){
        click(datePicker);
        String[] d = dates.split(";");
        input(int2Date(d[0]),startTime);
        input(int2Date(d[1]),endTime);
        click(dateEnter);

    }

    private void select(String items, WebElement e){
        for(String item: items.split(";")){
            click(e);
            Iframe sel = new Iframe(this.driver,iframe);
            sel.select(items.split("\\."));
            this.driver.switchTo().defaultContent();
        }
    }

    protected void selectAdr(String items){
        select(items, adrSelectButton);
    }

    protected void selectArea(String items){
        select(items, areaSelectButton);
    }

    protected void selectContent(String items){
        select(items, contentSelectButton);
    }

    protected void selectPort(String ports){
        click(portLabel);
        for(String p: ports.split(";")){
            portLabel.findElement(By.xpath(String.format("//li[@data-search-term=\"%s\"]", p))).click();
        }
        portLabel.click();
    }

    protected void selectThrowTime(String times){
        click(timeLabel);
        for(String p: times.split(";")){
            timeLabel.findElement(By.xpath(String.format("ancestor::td//input[@value=\"%s\"]", p))).click();
        }
        timeLabel.click();
    }

    protected void selectExam(String exam){
        // select exam "无"
        if (exam.equals("0")){
            click(exameDisable);
        }
        else{
            // select exam "有"
            click(exameEnable);
            String[] es = exam.split(";");
            for(String e : es){
                // select exam detail
                click(By.xpath(String.format("//ul[@class=\"followingExam_items\"]//input[@value=\"%s\"]", e)));
            }
            if (exam.contains("-2")){
                // input 'click rate'
                input("111", exameClickRate);
            }
            if (exam.contains("-1")){
                // input 'others'
                input("其他", exameOthers);
            }
        }
    }

    protected void selectThrowType(String type){
        Select select = new Select(thorwTypeSelect);
        select.selectByValue(type);
    }

    protected void selectTracker(String tracker)  {
        String[] trackers = tracker.split(";");
        for (String t : trackers){
            String[] ts = t.split("\\.");

            // select parent tracker
            click(By.cssSelector(String.format("div.tracker_item input[value=\"%s\"]", ts[0])));
            sleep(1);

            // select child tracker
            if (!ts[1].equals("")){
                click(By.cssSelector(String.format("div.tracker_item_more_%s div.tracker_item_product div.mcpp-list", ts[0])));
                sleep(1);
                click(By.cssSelector(String.format("div.mcpp-wrapper input[value=\"%s:%s\"]", ts[0],ts[1])));
                sleep(1);
            }

            // select tracker position
            click(By.cssSelector(String.format("div.tracker_item_more_%s div.tracker_item_position div.mcpp-list", ts[0])));
            sleep(1);
            click(By.cssSelector(String.format("div.mcpp-wrapper input[value=\"%s:%s\"]", ts[0], ts[2])));
            click(By.cssSelector(String.format("div.tracker_item_more_%s div.tracker_item_position b", ts[0])));

        }
    }


    protected void switchMode(String mode){
        if (mode.equals("下单")){
            mode= "mode_select";
        }
        else if(mode.equals("查询")){
            mode= "mode_view";
        }

        click(By.xpath(String.format("//label[@for=\"%s\"]", mode)));


    }


    protected void selectSchedule(String sche){
        click(By.xpath("//label[@for=\"mode_select\"]"));
        sleep(1);
        for(String s: sche.split(";")){
            click(By.cssSelector(String.format("tbody.ui-selectable tr td[data-index=\"%s\"]", s)));
        }
    }

    protected void selectOrder(String order){
        Select select = new Select(findElement(By.cssSelector("select.campaign_list")));
        select.selectByVisibleText(order);
    }

    protected void submit(String submit){
        if (submit.equals("加入")){
            submit= "createNewBtn";
        }
        else if(submit.equals("编辑")){
            submit= "editOneBtn";
        }

        click(By.id(submit));

    }

    protected void inputCPM(String cpm){
        input(cpm,cpmInput);
        click(cpmEnter);
    }


    public void query(Map<String, String> args) {
        waitForAjaxLoading();

        if (!args.getOrDefault("type","").equals("")){
            switchChargeType(args.get("type"));
        }
        if (!args.getOrDefault("date","").equals("")){
            selectDate(args.get("date"));
        }
        if (!args.getOrDefault("adr","").equals("")){
            selectAdr(args.get("adr"));
        }
        if (!args.getOrDefault("area","").equals("")){
            selectArea(args.get("area"));
        }
        if (!args.getOrDefault("port","").equals("")){
            selectPort(args.get("port"));
        }
        if (!args.getOrDefault("content","").equals("")){
            selectContent(args.get("content"));
        }
        if (!args.getOrDefault("time","").equals("")){
            selectThrowTime(args.get("time"));
        }
        if (!args.getOrDefault("exam","").equals("")){
            selectExam(args.get("exam"));
        }
        if (!args.getOrDefault("throwtype","").equals("")){
            selectThrowType(args.get("throwtype"));
        }
        if (!args.getOrDefault("tracker","").equals("")){
            selectTracker(args.get("tracker"));
        }
        click(By.cssSelector("button.submitBtn"));
        waitForAjaxLoading();

    }


    public void addOrder(Map<String, String> args){

        if (!args.getOrDefault("schedule","").equals("")){
            selectSchedule(args.get("schedule"));
        }
        if (!args.getOrDefault("order","").equals("")){
            selectOrder(args.get("order"));
        }
        if (!args.getOrDefault("submit","").equals("")){
            submit(args.get("submit"));
        }
        if (!args.getOrDefault("cpm","").equals("")){
            inputCPM(args.get("cpm"));
        }
    }

    private String int2Date(String d){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE,Integer.parseInt(d));
        Date date = now.getTime();
        return sdf.format(date);
    }



}
