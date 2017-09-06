package org.atwjsw.controller;

import org.atwjsw.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenda on 9/1/2017.
 */
@Controller
public class HRController {
    private Map<Integer, Employee> database = new HashMap<Integer, Employee>();
    public HRController() {
        loadDummyData();
    }
    private void loadDummyData() {
        Employee john = new Employee();
        john.setId(1);
        john.setName("John Doe");
        john.setSalary(100.00);
        database.put(1, john);
        Employee karen = new Employee();
        karen.setId(2);
        karen.setName("Karen Cushing");
        karen.setSalary(500.00);
        database.put(2, karen);
    }
    @RequestMapping(value = "/employees/{id}", method= RequestMethod.GET)
    public @ResponseBody Employee retrieve(@PathVariable int id) {
        System.out.println("in /employees/{id}");
        return database.get(id);
    }
    @RequestMapping(value = "/employees", method=RequestMethod.GET)
    public @ResponseBody List<Employee> retrieveAll() {
        return new ArrayList<Employee>(database.values());
    }
}
