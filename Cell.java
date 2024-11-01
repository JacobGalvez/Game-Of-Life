/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

Cell class to help with location.
 */
public class Cell implements ICell{
  private boolean CLive;
  private boolean CNextGen;
  private Grid cgrid;
  private int crow;
  private int ccol;
  public Cell (Grid parent, int row, int col, boolean Alive) {
    crow = row;
    ccol = col;
    cgrid = parent;
    CLive = Alive;
  }
  public int row() { return crow; }
  public int col() { return ccol; }
  public boolean is_alive() { return CLive; }
  public void update() { CLive = CNextGen; }
  public void determine() {
    Iterable pointNeighbors = Conditions.Neighbors(cgrid, crow, ccol);
    int liveNeighbors = Conditions.LiveNeighbors(pointNeighbors);
    CNextGen = Conditions.determine (CLive, liveNeighbors);
  }
}