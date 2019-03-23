package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentDaoImplement implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Department createDepartment(Department department) {
        sessionFactory.getCurrentSession().save(department);
        return department;

    }

    @Override
    public List<Department> getAllDepartments() {
        CriteriaQuery<Department> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Department.class);
        criteriaQuery.from(Department.class);
        List<Department> allDepartments = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allDepartments;

    }
    @Override
    public Department getDepartmentById(Long id) {
        return sessionFactory.getCurrentSession().byId(Department.class).getReference(id);
    }

    @Override
    public void deleteDepartment(Department department) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department department1 = getDepartmentById(department.getId());
        sessionFactory.getCurrentSession().delete(department1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateDepartment(Department department) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department department1 = getDepartmentById(department.getId());
        sessionFactory.getCurrentSession().merge(department1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
