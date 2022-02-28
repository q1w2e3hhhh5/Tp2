package persistance;

import model.Book;
import model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Book> findAllBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Book> query = em.createQuery("select b from Document b", Book.class);
        final List<Book> books = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return books;

    }
}
