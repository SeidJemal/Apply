/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Represents smoothies, adds costs for fruits and protein.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class Smoothie extends Beverage {
    private int numOfFruits; 
    private boolean addProtein; 
    public static final double FRUIT_COST = 0.5; 
    public static final double PROTEIN_COST = 1.5; 

   
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size); 
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    
    public int getNumOfFruits() {
        return numOfFruits;
    }

    
    public boolean getAddProtein() {
        return addProtein;
    }

    
    @Override
    public double calcPrice() {
        double price = addSizePrice(); 
        price += numOfFruits * FRUIT_COST; 
        if (addProtein) {
            price += PROTEIN_COST; 
        }
        return price;
    }

    
    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + ", Protein Added: " + addProtein
                + ", Price: $" + calcPrice();
    }

    
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;
        }
        if (!(anotherBev instanceof Smoothie)) {
            return false;
        }
        Smoothie other = (Smoothie) anotherBev;
        return super.equals(other) && this.numOfFruits == other.numOfFruits && this.addProtein == other.addProtein;
    }
}
