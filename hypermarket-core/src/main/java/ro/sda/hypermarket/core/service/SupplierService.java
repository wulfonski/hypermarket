package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Supplier getSupplierById(Long id);

    List<Supplier> getAllSuppliers();

    void deleteSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);
}
