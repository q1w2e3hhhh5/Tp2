package persistance;

import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookDaoJpa implements BookDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");

    @Override
    public void save(Book book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(book);

        em.getTransaction().commit();
        em.close();
    }
}
