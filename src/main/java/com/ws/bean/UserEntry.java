package com.ws.bean;

/**
 * Created by gl on 2019/4/1.
 */
public class UserEntry {

    private String name;

    private String pass;


    public UserEntry(){}

    public UserEntry(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
