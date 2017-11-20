package com.project;

import com.project.csv.Runner;
import gherkin.lexer.Th;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) throws Throwable {
        //csvRun();
        cucumber.api.cli.Main.run(args,null);
    }


    public static void csvRun() throws Throwable{
        Runner run = new Runner("/Users/tianzhang/IdeaProjects/fucker/src/main/resources",
                "/Users/tianzhang/IdeaProjects/fucker/src/main/console/TC.csv");
        run.run();
    }

}
