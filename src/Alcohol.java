/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Represents alcohol beverages, adds weekend pricing.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class Alcohol extends Beverage {
    private boolean isWeekend;
    public static final double WEEKEND_COST = 0.6; 

    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size); 
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice(); 
        if (isWeekend) {
            price += WEEKEND_COST;
        }
        return price;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weekend Offer: " + isWeekend + ", Price: $" + calcPrice();
    }


    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;
        }
        if (!(anotherBev instanceof Alcohol)) {
            return false;
        }
        Alcohol other = (Alcohol) anotherBev;
        return super.equals(other) && this.isWeekend == other.isWeekend;
    }
}


