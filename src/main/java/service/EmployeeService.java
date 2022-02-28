package service;

import model.Client;
import persistance.ClientDao;

import java.util.List;

public class EmployeeService {
    private ClientDao clientDao;


    public EmployeeService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void createClient(String firstName, String lastName) {
        Client client = Client.builder().firstName(firstName).lastName(lastName).build();
        clientDao.save(client);
    }

    public List<Client> findAllClients() {
        return clientDao.findAllClients();
    }
}
