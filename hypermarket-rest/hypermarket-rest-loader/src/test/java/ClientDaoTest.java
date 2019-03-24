import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.service.ClientService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional

public class ClientDaoTest {

    @Autowired
    private ClientService clientService;

    @Test
    @Rollback(false)
    public void testCreateClient() {
        Client client = new Client();
        client.setName("Andreea SRL");
        clientService.createClient(client, false);

    }

    @Test
    @Rollback(false)
    @Transactional
    public void testGetAllClients() {
        Client client = new Client();
        client.setName("Madalina Georgiana");
        clientService.createClient(client, false);
        Client client1 = new Client();
        client1.setName("Mardare Cristina");
        clientService.createClient(client1, false);
        List<Client> clients = clientService.getAllClients(false);
        Assert.assertEquals(9, clients.size());
    }

    @Test
    public void testGetClientById() {
        Client client = clientService.getClientById(2L, false);
        Long clientId = client.getId();
        String clientName = client.getName();
        Assert.assertEquals("Marius", clientName);
        Assert.assertEquals(new Long(2), clientId);
    }

    @Test
    @Rollback(false)
    public void testDeleteClient() {
        List<Client> allClients = clientService.getAllClients(false);
        int size1 = allClients.size();
        Client client = clientService.getClientById(8L,false);
        clientService.deleteClient(client,false);
        List<Client> allClients2 = clientService.getAllClients(false);
        int size2 = allClients2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    @Rollback(false)
    public void testUpdateClient() {
        Client client = clientService.getClientById(10L, false);
        client.setName("Andreea Mart");
        String clientName = client.getName();
        clientService.updateClient(client, false);
        Assert.assertEquals("Andreea Mart", clientName);
    }

}
