package persistance;

import model.Cd;
import model.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Document> findAllCds() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Cd" +"%");
        final List<Document> cds = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return cds;
    }


}
