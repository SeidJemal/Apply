package application;

import java.util.Objects;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: Represents a road (edge) between two towns, storing the name, distance, and end points.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Road implements Comparable<Road> {
    private Town source;
    private Town destination;
    private int weight;
    private String name;

    public Road(Town source, Town destination, int weight, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.name = name;
    }

    public Road(Town source, Town destination, String name) {
        this(source, destination, 1, name);
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean contains(Town town) {
        return source.equals(town) || destination.equals(town);
    }

    @Override
    public int compareTo(Road other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " connects " + source + " and " + destination + " (" + weight + " mi)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Road)) return false;
        Road other = (Road) obj;

        return this.weight == other.weight &&
               this.name.equalsIgnoreCase(other.name) &&
               ((this.source.equals(other.source) && this.destination.equals(other.destination)) ||
                (this.source.equals(other.destination) && this.destination.equals(other.source)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), weight,
                source.hashCode() + destination.hashCode());
    }
}

