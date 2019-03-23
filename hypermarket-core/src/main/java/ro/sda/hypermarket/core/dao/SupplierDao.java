package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierDao {

    Supplier createSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long id);

    void deleteSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);


}
