package application;

import java.util.*;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: Main graph class that manages towns and roads, uses Dijkstra’s algorithm to find shortest paths..
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> towns;
    private Set<Road> roads;
    private Map<Town, List<Road>> adjacencyList;
    private Map<Town, Integer> distances;
    private Map<Town, Town> previous;

    public Graph() {
        towns = new HashSet<>();
        roads = new HashSet<>();
        adjacencyList = new HashMap<>();
    }

    @Override
    public Road getEdge(Town source, Town destination) {
        for (Road r : roads) {
            if (r.contains(source) && r.contains(destination)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Road addEdge(Town source, Town destination, int weight, String name) {
        if (!towns.contains(source) || !towns.contains(destination)) {
            throw new IllegalArgumentException();
        }

        Road road = new Road(source, destination, weight, name);
        roads.add(road);

        adjacencyList.get(source).add(road);
        adjacencyList.get(destination).add(road);

        return road;
    }

    @Override
    public boolean addVertex(Town town) {
        if (town == null) throw new NullPointerException();
        if (towns.contains(town)) return false;

        towns.add(town);
        adjacencyList.put(town, new ArrayList<>());
        return true;
    }

    @Override
    public boolean containsEdge(Town source, Town destination) {
        return getEdge(source, destination) != null;
    }

    @Override
    public boolean containsVertex(Town town) {
        return towns.contains(town);
    }

    @Override
    public Set<Road> edgeSet() {
        return new HashSet<>(roads);
    }

    @Override
    public Set<Road> edgesOf(Town town) {
        if (!adjacencyList.containsKey(town)) throw new IllegalArgumentException();
        return new HashSet<>(adjacencyList.get(town));
    }

    @Override
    public Road removeEdge(Town source, Town destination, int weight, String description) {
        Road target = new Road(source, destination, weight, description);
        if (roads.remove(target)) {
            adjacencyList.get(source).remove(target);
            adjacencyList.get(destination).remove(target);
            return target;
        }
        return null;
    }

    @Override
    public boolean removeVertex(Town town) {
        if (!towns.contains(town)) return false;

        for (Road r : new HashSet<>(adjacencyList.get(town))) {
            removeEdge(r.getSource(), r.getDestination(), r.getWeight(), r.getName());
        }

        adjacencyList.remove(town);
        towns.remove(town);
        return true;
    }

    @Override
    public Set<Town> vertexSet() {
        return new HashSet<>(towns);
    }

    @Override
    public void dijkstraShortestPath(Town source) {
        distances = new HashMap<>();
        previous = new HashMap<>();
        Set<Town> visited = new HashSet<>();
        PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (Town t : towns) {
            distances.put(t, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Town current = pq.poll();
            if (!visited.add(current)) continue;

            for (Road r : adjacencyList.get(current)) {
                Town neighbor = r.getDestination().equals(current) ? r.getSource() : r.getDestination();
                if (visited.contains(neighbor)) continue;

                int newDist = distances.get(current) + r.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public ArrayList<String> shortestPath(Town source, Town destination) {
        dijkstraShortestPath(source);
        ArrayList<String> path = new ArrayList<>();

        if (!previous.containsKey(destination) && !source.equals(destination)) {
            return path;
        }

        LinkedList<Town> townsPath = new LinkedList<>();
        Town step = destination;
        while (step != null) {
            townsPath.addFirst(step);
            step = previous.get(step);
        }

        for (int i = 0; i < townsPath.size() - 1; i++) {
            Town from = townsPath.get(i);
            Town to = townsPath.get(i + 1);
            Road road = getEdge(from, to);
            path.add(from + " via " + road.getName() + " to " + to + " " + road.getWeight() + " mi");
        }

        return path;
    }
}
