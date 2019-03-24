package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.repository.SupplierRepository;

import java.util.List;

@Service("supplierService")
@Transactional(rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public Supplier createSupplier(Supplier supplier, boolean useHibernate) {
        if (useHibernate) {
            return supplierDao.createSupplier(supplier);
        }
        return supplierRepository.save(supplier);
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
