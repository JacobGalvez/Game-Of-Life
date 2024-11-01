/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

setting up grid and grid logic
 */
import java.util.*;

public class Grid implements Iterable<ICell> {
  private ICell[][] gridBoard;
  private int rows, cols;

  public Grid(boolean[][] start, INewCells nc)
  {
    rows = start.length;
    cols = start[0].length;
    gridBoard = new ICell[rows][cols];
    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        gridBoard[r][c] = nc.Make(this, r, c, start[r][c]);
      }
    }
  }

  // to get state of a cell
  public boolean[][] State() {
    boolean[][] state = new boolean[rows][cols];

    for (ICell c: this)
    {
      state[c.row()][c.col()] = c.is_alive();
    }
    return state;
  }

  // gets cell location
  public ICell CellAt(int r, int c) {
    return (r >= 0 && r < rows && c >= 0 && c < cols) ?gridBoard[r][c]: null;
  }

  // determines whether the cell has changed or not
  public void NewGen()
  {
    for (ICell cell: this)
    {
      cell.determine();
    }
    for (ICell cell: this)
    {
      cell.update();
    }
  }

  // for several generations
  public void Update(int Generations) {
    for (int i = 0; i < Generations; ++i)
    {
      NewGen();
    }
  }

  public Iterator<ICell> iterator() {
    return new GridIterator();
  }
// create an iterator for the grid
  class GridIterator implements Iterator<ICell> {
    private int r = 0;
    private int c = 0;
    public boolean hasNext() {
      return (r < rows) && (c < cols);
    }

    public ICell next() {
      if (!hasNext())
      {
        return null;
      }
      ICell cell = gridBoard[r][c];
      c++;
      if (c >= cols)
      {
        c = 0; r++;
      }
      return cell;
    }
  }
}