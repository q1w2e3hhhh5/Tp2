package persistance;

import model.Client;
import model.Employee;

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
}
