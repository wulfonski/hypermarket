package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ProdCategoryDao;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.ProdCategory;
import ro.sda.hypermarket.core.repository.ProdCategoryRepository;

import java.util.List;

@Service("prodCategoryService")
@Transactional(rollbackFor = Exception.class)
public class ProdCategoryServiceImpl implements ProdCategoryService {
    @Autowired
    private ProdCategoryDao prodCategoryDao;

    @Autowired
    private ProdCategoryRepository prodCategoryRepository;

    @Override
    @Transactional
    public ProdCategory createProdCategory(ProdCategory prodCategory, boolean useHibernate) {
        if (useHibernate) {
            return prodCategoryDao.createProdCategory(prodCategory);
        }
        return prodCategoryRepository.save(prodCategory);
    }
    @Override
    public List<ProdCategory> getAllProdCategories(boolean useHibernate) {
        if (useHibernate) {
            return prodCategoryDao.getAllProdCategories();
        }
        return prodCategoryRepository.findAll();
    }

    @Override
    public ProdCategory getProdCategoryById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return prodCategoryDao.getProdCategoryById(id);
        }
        return prodCategoryRepository.findById(id);
    }

    @Override
    public void deleteProdCategory(ProdCategory prodCategory, boolean useHibernate) {
        if (useHibernate) {
            prodCategoryDao.deleteProdCategory(prodCategory);
        }
        prodCategoryRepository.delete(prodCategory);
    }
    @Override
    public void updateProdCategory(ProdCategory prodCategory, boolean useHibernate) {
        if (useHibernate) {
            prodCategoryDao.updateProdCategory(prodCategory);
        }
        prodCategoryRepository.save(prodCategory);
    }

}
