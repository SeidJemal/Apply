package application;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: JUnit test that checks the Town class’s equality, comparison, and string output.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Town_STUDENT_Test {

    @Test
    public void testCompareTo() {
        Town t1 = new Town("A");
        Town t2 = new Town("B");
        assertTrue(t1.compareTo(t2) < 0);
    }

    @Test
    public void testEquals() {
        Town t1 = new Town("Germantown");
        Town t2 = new Town("Germantown");
        assertTrue(t1.equals(t2));
    }

    @Test
    public void testHashCode() {
        Town t1 = new Town("Rockville");
        Town t2 = new Town("rockville");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void testToString() {
        Town t = new Town("Silver Spring");
        assertEquals("Silver Spring", t.toString());
    }
}
