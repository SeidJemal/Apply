package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class: CMSC203 
 * Program: Project 5
 * Instructor: Professor Gary Thai
 * Description: This is a utility class designed to manipulate and analyze 
 * two-dimensional ragged arrays of doubles.
 * Due: 11/25/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class TwoDimRaggedArrayUtility {
	
	
    public static double[][] readFile(File file) throws FileNotFoundException {
        List<double[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().trim().split("\\s+");
            double[] row = Arrays.stream(line).mapToDouble(Double::parseDouble).toArray();
            list.add(row);
        }
        scanner.close();
        return list.toArray(new double[0][]);
    }

   
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            writer.println(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
        writer.close();
    }

    
    public static double getTotal(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).sum();
    }

 
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        long count = Arrays.stream(data).flatMapToDouble(Arrays::stream).count();
        return total / count;
    }

    
    public static double getRowTotal(double[][] data, int row) {
        return Arrays.stream(data[row]).sum();
    }

    
    public static double getColumnTotal(double[][] data, int col) {
        return Arrays.stream(data).filter(row -> col < row.length).mapToDouble(row -> row[col]).sum();
    }

   
    public static double getHighestInRow(double[][] data, int row) {
        return Arrays.stream(data[row]).max().orElse(Double.NaN);
    }

    
    public static int getHighestInRowIndex(double[][] data, int row) {
        return IntStream.range(0, data[row].length).reduce((i, j) -> data[row][i] > data[row][j] ? i : j).orElse(-1);
    }

  
    public static double getLowestInRow(double[][] data, int row) {
        return Arrays.stream(data[row]).min().orElse(Double.NaN);
    }

    
    public static int getLowestInRowIndex(double[][] data, int row) {
        return IntStream.range(0, data[row].length).reduce((i, j) -> data[row][i] < data[row][j] ? i : j).orElse(-1);
    }

 
    public static double getHighestInColumn(double[][] data, int col) {
        return Arrays.stream(data).filter(row -> col < row.length).mapToDouble(row -> row[col]).max().orElse(Double.NaN);
    }


    public static int getHighestInColumnIndex(double[][] data, int col) {
        return IntStream.range(0, data.length)
                .filter(row -> col < data[row].length)
                .reduce((i, j) -> data[i][col] > data[j][col] ? i : j)
                .orElse(-1);
    }

    
    public static double getLowestInColumn(double[][] data, int col) {
        return Arrays.stream(data).filter(row -> col < row.length).mapToDouble(row -> row[col]).min().orElse(Double.NaN);
    }

  
    public static int getLowestInColumnIndex(double[][] data, int col) {
        return IntStream.range(0, data.length)
                .filter(row -> col < data[row].length)
                .reduce((i, j) -> data[i][col] < data[j][col] ? i : j)
                .orElse(-1);
    }


    public static double getHighestInArray(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).max().orElse(Double.NaN);
    }

   
    public static double getLowestInArray(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).min().orElse(Double.NaN);
    }

}
