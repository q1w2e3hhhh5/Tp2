package ca.cal.persistance;

import ca.cal.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDaoJpa implements ClientDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");

    @Override
    public void save(Client client) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(client);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Client> findAllClients() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
        final List<Client> clients = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return clients;
    }

    @Override
    public Client findClientById(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Client> query = em.createQuery("select c from Client c where c.id = :clientToSearch", Client.class);
        query.setParameter("clientToSearch",  id );
        final Client client = query.getSingleResult();

        em.getTransaction().commit();
        em.close();

        return client;
    }
}
