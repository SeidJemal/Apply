package application;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: JUnit test that checks adding, removing, and shortest paths in the Graph class.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class Graph_STUDENT_Test {

    private Graph graph;
    private Town T1, T2, T3;

    @Before
    public void setUp() {
        graph = new Graph();
        T1 = new Town("NewTown1");
        T2 = new Town("NewTown2");
        T3 = new Town("NewTown3");

        graph.addVertex(T1);
        graph.addVertex(T2);
        graph.addVertex(T3);

        graph.addEdge(T1, T2, 3, "AB_12");
        graph.addEdge(T2, T3, 2, "BC_12");
    }

    @Test
    public void testAddEdgeAndContainsEdge() {
        assertTrue(graph.containsEdge(T1, T2));
        assertTrue(graph.containsEdge(T2, T1));  // undirected check
        assertFalse(graph.containsEdge(T1, T3));
    }

    @Test
    public void testGetEdge() {
        Road road = graph.getEdge(T1, T2);
        assertNotNull(road);
        assertEquals("AB_12", road.getName());
        assertEquals(3, road.getWeight());
    }

    @Test
    public void testShortestPath() {
        ArrayList<String> path = graph.shortestPath(T1, T3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals("NewTown1 via AB_12 to NewTown2 3 mi", path.get(0).trim());
        assertEquals("NewTown2 via BC_12 to NewTown3 2 mi", path.get(1).trim());
    }

    @Test
    public void testRemoveEdge() {
        graph.removeEdge(T1, T2, 3, "AB_12");
        assertFalse(graph.containsEdge(T1, T2));
    }

    @Test
    public void testVertexSet() {
        Set<Town> towns = graph.vertexSet();
        assertEquals(3, towns.size());
        assertTrue(towns.contains(T1));
        assertTrue(towns.contains(T2));
        assertTrue(towns.contains(T3));
    }

    @Test
    public void testEdgesOf() {
        Set<Road> edges = graph.edgesOf(T2);
        ArrayList<String> names = new ArrayList<>();
        for (Road r : edges) {
            names.add(r.getName());
        }
        assertTrue(names.contains("AB_12"));
        assertTrue(names.contains("BC_12"));
    }
}
