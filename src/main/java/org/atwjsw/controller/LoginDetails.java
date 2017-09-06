package org.atwjsw.controller;

import java.util.Date;

/**
 * Created by wenda on 9/1/2017.
 */
public class LoginDetails {
    private String user;
    private Date loginTime;

    public LoginDetails(String user, Date loginTime) {
        this.user = user;
        this.loginTime = loginTime;
    }

    public String getUser() {
        return user;
    }

    public Date getLoginTime() {
        return loginTime;
    }
}