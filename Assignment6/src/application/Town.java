package application;

import java.util.Objects;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: Represents a town (vertex) identified by name, supports comparison and equality.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Town implements Comparable<Town> {
    private String name;

    public Town(String name) {
        this.name = name;
    }

    public Town(Town templateTown) {
        this.name = templateTown.name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Town other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Town)) return false;
        Town other = (Town) obj;
        return this.name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return name;
    }
}
