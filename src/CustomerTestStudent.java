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
public class CustomerTestStudent {
    private Customer customer;
    private Customer copiedCustomer;

    @Before
    public void setUp() {
        customer = new Customer("Tony", 28);
        copiedCustomer = new Customer(customer);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Tony", customer.getName());
        assertEquals(28, customer.getAge());
        customer.setName("Mareska");
        customer.setAge(34);
        assertEquals("Mareska", customer.getName());
        assertEquals(34, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals("Tony", copiedCustomer.getName());
        assertEquals(28, copiedCustomer.getAge());
        customer.setName("John");
        customer.setAge(40);
        assertEquals("Tony", copiedCustomer.getName());
        assertEquals(28, copiedCustomer.getAge());
    }

    @Test
    public void testToString() {
        assertEquals("Customer Name: Tony, Age: 28", customer.toString());
    }
}
