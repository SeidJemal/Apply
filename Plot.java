package application;


/**
 * Class: CMSC203 
 * Program: Project 4
 * Instructor: Professor Gary Thai
 * Description: Defines a rectangular area with x, y coordinates, width, 
 * and depth. Provides methods to check if one plot encompasses or 
 * overlaps with another plot.
 * Due: 11/08/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Plot {
	
    private int x;
    private int y;
    private int width;
    private int depth;

    // Default Constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // Parameterized Constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Copy Constructor
    public Plot(Plot otherPlot) {
        this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to check if this plot encompasses another plot
    public boolean encompasses(Plot plot) {
        return this.x <= plot.getX() &&
               this.y <= plot.getY() &&
               (this.x + this.width) >= (plot.getX() + plot.getWidth()) &&
               (this.y + this.depth) >= (plot.getY() + plot.getDepth());
    }

    // Method to check if this plot overlaps with another plot
    public boolean overlaps(Plot plot) {
        return this.x < plot.getX() + plot.getWidth() &&
               this.x + this.width > plot.getX() &&
               this.y < plot.getY() + plot.getDepth() &&
               this.y + this.depth > plot.getY();
    }

    // toString method
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}

