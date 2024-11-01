/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

Conditions that must be met for birth of a cell, or death of a cell...
 */
import java.util.ArrayList;
import java.util.List;

public class Conditions {
  public static boolean determine(boolean Alive, int Neighbors) {
    return (Alive && (Neighbors == 2 || Neighbors == 3)) || (!Alive && (Neighbors == 3));
  }

  public static int LiveNeighbors(Iterable<ICell> Neighbors) {
    int count = 0;

    for (ICell c: Neighbors) {
      if (c.is_alive())
      {
        count++;
      }
    }
    return count;
  }

  public static List<ICell> Neighbors(Grid g, int r, int c) {
    List<ICell> n = new ArrayList<>();
    AddWhenAlive(n, g.CellAt(r, c-1)); // left
    AddWhenAlive(n, g.CellAt(r+1, c-1)); // lower left
    AddWhenAlive(n, g.CellAt(r+1, c)); // lower
    AddWhenAlive(n, g.CellAt(r+1, c+1)); // lower right
    AddWhenAlive(n, g.CellAt(r, c+1)); // right
    AddWhenAlive(n, g.CellAt(r-1, c+1)); // upper right
    AddWhenAlive(n, g.CellAt(r-1, c)); // upper
    AddWhenAlive(n, g.CellAt(r-1, c-1)); // upper left
    return n;
  }

  private static void AddWhenAlive(List<ICell> l, ICell c) {
    if (c != null)
    {
      l.add(c);
    }
  }
}