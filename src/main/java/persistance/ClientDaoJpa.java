package persistance;

import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
