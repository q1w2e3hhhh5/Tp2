import persistance.EmployeeDaoJpa;
import service.AdminService;

public class Main {
    public static void main(String[] args) {
        //admin service creates an employee
        AdminService adminService = new AdminService(new EmployeeDaoJpa());
        adminService.createEmployee("firstName","lastName","Role");

    }
}
