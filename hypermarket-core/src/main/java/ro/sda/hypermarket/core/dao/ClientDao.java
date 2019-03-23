package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientDao {

    Client createClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);

    void deleteClient(Client client);

    void updateClient(Client client);
}
