package ro.sda.hypermarket.core.repository;

import ro.sda.hypermarket.core.base.EntityRepository;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Supplier;

public interface ClientRepository extends EntityRepository<Client> {

    public Client findByName(String name);
}
