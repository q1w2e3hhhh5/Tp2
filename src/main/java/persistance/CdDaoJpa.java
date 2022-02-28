package persistance;

import model.Cd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CdDaoJpa implements CdDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");
    @Override
    public void save(Cd cd) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(cd);

        em.getTransaction().commit();
        em.close();
    }
}
