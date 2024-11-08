package application;



/**
 * Class: CMSC203 
 * Program: Project 4
 * Instructor: Professor Gary Thai
 * Description: Represents an individual property with attributes like 
 * name, city, rent amount, owner, and its specific plot.
 * Due: 11/08/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */


public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Default Constructor
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    // Constructor with property details
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();  
    }

    // Constructor with property and plot details
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);  // Creates a Plot with specified values
    }

    // Copy Constructor
    public Property(Property otherProperty) {
        this(otherProperty.getPropertyName(), otherProperty.getCity(), otherProperty.getRentAmount(), otherProperty.getOwner(),
             otherProperty.getPlot().getX(), otherProperty.getPlot().getY(),
             otherProperty.getPlot().getWidth(), otherProperty.getPlot().getDepth());
    }

    // Getters
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    // Setters
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    // toString method
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}

