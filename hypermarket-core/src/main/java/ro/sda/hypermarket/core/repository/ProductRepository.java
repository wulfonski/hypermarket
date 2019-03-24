package ro.sda.hypermarket.core.repository;
import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.entity.Product;

public interface ProductRepository extends EntityRepository<Product> {
    public Employee findByName(String name);
}
