package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.ProdCategory;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProdCategoryDaoImplement implements ProdCategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProdCategory createProdCategory(ProdCategory prodCategory) {
        sessionFactory.getCurrentSession().save(prodCategory);
        return prodCategory;

    }

    @Override
    public List<ProdCategory> getAllProdCategories() {
        CriteriaQuery<ProdCategory> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(ProdCategory.class);
        criteriaQuery.from(ProdCategory.class);
        List<ProdCategory> allProdCategories = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allProdCategories;

    }
    @Override
    public ProdCategory getProdCategoryById(Long id) {
        return sessionFactory.getCurrentSession().byId(ProdCategory.class).getReference(id);
    }

    @Override
    public void deleteProdCategory(ProdCategory prodCategory) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        ProdCategory prodCategory1 = getProdCategoryById(prodCategory.getId());
        sessionFactory.getCurrentSession().delete(prodCategory1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateProdCategory(ProdCategory prodCategory) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        ProdCategory prodCategory1 = getProdCategoryById(prodCategory.getId());
        sessionFactory.getCurrentSession().merge(prodCategory);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
