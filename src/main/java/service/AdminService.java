package service;

import model.Employee;
import persistance.EmployeeDao;

public class AdminService {
    private EmployeeDao employeeDao;

    public AdminService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void createEmployee(String firstName, String lastName, String role) {
        Employee employee = Employee.builder().firstName(firstName).lastName(lastName).role(role).build();
        employeeDao.save(employee);
    }
}
