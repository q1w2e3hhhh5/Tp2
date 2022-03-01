package persistance;

import model.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DocumentDaoJpa implements DocumentDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");

    @Override
    public List<Document> findAllDocuments() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select d from Document d", Document.class);
        final List<Document> documents = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return documents;
    }
}
