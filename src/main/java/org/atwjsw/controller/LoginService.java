package org.atwjsw.controller;

/**
 * Created by wenda on 9/2/2017.
 */
public class LoginService {
    private String userId;
    private String password;

    public boolean isValid() {
        return getPassword().equals(getUserId());
    }

    public LoginService(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String retrieveName() {
        // TODO Auto-generated method stub
        return null;
    }
}
