package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<Supplier> getAllSuppliers(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM ro.sda.hypermarket.core.entity.Supplier");
        List<Supplier> allSuppliers = query.getResultList();
        return allSuppliers;
        

    }


}
