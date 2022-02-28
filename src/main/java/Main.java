import model.Employee;
import persistance.EmployeeDaoJpa;
import service.AdminService;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        //admin service creates an employee
        AdminService adminService = new AdminService(new EmployeeDaoJpa());
        adminService.createEmployee("James","Parker","Cashier");
        adminService.createEmployee("Peter","Parker","Cashier");
        adminService.createEmployee("Dr.Steven","Strange","Cashier");

        EmployeeService employeeService = new EmployeeService();
        employeeService.createClient("Tony","Stark");

        System.out.println(adminService.findEmployeeByRole("Cashier"));

    }
}
