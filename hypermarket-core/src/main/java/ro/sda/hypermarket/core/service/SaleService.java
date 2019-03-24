package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Sale;

import java.util.List;

public interface SaleService {


    Sale createSale(Sale sale, boolean useHibernate);

    List<Sale> getAllSales(boolean useHibernate);

    Sale getSaleById(Long id, boolean useHibernate);

    void deleteSale(Sale sale, boolean useHibernate);

    void updateSale(Sale sale, boolean useHibernate);
}
