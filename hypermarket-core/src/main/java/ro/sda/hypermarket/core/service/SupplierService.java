package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier, boolean useHibernate);

    List<Supplier> getAllSuppliers(boolean useHibernate);

    Supplier getSupplierById(Long id, boolean useHibernate);

    void deleteSupplier(Supplier supplier, boolean useHibernate);

    void updateSupplier(Supplier supplier, boolean useHibernate);
}
