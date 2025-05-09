package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: Manager class that wraps the Graph; handles adding towns/roads and getting paths using names.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class TownGraphManager implements TownGraphManagerInterface {
    private Graph graph;

    public TownGraphManager() {
        graph = new Graph();
    }

    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        Town t1 = new Town(town1);
        Town t2 = new Town(town2);
        if (!graph.containsVertex(t1)) graph.addVertex(t1);
        if (!graph.containsVertex(t2)) graph.addVertex(t2);
        graph.addEdge(t1, t2, weight, roadName);
        return true;
    }

    @Override
    public String getRoad(String town1, String town2) {
        Town t1 = new Town(town1);
        Town t2 = new Town(town2);
        Road r = graph.getEdge(t1, t2);
        return r != null ? r.getName() : null;
    }

    @Override
    public boolean addTown(String name) {
        return graph.addVertex(new Town(name));
    }

    @Override
    public Town getTown(String name) {
        for (Town t : graph.vertexSet()) {
            if (t.getName().equalsIgnoreCase(name))
                return t;
        }
        return null;
    }

    @Override
    public boolean containsTown(String name) {
        return graph.containsVertex(new Town(name));
    }

    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
    }

    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> list = new ArrayList<>();
        for (Road r : graph.edgeSet())
            list.add(r.getName());
        Collections.sort(list);
        return list;
    }

    @Override
    public boolean deleteRoadConnection(String town1, String town2, String road) {
        Road r = graph.getEdge(new Town(town1), new Town(town2));
        if (r != null && r.getName().equalsIgnoreCase(road)) {
            graph.removeEdge(r.getSource(), r.getDestination(), r.getWeight(), r.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTown(String name) {
        return graph.removeVertex(new Town(name));
    }

    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> list = new ArrayList<>();
        for (Town t : graph.vertexSet())
            list.add(t.getName());
        Collections.sort(list);
        return list;
    }

    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        Town t1 = getTown(town1);
        Town t2 = getTown(town2);
        if (t1 == null || t2 == null) return new ArrayList<>();
        return graph.shortestPath(t1, t2);
    }

    public void populateTownGraph(File file) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(";");
                String[] roadInfo = parts[0].split(",");
                String roadName = roadInfo[0];
                int distance = Integer.parseInt(roadInfo[1]);
                String town1 = parts[1];
                String town2 = parts[2];
                addTown(town1);
                addTown(town2);
                addRoad(town1, town2, distance, roadName);
            }
        }
        scanner.close();
    }
}

