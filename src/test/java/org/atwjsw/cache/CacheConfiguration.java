package org.atwjsw.cache;

/**
 * Created by wenda on 9/3/2017.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:org/atwjsw/cache/applicationContext.xml")
public class CacheConfiguration {
    @Autowired
    ApplicationContext context;

    @Test
    public void jobTest() throws Exception {
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        long time = System.currentTimeMillis();
        employeeService.getEmployee("101");
        System.out.println("time taken = " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        employeeService.getEmployee("101");
        System.out.println("time taken to read from cache = " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        employeeService.getEmployee("102");
        System.out.println("time taken " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        employeeService.getEmployee("102");
        System.out.println("time taken to read from cache = " + (System.currentTimeMillis() - time));
        employeeService.saveEmployee(new Employee("1000", "Sujoy", "Acharya"));
        time = System.currentTimeMillis();
        employeeService.getEmployee("1000");
        System.out.println("time taken = " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        employeeService.getEmployee("1000");
        System.out.println("time taken to read from cache = " + (System.currentTimeMillis() - time));
    }
}
