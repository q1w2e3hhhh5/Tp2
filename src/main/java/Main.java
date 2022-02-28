import model.Employee;
import persistance.*;
import service.AdminService;
import service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        //admin service creates an employee
        AdminService adminService = new AdminService(new EmployeeDaoJpa());
        EmployeeService employeeService = new EmployeeService(new ClientDaoJpa(), new BookDaoJpa(), new DvdDapJpa(),new CdDaoJpa());

        adminService.createEmployee("James", "Parker", "Cashier");
        adminService.createEmployee("Peter", "Parker", "Cashier");
        adminService.createEmployee("Dr.Steven", "Strange", "Cashier");


        employeeService.createClient("Tony", "Stark");
        employeeService.createClient("Steve", "Rogers");
        employeeService.createClient("Thor", "Son of Odin");


        employeeService.createBook("Marvel", 189, "comic", "Stan lee", "fiction,adventure,action",
                "Marvel", 2001);
        //System.out.println(employeeService.findAllBooks());//todo fix : must print full info


        employeeService.createDvd("title", 2002, "author", "editor", "genre", 68);


        employeeService.createCd("title", 2002, "author", "editor", "genre", 28);


        //System.out.println(employeeService.findAllDocuments());
/*

        System.out.println(adminService.findEmployeeByRole("Cashier"));
        System.out.println(employeeService.findAllClients());*/

    }
}
