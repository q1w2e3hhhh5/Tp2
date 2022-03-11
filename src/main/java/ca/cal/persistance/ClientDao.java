package ca.cal.persistance;

import ca.cal.model.Client;

import java.util.List;

public interface ClientDao {
    void save(Client client);

    List<Client> findAllClients();

    Client findClientById(long i);
}
