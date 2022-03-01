package persistance;

import model.Employee;

import javax.persistence.*;
import java.util.List;

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

    @Override
    public List<Employee> findByRole(String role) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Employee> query = em.createQuery("select p from Employee p where p.role like :nameToSearch", Employee.class);
        query.setParameter("nameToSearch", "%" + role +"%");
        final List<Employee> employees = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return employees;
    }

}
