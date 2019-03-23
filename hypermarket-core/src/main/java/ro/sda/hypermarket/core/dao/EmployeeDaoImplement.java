package ro.sda.hypermarket.core.dao;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Employee;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional

public class EmployeeDaoImplement implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        CriteriaQuery<Employee> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Employee.class);
        criteriaQuery.from(Employee.class);
        List<Employee> allEmployees = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allEmployees;

    }

    @Override
    public Employee getEmployeeById(Long id) {
        return sessionFactory.getCurrentSession().byId(Employee.class).getReference(id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Employee employee1 = getEmployeeById(employee.getId());
        sessionFactory.getCurrentSession().delete(employee1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Employee employee1 = getEmployeeById(employee.getId());
        sessionFactory.getCurrentSession().merge(employee1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

}
