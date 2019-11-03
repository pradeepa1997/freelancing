/* This class is used to construct the objects representing the 
   cells of the grid.  Cell objects represent their current state (on) and can   
   calculate their next state (next).  They can update to their next state and draw 
   themselves.
*/

import javax.swing.*;   
import java.awt.*;  
import java.awt.event.*;

public class Cell {
  int x, y;
  boolean on, next;
 
  public Cell(int x, int y, boolean on) {
    this.x = x;
    this.y = y;
    this.next = this.on = on;
  }
  
  public boolean getOn() { 
    return on; 
  }
  
  public void setOn(boolean on) { 
    this.next = this.on = on; 
  }
  
  // update to next state and draw in the Graphics object (passed by GridPanel)
  public void setAndDrawNext(Graphics g) {
    on = next;
    // draw circle size 8x8 in grid cell size 10x10
    if( on ) g.fillOval(x * 10 + 1, y * 10 + 1, 8, 8);
  }
 
  // calculate the state this cell will have in the next update -
  // takes as input a reference to the grid so it can examine its neighbours
  public void calcNext( Cell[ ][ ] grid ) {
    int sum = 0, mx = x - 1, my = y - 1, px = x + 1, py = y + 1;
    // neighbours "wrap around" at the edge of the grid
    if( mx < 0 ) mx = Life.SIZE - 1;
    if( my < 0 ) my = Life.SIZE - 1;
    if( px >= Life.SIZE ) px = 0;
    if( py >= Life.SIZE ) py = 0;
    // test 8 neighbours, 3 above, 3 below, 1 left, 1 right
    if( grid[ mx ][ my ].getOn() ) sum++;  // check 3 above (my is y minus 1)
    if( grid[   x  ][ my ].getOn() ) sum++;
    if( grid[  px ][ my ].getOn() ) sum++;
    if( grid[ mx ][   y  ].getOn() ) sum++;  // check 1 left and 1 right
    if( grid[ px  ][   y  ].getOn() ) sum++;
    if( grid[ mx ][  py ].getOn() ) sum++;  // check 3 below (py is y plus 1)
    if( grid[    x ][  py ].getOn() ) sum++;
    if( grid[  px ][  py ].getOn() ) sum++;
    // this test implements the central update rule of the game 
    if ( (on && sum == 2) || sum == 3 ) next = true; 
    else next = false;
  }

} // Cell
