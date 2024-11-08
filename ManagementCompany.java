package application;




/**
 * Class: CMSC203 
 * Program: Project 4
 * Instructor: Professor Gary Thai
 * Description: Manages a set of properties for rent, defined within 
 * a specific plot. It tracks property details, ensures no overlap, and 
 * calculates the total rent and management fees.
 * Due: 11/08/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Default Constructor
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Constructor with company details only
    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Constructor with company and plot details
    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // Copy Constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer,
             otherCompany.plot.getX(), otherCompany.plot.getY(),
             otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
    }

    // Method to add a property by details
    public int addProperty(String name, String city, double rent, String owner) {
        Property property = new Property(name, city, rent, owner);
        return addProperty(property);
    }

    // Method to add a property by details with plot
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        Property property = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(property);
    }

    // Method to add a property object
    public int addProperty(Property property) {
        if (isPropertiesFull()) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    // Method to get property with the highest rent
    public Property getHighestRentPropperty() {
        if (numberOfProperties == 0) return null;

        Property maxRentProperty = properties[0];
       
        for (int i = 1; i < numberOfProperties; i++) {
           
            if (properties[i].getRentAmount() > maxRentProperty.getRentAmount()) {
                maxRentProperty = properties[i];
               
            }
        }
        return maxRentProperty;
    }


    // Getters
    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public String getTaxID() {
        return taxID;
    }

    // Method to get total rent
    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    // Method to check if management fee is valid
    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    // Method to check if properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Method to remove the last property
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder propertyList = new StringBuilder();
        propertyList.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        propertyList.append("______________________________________________________\n");

        for (Property property : properties) {
            if (property == null) break;
            propertyList.append(property.toString()).append("\n");
        }

        propertyList.append("______________________________________________________\n");
        propertyList.append("\n");
        propertyList.append(" total management Fee: ").append(getTotalRent() * mgmFeePer / 100);

        return propertyList.toString();
    }
}
