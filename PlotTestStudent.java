package application;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 4
 * Instructor: Professor Gary Thai
 * Description: JUnit test class for Plot.
 * Due: 11/08/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class PlotTestStudent {
    private Plot plot1, plot2, plot3;

    @Before
    public void setUp() throws Exception {
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(8, 8, 2, 2);  // Non-overlapping plot
        plot3 = new Plot(1, 1, 3, 3);  // overlapping plot
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = null;
    }

    // Test Overlapping Cases
    @Test
    public void testOverlaps() {
        assertTrue("plot5 should overlap plot1", plot1.overlaps(plot3)); 
        assertFalse("plot2 should not overlap plot1", plot1.overlaps(plot2)); // plot2 does not overlap plot1
        
    }

 // Test Constructors
    @Test
    public void testDefaultConstructor() {
        Plot defaultPlot = new Plot();
        assertEquals("Default X should be 0", 0, defaultPlot.getX());
        assertEquals("Default Y should be 0", 0, defaultPlot.getY());
        assertEquals("Default Width should be 1", 1, defaultPlot.getWidth());
        assertEquals("Default Depth should be 1", 1, defaultPlot.getDepth());
    }
    @Test
    public void testParameterizedConstructor() {
        Plot paramPlot = new Plot(2, 2, 5, 6);
        assertEquals(2, paramPlot.getX());
        assertEquals(2, paramPlot.getY());
        assertEquals(5, paramPlot.getWidth());
        assertEquals(6, paramPlot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot copyPlot = new Plot(plot1);
        assertEquals(plot1.getX(), copyPlot.getX());
        assertEquals(plot1.getY(), copyPlot.getY());
        assertEquals(plot1.getWidth(), copyPlot.getWidth());
        assertEquals(plot1.getDepth(), copyPlot.getDepth());
    }

    // Test Getters and Setters
    @Test
    public void testGettersSetters() {
        Plot testPlot = new Plot();
        testPlot.setX(1);
        testPlot.setY(2);
        testPlot.setWidth(3);
        testPlot.setDepth(3);
        
        assertEquals(1, testPlot.getX());
        assertEquals(2, testPlot.getY());
        assertEquals(3, testPlot.getWidth());
        assertEquals(3, testPlot.getDepth());
    }

    // Test toString Method
    @Test
    public void testToString() {
        assertEquals("8,8,2,2", plot2.toString()); // Ensures correct format for plot
        Plot testPlot = new Plot(10, 12, 15, 20);
        assertEquals("10,12,15,20", testPlot.toString()); // Ensures correct format for other plot
    }
}
