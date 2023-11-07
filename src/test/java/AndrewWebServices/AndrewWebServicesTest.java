package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new InMemoryDatabase();
        recommender = mock(RecSys.class);
        when(recommender.getRecommendation("Scotty")).thenReturn("Animal House");
        promoService = mock(PromoService.class);

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        andrewWebService.sendPromoEmail("admin@andrew.cmu.edu");
        verify(promoService, times(1)).mailTo("admin@andrew.cmu.edu");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like
        // right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        verify(promoService, never()).mailTo("admin@andrew.cmu.edu");
    }
}
