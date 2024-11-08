package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Class: CMSC203 
 * Program: Project 4
 * Instructor: Professor Gary Thai
 * Description: JUnit test class for Property
 * Due: 11/08/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */


class PropertyTestStudent {
    private Property sampleProperty1, sampleProperty2, sampleProperty3;

    @BeforeEach
    void setUp() throws Exception {
        sampleProperty1 = new Property("Blue Apartments", "Rockville", 1200.00, "Bank of America");
        sampleProperty2 = new Property("DC homes", "Washington DC", 2400.00, "Chase Bank", 2, 2, 5, 5);
        sampleProperty3 = new Property(sampleProperty1);
    }

    @AfterEach
    void tearDown() throws Exception {
        sampleProperty1 = sampleProperty2 = sampleProperty3 = null;
    }

    // Test Constructors
    @Test
    void testDefaultConstructor() {
        Property defaultProperty = new Property();
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertEquals("", defaultProperty.getOwner());
        assertEquals(0, defaultProperty.getPlot().getX());
        assertEquals(0, defaultProperty.getPlot().getY());
        assertEquals(1, defaultProperty.getPlot().getWidth());
        assertEquals(1, defaultProperty.getPlot().getDepth());
    }

    @Test
    void testParameterizedConstructor() {
        assertEquals("DC homes", sampleProperty2.getPropertyName());
        assertEquals("Washington DC", sampleProperty2.getCity());
        assertEquals(2400.0, sampleProperty2.getRentAmount());
        assertEquals("Chase Bank", sampleProperty2.getOwner());
        assertEquals(2, sampleProperty2.getPlot().getX());
        assertEquals(2, sampleProperty2.getPlot().getY());
        assertEquals(5, sampleProperty2.getPlot().getWidth());
        assertEquals(5, sampleProperty2.getPlot().getDepth());
    }

    @Test
    void testCopyConstructor() {
        assertEquals(sampleProperty1.getPropertyName(), sampleProperty3.getPropertyName());
        assertEquals(sampleProperty1.getCity(), sampleProperty3.getCity());
        assertEquals(sampleProperty1.getRentAmount(), sampleProperty3.getRentAmount());
        assertEquals(sampleProperty1.getOwner(), sampleProperty3.getOwner());
        assertEquals(sampleProperty1.getPlot().getX(), sampleProperty3.getPlot().getX());
        assertEquals(sampleProperty1.getPlot().getY(), sampleProperty3.getPlot().getY());
        assertEquals(sampleProperty1.getPlot().getWidth(), sampleProperty3.getPlot().getWidth());
        assertEquals(sampleProperty1.getPlot().getDepth(), sampleProperty3.getPlot().getDepth());
    }


    @Test
    void testGetOwner() {
        assertEquals("Bank of America", sampleProperty1.getOwner());
        assertEquals("Chase Bank", sampleProperty2.getOwner());
    }

    // Test Setters
    @Test
    void testSetCity() {
        sampleProperty1.setCity("Silver Spring");
        assertEquals("Silver Spring", sampleProperty1.getCity());
    }

    @Test
    void testSetOwner() {
        sampleProperty1.setOwner("Bank of America");
        assertEquals("Bank of America", sampleProperty1.getOwner());
    }

    @Test
    void testSetRentAmount() {
        sampleProperty1.setRentAmount(1700.0);
        assertEquals(1700.0, sampleProperty1.getRentAmount());
    }

    // Test toString Method
    @Test
    void testToString() {
        assertEquals("Blue Apartments,Rockville,Bank of America,1200.0", sampleProperty1.toString());
        assertEquals("DC homes,Washington DC,Chase Bank,2400.0", sampleProperty2.toString());
    }
}
