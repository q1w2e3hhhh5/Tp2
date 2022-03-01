package persistance;

import model.Document;
import model.Dvd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Document> findAllDvds() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Document> query = em.createQuery("select b from Document b where b.documentType like :typeToSearch", Document.class);
        query.setParameter("typeToSearch", "%" + "Dvd" +"%");
        final List<Document> dvds = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return dvds;
    }


}
