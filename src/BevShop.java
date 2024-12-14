import java.util.ArrayList;

/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:Handles orders, enforces rules, and calculates monthly sales.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders; 
    private Order currentOrder; 
    private int alcoholCount; 

    
    public BevShop() {
        orders = new ArrayList<>();
        alcoholCount = 0;
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return alcoholCount < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return alcoholCount;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid order time.");
        }
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        alcoholCount = 0;
        orders.add(currentOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (!isEligibleForMore()) {
            throw new IllegalArgumentException("Maximum alcohol drinks for this order reached.");
        }
        if (!isValidAge(currentOrder.getCustomer().getAge())) {
            throw new IllegalArgumentException("Customer is not eligible to order alcohol.");
        }
        currentOrder.addNewBeverage(bevName, size);
        alcoholCount++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Maximum fruits for Smoothie exceeded.");
        }
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) { // Corrected method
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        return orders.stream().mapToDouble(Order::calcOrderTotal).sum();
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid order index.");
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) { // Corrected method
                    minIndex = j;
                }
            }
            // Swap
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Orders:\n");
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        sb.append("Total Monthly Sale: $").append(totalMonthlySale());
        return sb.toString();
    }
}
