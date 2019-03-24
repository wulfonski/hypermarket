package ro.sda.hypermarket.core.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SaleDao;
import ro.sda.hypermarket.core.entity.Sale;
import ro.sda.hypermarket.core.repository.SaleRepository;
import java.util.List;

@Service("saleService")
@Transactional(rollbackFor = Exception.class)
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    @Transactional
    public Sale createSale(Sale sale, boolean useHibernate) {
        if (useHibernate) {
            return saleDao.createSale(sale);
        }
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales(boolean useHibernate) {
        if (useHibernate) {
            return saleDao.getAllSales();
        }
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return saleDao.getSaleById(id);
        }
        return saleRepository.findById(id);
    }

    @Override
    public void deleteSale(Sale sale, boolean useHibernate) {
        if (useHibernate) {
            saleDao.deleteSale(sale);
        }
        saleRepository.delete(sale);
    }

    @Override
    public void updateSale(Sale sale, boolean useHibernate) {
        if (useHibernate) {
            saleDao.updateSale(sale);
        }
        saleRepository.save(sale);
    }
}
