/*
Name: Jacob Galvez
Date: 11/21/2021
Class: CS 3354.003
Professor Rick King

Interface for cell class...
 */
public interface ICell {

  boolean is_alive();
  int row();
  int col();
  void update();
  void determine();
}