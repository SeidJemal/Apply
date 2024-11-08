package application;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 4
 * Instructor: Professor Gary Thai
 * Description: JUnit test class for ManagementCompany.
 * Due: 11/08/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class ManagementCompanyTestStudent {
    Property sampleProperty1, sampleProperty2, sampleProperty3;
    ManagementCompany managementCo;

    @Before
    public void setUp() throws Exception {
        managementCo = new ManagementCompany("Bella", "123456789", 10.5);
    }

    @After
    public void tearDown() throws Exception {
        managementCo = null;
    }

    @Test
    public void testAddMultipleProperties() {
        sampleProperty1 = new Property("Sunshine Apt", "DC", 1300.0, "John", 1, 1, 3, 3);
        sampleProperty3 = new Property("ET Village", "Takoma", 1250.0, "Jane Smith", 4, 4, 2, 2);
        
        assertEquals(0, managementCo.addProperty(sampleProperty1)); // property added at index 0
        assertEquals(1, managementCo.addProperty(sampleProperty3)); // property added at index 1
    }

    // Test Parameterized Constructor
    @Test
    public void testParameterizedConstructor() {
        ManagementCompany customCompany = new ManagementCompany("Blink Homes", "987654321", 8.0, 1, 2, 10, 10);
        assertEquals("Blink Homes", customCompany.getName());
        assertEquals("987654321", customCompany.getTaxID());
        assertEquals(8.0, customCompany.getMgmFeePer(), 0.001);
        assertEquals(1, customCompany.getPlot().getX());
        assertEquals(2, customCompany.getPlot().getY());
        assertEquals(10, customCompany.getPlot().getWidth());
        assertEquals(10, customCompany.getPlot().getDepth());
    }

    // Test Copy Constructor
    @Test
    public void testCopyConstructor() {
        ManagementCompany copyCompany = new ManagementCompany(managementCo);
        assertEquals(managementCo.getName(), copyCompany.getName());
        assertEquals(managementCo.getTaxID(), copyCompany.getTaxID());
        assertEquals(managementCo.getMgmFeePer(), copyCompany.getMgmFeePer(), 0.001);
    }

    @Test
    public void testAddProperty() {
        sampleProperty1 = new Property("S and S Group", "Lauren", 2613, "Susu Ronald", 2, 5, 2, 2);
        assertEquals(0, managementCo.addProperty(sampleProperty1)); // property successfully added at index 0
    }
    
    // Test addProperty with overlapping plots
    @Test
    public void testAddPropertyOverlap() {
        sampleProperty1 = new Property("Sunshine Apt", "DC", 1300.0, "John", 1, 1, 3, 3);
        managementCo.addProperty(sampleProperty1);
        sampleProperty2 = new Property("Overlap Property", "Arlington", 1250.0, "Jane Doe", 2, 2, 3, 3);
        assertEquals(-4, managementCo.addProperty(sampleProperty2)); // Overlap should return -4
    }

    // Test getTotalRent
    @Test
    public void testGetTotalRent() {
        sampleProperty1 = new Property("Sunshine Apt", "DC", 1300.0, "John", 1, 1, 3, 3);
        sampleProperty3 = new Property("ET Village", "Takoma", 1250.0, "Jane Smith", 4, 4, 2, 2);
        managementCo.addProperty(sampleProperty1);
        managementCo.addProperty(sampleProperty3);

        assertEquals(2550.0, managementCo.getTotalRent(), 0.001); // Total rent should be 1300 + 1250
    }

    // Test getHighestRentProperty
    @Test
    public void testGetHighestRentProperty() {
        sampleProperty1 = new Property("Sunshine Apt", "DC", 1300.0, "John", 1, 1, 3, 3);
        sampleProperty3 = new Property("ET Village", "Takoma", 1250.0, "Jane Smith", 4, 4, 2, 2);
        managementCo.addProperty(sampleProperty1);
        managementCo.addProperty(sampleProperty3);

        assertEquals(sampleProperty1, managementCo.getHighestRentPropperty());
    }

    // Test toString
    @Test
    public void testToString() {
        sampleProperty1 = new Property("Sunshine Apt", "DC", 1300.0, "John", 1, 1, 3, 3);
        assertEquals(managementCo.addProperty(sampleProperty1), 0);
        String expectedString = "List of the properties for Bella, taxID: 123456789\n"
                + "______________________________________________________\n"
                + "Sunshine Apt,DC,John,1300.0\n"
                + "______________________________________________________\n"
                + "\n"
                + " total management Fee: 136.5";
        assertEquals(expectedString, managementCo.toString());
    }
}
