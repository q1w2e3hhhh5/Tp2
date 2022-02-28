import model.Employee;
import persistance.ClientDaoJpa;
import persistance.EmployeeDaoJpa;
import service.AdminService;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        //admin service creates an employee
        AdminService adminService = new AdminService(new EmployeeDaoJpa());
        EmployeeService employeeService = new EmployeeService(new ClientDaoJpa());

        adminService.createEmployee("James", "Parker", "Cashier");
        adminService.createEmployee("Peter", "Parker", "Cashier");
        adminService.createEmployee("Dr.Steven", "Strange", "Cashier");


        employeeService.createClient("Tony", "Stark");
        employeeService.createClient("Steve", "Rogers");
        employeeService.createClient("Thor", "Son of Odin");

        System.out.println(adminService.findEmployeeByRole("Cashier"));
        System.out.println(employeeService.findAllClients());

    }
}
