package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client, boolean useHibernate);

    List<Client> getAllClients(boolean useHibernate);

    Client getClientById(Long id, boolean useHibernate);

    void deleteClient(Client client, boolean useHibernate);

    void updateClient(Client client, boolean useHibernate);
}
