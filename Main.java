/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

This program simulates John Conways Game of Life reading the alive cells, and num of generations from a file.
 */
import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    String FileName = "grid.txt"; // file name

    Object[] returns = Display.ReadFile(FileName, 'X'); // X's from file read as alive cells
    boolean[][] FileState = (boolean[][]) returns[0];
    int gens = (int) returns[1];

    Grid field = new Grid(FileState, new NewCells());
    Display.Show(field.State(), 'X', 'o', "Board Start\n--------------------------");
    field.Update(gens);
    Display.Show(field.State(), 'X', 'o', "Board Finish\n-------------------------");

    System.out.println("Num of Generations: " + gens);
  }
}