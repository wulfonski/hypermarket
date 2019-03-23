import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional

public class ClientDaoTest {

    @Autowired
    private ClientDao clientDao;

    @Test
    public void testCreate() {
        Client client = new Client();
        client.setName("Andrei");
        clientDao.createClient(client);

    }

    @Test
    public void testGetAllClients() {
        Client client = new Client();
        client.setName("Madalina Georgiana");
        clientDao.createClient(client);
        Client client1 = new Client();
        client1.setName("Mardare Cristina");
        clientDao.createClient(client1);
        List<Client> clients = clientDao.getAllClients();
        Assert.assertEquals(3, clients.size());
    }

    @Test
    public void testGetClientById() {
        Client client = clientDao.getClientById(1L);
        Long clientId = client.getId();
        String clientName = client.getName();
        Assert.assertEquals("Andrei", clientName);
        Assert.assertEquals(new Long(1), clientId);
    }

    @Test
    public void testDeleteClient() {
        List<Client> allClients = clientDao.getAllClients();
        int size1 = allClients.size();
        Client client = clientDao.getClientById(1L);
        clientDao.deleteClient(client);
        List<Client> allClients2 = clientDao.getAllClients();
        int size2 = allClients2.size();
        Assert.assertEquals(size1 - 1, size2);
    }

    @Test
    public void testUpdateClientTest() {
        Client client = clientDao.getClientById(2L);
        client.setName("Marius");
        String clientName = client.getName();
        clientDao.updateClient(client);
        Assert.assertEquals("Marius", clientName);
    }

}
