package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierDao {

    public Supplier createSupplier(Supplier supplier);
    public List<Supplier> getAllSuppliers();
//    public Supplier getSupplier(Long id);
//    public void deleteSupplier(Supplier supplier);


}
