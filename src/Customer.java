
/**
 * Class: CMSC203 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description:This class includes attributes for the customer's name and age, 
 * along with methods to access and modify these attributes.
 * Due: 12/13/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */
public class Customer {
    private String name; 
    private int age;     

   
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

   
    public Customer(Customer c) {
        this.name = c.name;
        this.age = c.age;
    }

   
    public int getAge() {
        return age;
    }

    
    public void setAge(int age) {
        this.age = age;
    }

    
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    
    @Override
    public String toString() {
        return "Customer Name: " + name + ", Age: " + age;
    }
}


