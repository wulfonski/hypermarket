package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Sale;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SaleDaoImplement implements SaleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Sale createSale(Sale sale) {
        sessionFactory.getCurrentSession().save(sale);
        return sale;
    }

    @Override
    public List<Sale> getAllSales() {
        CriteriaQuery<Sale> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Sale.class);
        criteriaQuery.from(Sale.class);
        List<Sale> allSales = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allSales;

    }

    @Override
    public Sale getSaleById(Long id) {
        return sessionFactory.getCurrentSession().byId(Sale.class).getReference(id);
    }

    @Override
    public void deleteSale(Sale sale) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sale sale1 = getSaleById(sale.getId());
        sessionFactory.getCurrentSession().delete(sale1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateSale(Sale sale) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sale sale1 = getSaleById(sale.getId());
        sessionFactory.getCurrentSession().merge(sale1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

}
