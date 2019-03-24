package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.ProdCategory;
import ro.sda.hypermarket.core.entity.SaleProduct;

import java.util.List;

public interface SaleProductDao {
    SaleProduct createSaleProduct(SaleProduct saleProduct);

//    List<SaleProduct> getAllSaleProducts();
//
//    SaleProduct getSaleProductById(Long id);
//
//    void deleteSaleProduct(SaleProduct saleProduct);
//
//    void updateSaleProduct(SaleProduct saleProduct);
}
