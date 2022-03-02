package persistance;

import model.Borrow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BorrowDaoJpa implements BorrowDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");

    @Override
    public void save(Borrow borrow) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(borrow);

        em.getTransaction().commit();
        em.close();
    }
}
