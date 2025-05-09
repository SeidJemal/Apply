package application;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: JUnit test that checks the Road class’s equality, contains, and string methods.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Road_STUDENT_Test {

    @Test
    public void testContains() {
        Town a = new Town("A");
        Town b = new Town("B");
        Road r = new Road(a, b, 5, "R1");
        assertTrue(r.contains(a));
        assertTrue(r.contains(b));
    }

    @Test
    public void testEquals() {
        Road r1 = new Road(new Town("c"), new Town("d"), 15, "Road");
        Road r2 = new Road(new Town("d"), new Town("c"), 15, "Road");
        assertTrue(r1.equals(r2));
    }

    @Test
    public void testToString() {
        Road r = new Road(new Town("A"), new Town("B"), 4, "R2");
        assertTrue(r.toString().contains("R2"));
    }
}

