package ca.cal;

import ca.cal.persistance.*;
import ca.cal.service.*;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminService(new EmployeeDaoJpa());
        EmployeeService employeeService = new EmployeeService(new ClientDaoJpa(), new BookDaoJpa(), new DvdDapJpa(), new CdDaoJpa(), new DocumentDaoJpa());
        ClientService clientService = new ClientService(new DocumentDaoJpa(), new BorrowDaoJpa());

        adminService.createEmployee("James", "Parker", "Cashier");
        adminService.createEmployee("Peter", "Parker", "Cashier");
        adminService.createEmployee("Dr.Steven", "Strange", "Cashier");

        employeeService.createClient("Tony", "Stark");
        employeeService.createClient("Steve", "Rogers");
        employeeService.createClient("Thor", "Son of Odin");


        employeeService.createBook("Marvel", 189, "comic", "Stan lee", "fiction,adventure,action", "Marvel", 2001);
        employeeService.createBook("DC", 67, "Novel", "Clark Kent", "fiction,Fantasy,Boring", "Batman", 2000);
        employeeService.createBook("JOJO bizarre adventure", 89, "Manga", "Stan lee", "Japanese,adventure,Comedy", "Marvel", 2001);
        employeeService.createBook("cuicui bizarre life", 19, "Dictionary", "Bruce Lee", "fiction,action", "Someone", 2001);
        employeeService.createBook("Adventure time", 10, "Comic", "Finn", "Kids", "Jake", 2001);

        employeeService.createDvd("Kung fu panda", 2002, "Salah", "disney?", "family", 68);
        employeeService.createCd("Billie Jeans", 2002, "MJ", "MJ", "Good", 28);


        System.out.println(employeeService.findAllBooks());
        System.out.println(employeeService.findBooksByTitle("d"));
        System.out.println(employeeService.findBookByAuthor("Stan lee"));
        System.out.println(employeeService.findBooksByType("FICTION"));
        System.out.println(employeeService.findBookByYear(2000));


        System.out.println(employeeService.findDocumentById(7));
        System.out.println( employeeService.findClientById(4));
        clientService.createBorrow(employeeService.findClientById(4),(employeeService.findDocumentById(7)));
        clientService.createBorrow(employeeService.findClientById(4),(employeeService.findDocumentById(8)));
        clientService.createBorrow(employeeService.findClientById(4),(employeeService.findDocumentById(9)));
        clientService.createBorrow(employeeService.findClientById(4),(employeeService.findDocumentById(10)));
        clientService.createBorrow(employeeService.findClientById(5),(employeeService.findDocumentById(13)));
        clientService.createBorrow(employeeService.findClientById(5),(employeeService.findDocumentById(12)));
        clientService.createBorrow(employeeService.findClientById(6),(employeeService.findDocumentById(11)));

        System.out.println(employeeService.findAllDvds());
        System.out.println(employeeService.findAllCds());

        System.out.println(employeeService.findAllDocuments());

        System.out.println(adminService.findEmployeeByRole("Cashier"));
        System.out.println(employeeService.findAllClients());

    }
}
