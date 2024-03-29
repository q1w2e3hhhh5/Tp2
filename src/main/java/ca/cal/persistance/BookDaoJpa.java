package ca.cal.persistance;

import ca.cal.model.Book;
import ca.cal.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDaoJpa implements BookDao {

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
    public List<Document> findAllBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Book" +"%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }

    @Override
    public List<Document> findBooksByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch " +
                        "AND LOWER(b.title) like :titleToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Book" +"%");
        query.setParameter("titleToSearch", "%" + title.toLowerCase() +"%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }

    @Override
    public List<Document> findBookByAuthor(String author) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch " +
                "AND LOWER(b.author) like :authorToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Book" +"%");
        query.setParameter("authorToSearch", "%" + author.toLowerCase() +"%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }

    @Override
    public List<Document> findBooksByYear(int year) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch " +
                "AND b.publicationYear = :yearToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Book" +"%");
        query.setParameter("yearToSearch",  year);
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }

    @Override
    public List<Document> findBooksByType(String type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch " +
                "AND LOWER(b.type) like :genreToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Book" +"%");
        query.setParameter("genreToSearch", "%" + type.toLowerCase() +"%");
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }
}
