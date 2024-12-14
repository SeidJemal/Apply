import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:test cases for the Alcohol class.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class AlcoholTestStudent {
    private Alcohol weekendAlc;
    private Alcohol weekdayAlc;

    @Before
    public void setUp() {
        weekendAlc = new Alcohol("Wine", Size.LARGE, true);
        weekdayAlc = new Alcohol("Beer", Size.MEDIUM, false);
    }

    @Test
    public void testCalcPrice() {
        
        assertEquals(3.6, weekendAlc.calcPrice(), 0.01); 

        
        assertEquals(2.5, weekdayAlc.calcPrice(), 0.01);
    }

    @Test
    public void testIsWeekend() {
        assertTrue(weekendAlc.isWeekend());
        assertFalse(weekdayAlc.isWeekend());
    }

    @Test
    public void testToString() {
        String expectedWeekend = "Wine, LARGE, Weekend Offer: true, Price: $3.6";
        String expectedWeekday = "Beer, MEDIUM, Weekend Offer: false, Price: $2.5";

        assertTrue(weekendAlc.toString().contains(expectedWeekend));
        assertTrue(weekdayAlc.toString().contains(expectedWeekday));
    }
}
