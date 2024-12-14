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
public class SmoothieTestStudent {
    private Smoothie smoothieWProtein;
    private Smoothie smoothieWoProtein;

    @Before
    public void setUp() {
        smoothieWProtein = new Smoothie("Banana Strawberry", Size.LARGE, 3, true);
        smoothieWoProtein = new Smoothie("Avocado Pineapple", Size.SMALL, 2, false);
    }

    @Test
    public void testCalcPrice() {
        assertEquals(6.0, smoothieWProtein.calcPrice(), 0.01);
        assertEquals(3.0, smoothieWoProtein.calcPrice(), 0.01);
    }

    @Test
    public void testGetters() {
        assertEquals(3, smoothieWProtein.getNumOfFruits());
        assertTrue(smoothieWProtein.getAddProtein());
        assertEquals(2, smoothieWoProtein.getNumOfFruits());
        assertFalse(smoothieWoProtein.getAddProtein());
    }

    @Test
    public void testToString() {
        assertTrue(smoothieWProtein.toString().contains("Banana Strawberry"));
        assertTrue(smoothieWoProtein.toString().contains("Avocado Pineapple"));
    }

}
