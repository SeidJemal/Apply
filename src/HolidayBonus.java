package application;

import java.util.Arrays;

/**
 * Class: CMSC203 
 * Program: Project 5
 * Instructor: Professor Gary Thai
 * Description:calculates holiday bonuses for stores in a district 
 * based on their sales data.
 * Due: 11/25/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class HolidayBonus {

	private static final double BONUS_HIGH = 5000.0;
    private static final double BONUS_LOW = 1000.0;
    private static final double BONUS_OTHER = 2000.0;

   
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int col = 0; col < getMaxColumns(data); col++) {
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    if (data[row][col] <= 0) continue;
                    if (data[row][col] == data[highIndex][col]) bonuses[row] += BONUS_HIGH;
                    else if (data[row][col] == data[lowIndex][col]) bonuses[row] += BONUS_LOW;
                    else bonuses[row] += BONUS_OTHER;
                }
            }
        }
        return bonuses;
    }


    public static double calculateTotalHolidayBonus(double[][] data) {
        return Arrays.stream(calculateHolidayBonus(data)).sum();
    }

  
    private static int getMaxColumns(double[][] data) {
        return Arrays.stream(data).mapToInt(row -> row.length).max().orElse(0);
    }
	
}
