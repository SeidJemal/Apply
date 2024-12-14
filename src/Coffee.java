
/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Represents coffee beverages, adds costs for extra shots 
 * and syrup.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class Coffee extends Beverage {
    private boolean extraShot; 
    private boolean extraSyrup; 
    public static final double EXTRA_SHOT_COST = 0.5; 
    public static final double EXTRA_SYRUP_COST = 0.5; 

    
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size); 
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    
    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    
    @Override
    public double calcPrice() {
        double price = addSizePrice(); 
        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }
        return price;
    }

    
    @Override
    public String toString() {
        return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup
                + ", Price: $" + calcPrice();
    }

   
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;
        }
        if (!(anotherBev instanceof Coffee)) {
            return false;
        }
        Coffee other = (Coffee) anotherBev;
        return super.equals(other) && this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
    }
}

