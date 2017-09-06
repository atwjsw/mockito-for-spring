package org.atwjsw.cache;

import org.atwjsw.cache.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wenda on 9/3/2017.
 */
@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new ConcurrentHashMap<String, Employee>();
    @PostConstruct
    public void init() {
        saveEmployee (new Employee("101", "John", "Doe"));
        saveEmployee (new Employee("102", "Jack", "Russell"));
    }
    @Cacheable("employee")
    public Employee getEmployee(final String employeeId) {
        System.out.println(String.format("Loading a employee with id of : %s", employeeId));
        return employees.get(employeeId);
    }
    @CacheEvict(value = "employee", key = "#emp.empId")
    public void saveEmployee(final Employee emp) {
        System.out.println(String.format("Saving a emp with id of : %s", emp.getEmpId()));
        employees.put(emp.getEmpId(), emp);
    }
}
