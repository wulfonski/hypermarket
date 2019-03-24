package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.SaleProduct;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SaleProductDaoImplement implements SaleProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SaleProduct createSaleProduct(SaleProduct saleProduct) {
        sessionFactory.getCurrentSession().save(saleProduct);
        return saleProduct;
    }

//    @Override
//    public List<SaleProduct> getAllSaleProducts() {
//        CriteriaQuery<SaleProduct> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(SaleProduct.class);
//        criteriaQuery.from(SaleProduct.class);
//        List<SaleProduct> allSaleProducts = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
//        return allSaleProducts;
//
//    }
//
//    @Override
//    public SaleProduct getSaleProductById(Long id) {
//        return sessionFactory.getCurrentSession().byId(SaleProduct.class).getReference(id);
//    }
//
//    @Override
//    public void deleteSaleProduct(SaleProduct saleProduct) {
//        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
//        SaleProduct saleProduct1 = getSaleProductById(saleProduct.getId());
//        sessionFactory.getCurrentSession().delete(saleProduct1);
//        sessionFactory.getCurrentSession().flush();
//        tr.commit();
//    }
//    @Override
//    public void updateSaleProduct(SaleProduct saleProduct) {
//        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
//        SaleProduct saleProduct1 = getSaleProductById(saleProduct.getId());
//        sessionFactory.getCurrentSession().merge(saleProduct1);
//        sessionFactory.getCurrentSession().flush();
//        tr.commit();
//    }
}
