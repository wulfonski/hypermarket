package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Product;
import ro.sda.hypermarket.core.entity.Sale;

import java.util.List;

public interface SaleDao {

    Sale createSale(Sale sale);

    List<Sale> getAllSales();

    Sale getSaleById(Long id);

    void deleteSale(Sale sale);

    void updateSale(Sale sale);
}
