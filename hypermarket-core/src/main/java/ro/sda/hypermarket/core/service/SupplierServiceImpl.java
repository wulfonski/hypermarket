package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

@Service("supplierService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    @Transactional
    public Supplier createSupplier(Supplier supplier) {
            return supplierDao.createSupplier(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierDao.getSupplierById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
            return supplierDao.getAllSuppliers();
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        supplierDao.deleteSupplier(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDao.updateSupplier(supplier);
    }

}
