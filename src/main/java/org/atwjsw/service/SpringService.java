package org.atwjsw.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wenda on 9/3/2017.
 */
@RestController
@RequestMapping("/hello")
public class SpringService {
    private Set<String> names = new HashSet<String>();

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String displayMsg(@PathVariable String name) {
        String result = "Welcome " + name;
        names.add(name);
        return result;
    }

    @RequestMapping(value = "/all/", method = RequestMethod.GET)
    public String anotherMsg() {
        StringBuilder result = new StringBuilder("We greeted so far ");
        for(String name:names){
            result.append(name).append(", ");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}