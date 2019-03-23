package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Product;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional

public class ProductDaoImplement implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product createProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        CriteriaQuery<Product> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Product.class);
        criteriaQuery.from(Product.class);
        List<Product> allProducts = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allProducts;

    }

    @Override
    public Product getProductById(Long id) {
        return sessionFactory.getCurrentSession().byId(Product.class).getReference(id);
    }

    @Override
    public void deleteProduct(Product product) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Product product1 = getProductById(product.getId());
        sessionFactory.getCurrentSession().delete(product1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateProduct(Product product) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Product product1 = getProductById(product.getId());
        sessionFactory.getCurrentSession().merge(product1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

}
