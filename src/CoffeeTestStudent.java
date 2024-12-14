import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:test cases for the Coffee class.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class CoffeeTestStudent {
    private Coffee coffeeWExtras;
    private Coffee coffeeWoExtras;

    @Before
    public void setUp() {
        coffeeWExtras = new Coffee("Latte", Size.MEDIUM, true, true);
        coffeeWoExtras = new Coffee("Espresso", Size.SMALL, false, false);
    }

    @Test
    public void testCalcPrice() {
     
        assertEquals(3.5, coffeeWExtras.calcPrice(), 0.01);

        assertEquals(2.0, coffeeWoExtras.calcPrice(), 0.01);
    }

    @Test
    public void testGetExtras() {
        assertTrue(coffeeWExtras.getExtraShot());
        assertTrue(coffeeWExtras.getExtraSyrup());

        assertFalse(coffeeWoExtras.getExtraShot());
        assertFalse(coffeeWoExtras.getExtraSyrup());
    }

    @Test
    public void testEquals() {
        Coffee anotherCoffeeWithExtras = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee differentCoffee = new Coffee("Mocha", Size.LARGE, false, false);

        assertTrue(coffeeWExtras.equals(anotherCoffeeWithExtras));
        assertFalse(coffeeWExtras.equals(differentCoffee));
    }
}
