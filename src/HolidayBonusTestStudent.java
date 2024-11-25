package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class: CMSC203 
 * Program: Project 5
 * Instructor: Professor Gary Thai
 * Description: This is a JUnit test class specifically designed to test 
 * the functionality of the HolidayBonus class.
 * Due: 11/25/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class HolidayBonusTestStudent {
	
    private double[][] sampleData1 = {
    	{1.1, 2.2, 3.3},
      	{4.4, 5.5},
      	{6.6, 7.7, 8.8, 9.9}
    };

    @Test
    public void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(sampleData1);
        assertEquals(3, bonuses.length); 
        assertTrue(bonuses[0] > 0);      
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(sampleData1);
        assertTrue(totalBonus > 0);     
    }
}
