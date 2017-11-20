package com.project.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;

public class Runner {

    private String tcFolder;
    private String console;
    @Autowired
    private WebDriver driver;
    @Autowired
    private Execution exe;
    public Runner(String tcFolder, String consoleFileDir){
        this.tcFolder=tcFolder;
        this.console=consoleFileDir;
    }
    public void run() throws FileNotFoundException {
        List<ConsoleBean> console = new CsvToBeanBuilder(new FileReader(this.console))
                .withType(ConsoleBean.class).build().parse();
        for(ConsoleBean line: console){
            if (line.IS_ACTIVE){
                String tc_dir = Paths.get(this.tcFolder,line.TESTCASE+".csv").toString();
                List<TestcaseBean> tc = new CsvToBeanBuilder(new FileReader(tc_dir))
                        .withType(TestcaseBean.class).build().parse();
                for (TestcaseBean step: tc){
                    try{
                        exe.action(step.ACTION,step.ACTIONITEMS);
                        exe.expect(step.EXPECT,step.EXPECTITEMS, step.EXPECTVALUE);
                    }
                    catch (Exception e){
                        this.driver.quit();
                        e.printStackTrace();
                        break;
                    }

                }
                this.driver.quit();
            }
        }
    }




}
