/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

Class to determine dead or alive after conditions are met.
 */
import static org.junit.jupiter.api.Assertions.*;

class ConditionsTest { // bound checking, neihbor checking
  @org.junit.jupiter.api.Test
  void determine() {
    assertEquals(false, Conditions.determine(true, 0));
    assertEquals(false, Conditions.determine(true, 1));
    assertEquals(true, Conditions.determine(true, 2));
    assertEquals(true, Conditions.determine(true, 3));
    assertEquals(false, Conditions.determine(true, 4));
    assertEquals(false, Conditions.determine(true, 5));
    assertEquals(false, Conditions.determine(true, 6));
    assertEquals(false, Conditions.determine(true, 7));
    assertEquals(false, Conditions.determine(true, 8));
    assertEquals(false, Conditions.determine(false, 0));
    assertEquals(false, Conditions.determine(false, 1));
    assertEquals(false, Conditions.determine(false, 2));
    assertEquals(true, Conditions.determine(false, 3));
    assertEquals(false, Conditions.determine(false, 4));
    assertEquals(false, Conditions.determine(false, 5));
    assertEquals(false, Conditions.determine(false, 6));
    assertEquals(false, Conditions.determine(false, 7));
    assertEquals(false, Conditions.determine(false, 8));

  }
}