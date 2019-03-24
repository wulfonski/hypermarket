package ro.sda.hypermarket.core.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.repository.ClientRepository;

import java.util.List;

@Service("clientService")
@Transactional(rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService{


    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Client createClient(Client client, boolean useHibernate) {
        if (useHibernate) {
            return clientDao.createClient(client);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id, boolean useHibernate) {
        if (useHibernate) {
            return clientDao.getClientById(id);
        }
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients(boolean useHibernate) {
        if (useHibernate) {
            return clientDao.getAllClients();
        }
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Client client, boolean useHibernate) {
        if (useHibernate) {
            clientDao.deleteClient(client);
        }
        clientRepository.delete(client);
    }

    @Override
    public void updateClient(Client client, boolean useHibernate) {
        if (useHibernate) {
            clientDao.updateClient(client);
        }
        clientRepository.save(client);
    }
}
