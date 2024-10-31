package application;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class: CMSC203 
 * Program: Project 3
 * Instructor: Professor Gary Thai
 * Description: Test class for CryptoManager. Checks that the Caesar and Bellaso 
 * encryption and decryption methods work correctly.
 *Due: 10/30/2024 
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student. 
 * Print your Name here: Seid Jemal
 */

public class CryptoManagerTestStudent {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("WELCOME TO CMSC"));
        assertTrue(CryptoManager.isStringInBounds("GREAT TIME"));
        assertFalse(CryptoManager.isStringInBounds("thank you")); 
        assertFalse(CryptoManager.isStringInBounds("set{}"));
    }

    @Test
    public void testEncryptCaesar() {
    	assertEquals("-Y'", CryptoManager.caesarEncryption("YES", 20));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("abc", 5));
        assertEquals("*20& ", CryptoManager.caesarEncryption("MUSIC", 93));
    
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("I LOVE SOCCER", CryptoManager.caesarDecryption("-D03:)D73'')6", 100));
        assertEquals("ALWAYS BE HAPPY", CryptoManager.caesarDecryption("BMXBZT!CF!IBQQZ", 1));
        assertEquals("MOM", CryptoManager.caesarDecryption("HJH", 123));
    }

    @Test
    public void testEncryptBellaso() {
    	assertEquals("Q]SUX%^V", CryptoManager.bellasoEncryption("ETHIOPIA", "LIKLIUUUHYGGTTTT"));
    	assertEquals("DETR'!M\"PH!", CryptoManager.bellasoEncryption("ADDIS ABABA", "CAPITAL OF AFRICA"));
    	assertEquals("92>6", CryptoManager.bellasoEncryption("HOME", "1#11255"));
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("I GOT THIS", CryptoManager.bellasoDecryption("R@H\\4(UXY#", "I AM HAPPPPYYYYY"));
        assertEquals("MAXIMUM", CryptoManager.bellasoDecryption("V! J#Z-", "I HAVE DONE THE PROJECT."));
        assertEquals("TEST PASSES", CryptoManager.bellasoDecryption("+T^].W!\"!%'", "WOKING ON THE NEXT ONE."));
    }
}
