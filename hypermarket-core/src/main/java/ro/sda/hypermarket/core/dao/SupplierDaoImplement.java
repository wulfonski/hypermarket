package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Supplier;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupplierDaoImplement implements SupplierDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        sessionFactory.getCurrentSession().save(supplier);
        return supplier;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        CriteriaQuery<Supplier> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Supplier.class);
        criteriaQuery.from(Supplier.class);
        List<Supplier> allSuppliers = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allSuppliers;

    }

    @Override
    public Supplier getSupplierById(Long id) {
        return sessionFactory.getCurrentSession().byId(Supplier.class).getReference(id);
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier supplier1 = getSupplierById(supplier.getId());
        sessionFactory.getCurrentSession().delete(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier supplier1 = getSupplierById(supplier.getId());
        sessionFactory.getCurrentSession().merge(supplier1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

}
