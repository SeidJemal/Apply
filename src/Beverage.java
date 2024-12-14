/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Base class for all beverages, calculates base price and 
 * size adjustments.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

    
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

   
    public double getBasePrice() {
        return BASE_PRICE;
    }

    
    public String getBevName() {
        return bevName;
    }

    
    public Size getSize() {
        return size;
    }

    
    public Type getType() {
        return type;
    }

    
    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE;
            default: // SMALL
                return BASE_PRICE;
        }
    }

    
    @Override
    public String toString() {
        return bevName + ", " + size;
    }

    
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;
        }
        if (!(anotherBev instanceof Beverage)) {
            return false;
        }
        Beverage other = (Beverage) anotherBev;
        return bevName.equals(other.bevName) &&
                type == other.type &&
                size == other.size;
    }

    
    public abstract double calcPrice();
}
