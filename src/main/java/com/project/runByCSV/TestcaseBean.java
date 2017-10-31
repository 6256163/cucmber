package com.project.runByCSV;

import com.opencsv.bean.CsvBindByName;


public class TestcaseBean {

    @CsvBindByName(column = "TESTCASE")
    protected String TESTCASE;

    @CsvBindByName(column = "ACTION")
    protected String ACTION;

    @CsvBindByName(column = "ACTIONITEMS")
    protected String ACTIONITEMS;

    @CsvBindByName(column = "EXPECT",locale = "")
    protected String EXPECT;

    @CsvBindByName(column = "EXPECTITEMS")
    protected String EXPECTITEMS;

    @CsvBindByName(column = "EXPECTVALUE")
    protected String EXPECTVALUE;


    // Getters and setters go here.
}