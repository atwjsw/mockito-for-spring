package org.atwjsw.cache;

import java.io.Serializable;

/**
 * Created by wenda on 9/3/2017.
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String firstName, lastName, empId;
    public Employee(String empId, String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmpId() {
        return empId;
    }
}
