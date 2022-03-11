package ca.cal.service;

import ca.cal.model.Employee;
import ca.cal.persistance.EmployeeDao;

import java.util.List;

public class AdminService {
    private EmployeeDao employeeDao;

    public AdminService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void createEmployee(String firstName, String lastName, String role) {
        Employee employee = Employee.builder().firstName(firstName).lastName(lastName).role(role).build();
        employeeDao.save(employee);
    }

    public List<Employee> findEmployeeByRole(String role) {
        return employeeDao.findByRole(role);
    }

}
