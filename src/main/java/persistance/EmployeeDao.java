package persistance;

import model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);

    List<Employee> findByRole(String role);

}
