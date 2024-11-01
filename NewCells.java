/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

NewCells Class to help with filling out grid
 */
class NewCells implements INewCells {
  public ICell Make(Grid parent, int row, int col, boolean c) { return new Cell(parent, row, col, c); }
}