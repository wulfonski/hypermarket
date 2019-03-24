package ro.sda.hypermarket.core.repository;

import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Sale;

public interface SaleRepository extends EntityRepository<Sale> {

    public Sale findByNumber(Integer number);
}

