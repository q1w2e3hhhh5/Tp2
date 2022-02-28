package persistance;

import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDaoJpa implements EmployeeDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("library.exe");

    @Override
    public void save(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(employee);

        em.getTransaction().commit();
        em.close();
    }
}
