package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

/**
 * Class: CMSC203 
 * Program: Project 5
 * Instructor: Professor Gary Thai
 * Description: This is a JUnit test class specifically designed to test 
 * the functionality of the TwoDimRaggedArrayUtility class.
 * Due: 11/25/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] sampleData1 = {
    	  {1.1, 2.2, 3.3},
    	  {4.4, 5.5},
    	  {6.6, 7.7, 8.8, 9.9}
    };

    @Test
    public void testGetTotal() {
        assertEquals(49.5 , TwoDimRaggedArrayUtility.getTotal(sampleData1), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(5.5, TwoDimRaggedArrayUtility.getAverage(sampleData1), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.6, TwoDimRaggedArrayUtility.getRowTotal(sampleData1, 0), 0.001);
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException {
        File outputFile = new File("output_data.txt");
        TwoDimRaggedArrayUtility.writeToFile(sampleData1, outputFile);
        assertTrue(outputFile.exists());
    }
}

