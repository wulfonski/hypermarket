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
    public Supplier getSupplierById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return supplierDao.getSupplierById(id);
        }
        return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers(boolean useHibernate) {
        if (useHibernate) {
            return supplierDao.getAllSuppliers();
        }
        return supplierRepository.findAll();
    }

    @Override
    public void deleteSupplier(Supplier supplier, boolean useHibernate) {
        if (useHibernate) {
        supplierDao.deleteSupplier(supplier);
        }
        supplierRepository.delete(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier, boolean useHibernate) {
        if (useHibernate) {
            supplierDao.updateSupplier(supplier);
        }
        supplierRepository.save(supplier);
    }

}
