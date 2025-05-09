package application;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC204 
 * Program: Project 6
 * Instructor: Professor Gary Thai
 * Description: JUnit test that checks adding towns, adding roads, and finding paths in TownGraphManager.
 * Due: 05/08/2025 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class TownGraphManager_STUDENT_Test {

    private TownGraphManager town;

    @Before
    public void setUp() {
        town = new TownGraphManager();
        town.addTown("New_Town_1");
        town.addTown("New_Town_2");
        town.addTown("New_Town_3");

        town.addRoad("New_Town_1", "New_Town_2", 4, "GA97");
        town.addRoad("New_Town_2", "New_Town_3", 5, "AB53");
    }

    @Test
    public void testAddTownAndContains() {
        assertTrue(town.containsTown("New_Town_1"));
        assertFalse(town.containsTown("Unknown_Town"));
    }

    @Test
    public void testGetRoad() {
        assertEquals("GA97", town.getRoad("New_Town_1", "New_Town_2"));
        assertEquals("AB53", town.getRoad("New_Town_2", "New_Town_3"));
    }

    @Test
    public void testAllTownsSorted() {
        ArrayList<String> towns = town.allTowns();
        assertEquals(Arrays.asList("New_Town_1", "New_Town_2", "New_Town_3"), towns);
    }

    @Test
    public void testGetPathBetweenTowns() {
        ArrayList<String> path = town.getPath("New_Town_1", "New_Town_3");
        assertEquals(2, path.size());
        assertTrue(path.get(0).contains("GA97"));
        assertTrue(path.get(1).contains("AB53"));
    }

    @Test
    public void testDeleteTownAndRoad() {
        town.deleteRoadConnection("New_Town_2", "New_Town_3", "AB53");
        assertFalse(town.containsRoadConnection("New_Town_2", "New_Town_3"));
        town.deleteTown("New_Town_2");
        assertFalse(town.containsTown("New_Town_2"));
    }
}


