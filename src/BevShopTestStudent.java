import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:test cases for the BevShop class.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class BevShopTestStudent {
    private BevShop shop;

    @Before
    public void setUp() {
        shop = new BevShop();
    }

    @Test
    public void testStartNewOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Elias", 25);
        assertNotNull(shop.getCurrentOrder());
        assertEquals("Elias", shop.getCurrentOrder().getCustomer().getName());
        assertEquals(25, shop.getCurrentOrder().getCustomer().getAge());
        assertEquals(Day.MONDAY, shop.getCurrentOrder().getOrderDay());
    }

    @Test
    public void testProcessAlcoholOrder() {
        shop.startNewOrder(10, Day.FRIDAY, "Alazar", 30);
        shop.processAlcoholOrder("Wine", Size.SMALL);
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertEquals(Type.ALCOHOL, shop.getCurrentOrder().getBeverage(0).getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessAlcoholOrderUnderage() {
        shop.startNewOrder(10, Day.FRIDAY, "Kb", 18);
        shop.processAlcoholOrder("Beer", Size.SMALL); 
    }

    @Test
    public void testProcessSmoothieOrder() {
        shop.startNewOrder(12, Day.SATURDAY, "Mary", 35);
        shop.processSmoothieOrder("Berry Blast", Size.MEDIUM, 3, true);
        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertEquals(Type.SMOOTHIE, shop.getCurrentOrder().getBeverage(0).getType());
    }
}
