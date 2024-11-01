/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

Display class to display everything to console... also reads file
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public  class Display {

  public static void Show(boolean[][] state, char Alive, char Dead, String Title) {
    System.out.println(Title);
    for (boolean[] r : state) // prints the grid
    {
      for (boolean x : r)
      {
        System.out.print( (x) ? Alive : Dead);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static boolean[][] MakeState(String[] s, char Alive) {
    boolean[][] state = new boolean[s.length][s[0].length()];

    for (int r = 0; r < s.length; r++)
    {
      for (int c = 0; c < s[0].length(); c++)
      {
        state[r][c] = s[r].charAt(c) == Alive;
      }
    }
    return state;
  }

  public static Object[] ReadFile(String FileName, char Alive) throws FileNotFoundException {
    String[] s = new String[20];
    Scanner scanner = new Scanner(new File(FileName));
    for (int r = 0; r < 20; r++)
    {
      s[r] = scanner.next();
    }
    int gens = scanner.nextInt();
    return new Object[] {MakeState(s, Alive),gens};
  }
}