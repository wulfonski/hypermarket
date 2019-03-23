package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.ProdCategory;

import java.util.List;

public interface ProdCategoryDao {
    ProdCategory createProdCategory(ProdCategory prodCategory);

    List<ProdCategory> getAllProdCategories();

    ProdCategory getProdCategoryById(Long id);

    void deleteProdCategory(ProdCategory prodCategory);

    void updateProdCategory(ProdCategory prodCategory);
}
