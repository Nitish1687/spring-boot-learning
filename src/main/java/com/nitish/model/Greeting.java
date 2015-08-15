package com.nitish.model;

import java.util.Date;

/**
 * Created by nsm1211 on 15-08-2015.
 */
public class Greeting {

    private String name;
    private Date date;

    public Greeting(String name, Date date) {
        this.name = name;
        this.date= date;
    }

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
