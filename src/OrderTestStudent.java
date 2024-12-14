import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:test cases for the Order class.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class OrderTestStudent {
    private Order testOrder;

    @Before
    public void setUp() {
        testOrder = new Order(10, Day.FRIDAY, new Customer("Michael", 25));
    }

    @Test
    public void testAddNewBeverage() {
        
        testOrder.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, testOrder.getTotalItems());
        assertEquals(Type.COFFEE, testOrder.getBeverage(0).getType());

        
        testOrder.addNewBeverage("Wine", Size.LARGE);
        assertEquals(2, testOrder.getTotalItems());
        assertEquals(Type.ALCOHOL, testOrder.getBeverage(1).getType());
    }

    @Test
    public void testCalcOrderTotal() {
        testOrder.addNewBeverage("Espresso", Size.SMALL, false, false); 
        testOrder.addNewBeverage("Wine", Size.SMALL); 
        assertEquals(4.0, testOrder.calcOrderTotal(), 0.01);
    }


    @Test
    public void testGetOrderDetails() {
        assertEquals(10, testOrder.getOrderTime());
        assertEquals(Day.FRIDAY, testOrder.getOrderDay());
        assertEquals("Michael", testOrder.getCustomer().getName());
    }
}
