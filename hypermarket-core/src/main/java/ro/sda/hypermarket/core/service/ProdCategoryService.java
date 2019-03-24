package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.ProdCategory;

import java.util.List;

public interface ProdCategoryService {

    ProdCategory createProdCategory(ProdCategory prodCategory, boolean useHibernate);

    List<ProdCategory> getAllProdCategories(boolean useHibernate);

    ProdCategory getProdCategoryById(Long id, boolean useHibernate);

    void deleteProdCategory(ProdCategory prodCategory, boolean useHibernate);

    void updateProdCategory(ProdCategory prodCategory, boolean useHibernate);
}
