import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;
    Sell sell1;
    @BeforeEach
    void setUp(){
        company = new Company();
        company.registerClient(new User("José Manuel", "91111111", "zemanel@yahoo.com"));
        company.registerClient(new User("António", "92222222","chico@hotmail.com"));
        company.registerSeller(new User("Fernando", "9666666","fefe@remax.pt"));
        company.registerSeller(new User("Rodrigo","97777777","roro@emax.pt"));
    }

    @Test
    public void testConstructor(){
        assertNotNull(company);
    }
    @Test
    public void testRegisterClient(){
        company.registerClient(new User("José Manuel", "91111111", "zemanel@yahoo.com"));
        assertEquals(3,company.getClients().size());
    }

    @Test
    public void testRegisterCLients(){
        company.registerClient(new User("José Manuel", "91111112", "zemanel@yahoo.com"));
        company.registerClient(new User("José Manuel", "91111113", "zemanel@yahoo.com"));
        assertEquals(4,company.getClients().size());
    }
    @Test
    public void testRegisterClientDuplicate(){
        company.registerClient(new User("José Manuel", "91111111", "zemanel@yahoo.com"));
        assertEquals(2,company.getClients().size());
    }
    @Test
    @BeforeEach
    public void testCreateSell(){
        Property property1;
        property1 = new Property("T3 Monte Belo", 150000.0);
        sell1 = new Sell(company.getClients().get(0),company.getSellers().get(0),property1);
        assertNotNull(sell1);
    }
    @Test
    public void testCalculateSellsOfYear(){
        company.registerSell(sell1);
        assertEquals(1,company.calculateSellsOfTheYear(2024));
    }
    @Test
    public void testFindSellerOfYear(){
        company.registerSell(sell1);
        assertEquals("Fernando",company.findSellerOfTheYear(2024));
    }
}