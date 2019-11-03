/* 
 Anthony, October 2006, JDK 1.5, Conway's game of Life simulator.
 This and related files can be found in the COMP103 Lab (LabFiles). 
 See also Lecture 25 for more details.  Note hardcoded grid cell size is 10. 
 Background:
      http://en.wikipedia.org/wiki/Conway's_Game_of_Life
 Text "images" of interesting life states, can be used as inputs for this program:
      http://www.argentum.freeserve.co.uk/lex.htm 
 Animations of interesting life states:
      http://www.ericweisstein.com/encyclopedias/life/animations.html
*/

import javax.swing.JFrame;

public class Life {
  public static final int SIZE = 75;   // x and y dimension of the grid
  public static final int SPEED = 50;  // speed of timer events (msec)

  public static void main (String[ ] args) {
    JFrame frame = new JFrame ("Conway's Game of Life");;
    frame.getContentPane().add( new PrimaryPanel() );
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}  // Life
