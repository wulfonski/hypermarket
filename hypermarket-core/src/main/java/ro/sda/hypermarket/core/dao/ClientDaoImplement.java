package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Supplier;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientDaoImplement implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Client createClient(Client client) {
        sessionFactory.getCurrentSession().save(client);
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        CriteriaQuery<Client> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Client.class);
        criteriaQuery.from(Client.class);
        List<Client> allClients = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return allClients;

    }

    @Override
    public Client getClientById(Long id) {
        return sessionFactory.getCurrentSession().byId(Client.class).getReference(id);
    }

    @Override
    public void deleteClient(Client client) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Client client1 = getClientById(client.getId());
        sessionFactory.getCurrentSession().delete(client1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }

    @Override
    public void updateClient(Client client) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Client client1 = getClientById(client.getId());
        sessionFactory.getCurrentSession().merge(client1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
