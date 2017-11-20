package com.project.csv;

import com.opencsv.bean.CsvBindByName;

public class ConsoleBean {
    @CsvBindByName(column = "TESTCASE", required = true)
    protected String TESTCASE;

    @CsvBindByName(column = "NODE")
    protected String NODE;

    @CsvBindByName(column = "BROWSER")
    protected String BROWSER;

    @CsvBindByName(column = "IS_ACTIVE")
    protected Boolean IS_ACTIVE;

    // Getters and setters go here.
}
