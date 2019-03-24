package ro.sda.hypermarket.core.repository;

import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.ProdCategory;

public interface ProdCategoryRepository extends EntityRepository<ProdCategory> {

    public ProdCategory findByName(String name);
}
