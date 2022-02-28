package persistance;

import model.Dvd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DvdDapJpa implements DvdDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");
    @Override
    public void save(Dvd dvd) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(dvd);

        em.getTransaction().commit();
        em.close();
    }
}
