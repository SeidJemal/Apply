import java.util.ArrayList;
import java.util.Random;

/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Manages a list of beverages and calculates the order total.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber; 
    private int orderTime; 
    private Day orderDay; 
    private Customer customer; 
    private ArrayList<Beverage> beverages; 

    
    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderNumber = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust); 
        this.beverages = new ArrayList<>();
    }

    
    public int generateOrder() {
        return new Random().nextInt(80001) + 10000;
    }

    
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    
    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

  
    @Override
    public double calcOrderTotal() {
        return beverages.stream().mapToDouble(Beverage::calcPrice).sum();
    }

  
    @Override
    public int findNumOfBeveType(Type type) {
        return (int) beverages.stream().filter(bev -> bev.getType() == type).count();
    }

    
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    
    public int getTotalItems() {
        return beverages.size();
    }

    
    public int getOrderNo() {
        return orderNumber;
    }

    
    public int getOrderTime() {
        return orderTime;
    }

    
    public Day getOrderDay() {
        return orderDay;
    }

    
    public Customer getCustomer() {
        return customer;
    }

    
    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    
    @Override
    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.orderNumber, anotherOrder.getOrderNo());
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
        for (Beverage bev : beverages) {
            sb.append(bev).append("\n");
        }
        sb.append("Total Order Price: $").append(calcOrderTotal());
        return sb.toString();
    }
}
