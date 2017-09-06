package org.atwjsw.springtest.testutils;

/**
 * Created by wenda on 9/5/2017.
 */
public class Secret {
    private String secret;
    public void initiate(String key) {
        this.secret = key.replaceAll("a", "z").replaceAll("i", "k");
    }
}
