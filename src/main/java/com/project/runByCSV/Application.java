package com.project.runByCSV;

import java.io.*;

public class Application {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Runner run = new Runner("/Users/tianzhang/IdeaProjects/fucker/src/main/resources",
                "/Users/tianzhang/IdeaProjects/fucker/src/main/console/TC.csv");
        run.run();
    }

}
