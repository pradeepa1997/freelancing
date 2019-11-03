import javax.swing.*;  import java.awt.*;  import java.util.Scanner;
import java.awt.event.*;  import java.io.*;

public class PrimaryPanel extends JPanel {
   //data fields refer to a button panel and a grid panel (both are inner classes)
   private ButtonPanel buttonPanel = new ButtonPanel();
   private GridPanel gridPanel = new GridPanel();
  // constructor simply adds these panels to the PrimaryPanel
   public PrimaryPanel() {
      add( buttonPanel );
      add( gridPanel );
   }
   // inner classes follow (ButtonPanel on page 2, GridPanel on pages 3 and 4)
 
   // panel to hold buttons (inner class of PrimaryPanel) 
   class ButtonPanel extends JPanel {
      private ButtonListener buttonListener = new ButtonListener();
      private JButton start = new JButton("Start");
      private JButton stop = new JButton("Stop");
      private JButton step = new JButton("Step");
      private JButton rand = new JButton("Random");
      private JButton load = new JButton("Load");
      private JButton [ ] buttons = {start, stop, step, rand, load};

      // constructor sets up the button panel
      public ButtonPanel() {     
         setPreferredSize( new Dimension( 100, Life.SIZE * 10 ) );
         setBackground (Color.yellow);
         for (int i = 0; i < buttons.length; i++) {  // set up buttons
            buttons[ i ].addActionListener(buttonListener);
            buttons[ i ].setBackground(Color.yellow);
         }
         add(new JLabel("Control:"));
         add(start);    
         add(stop);    
         add(step);
         add(new JLabel("Initialise:"));
         add(rand);    
         add(load);
      }

      // listener to handle button presses (inner class of inner class ButtonPanel)
      class ButtonListener implements ActionListener {
         public void actionPerformed(ActionEvent ae) {
            Object source = ae.getSource();
            if         ( source == start)    gridPanel.timer.start();
            else if ( source == stop )  gridPanel.timer.stop();
            else if ( source == step ) {gridPanel.timer.stop(); gridPanel.step();}
            else if ( source == rand ) {gridPanel.timer.stop(); gridPanel.initRandom();}
            else if ( source == load ) {gridPanel.timer.stop(); gridPanel.initLoadFile();}
         }
      } // ButtonListener   
  
   } // ButtonPanel  (end of first inner class)
   
    // panel to define life grid (inner class of PrimaryPanel)
   class GridPanel extends JPanel {
      private Timer timer = new Timer( Life.SPEED,  new TimeListener() );
      private Cell[ ][ ] grid = new Cell[ Life.SIZE ][ Life.SIZE ];

      // constructor to set up the grid panel
      public GridPanel() {
         setPreferredSize( new Dimension( Life.SIZE * 10, Life.SIZE * 10) );
         // create Cell object for each place in the grid, all set to off
         for(int y = 0; y < Life.SIZE; y++) {
            for(int x = 0; x < Life.SIZE; x++) {
               grid[x][y] = new Cell(x, y, false);
            }
         } 
      }

      // initialise the grid to a random start state
      public void initRandom() {
         boolean on;
         for(int y = 0; y < Life.SIZE; y++) {
            for(int x = 0; x < Life.SIZE; x++) {
               if (Math.random() > 0.5) on = true; else on = false;
               grid[x][y].setOn(on);
            }
         } 
         repaint(); 
      }

// initialise the grid to a state read from an input file
      public void initLoadFile() {  
         // for simplicity the code of this method is not included in this handout,
         // see full code available in the lab…
         for(int y = 0; y < Life.SIZE; y++) {
            for(int x = 0; x < Life.SIZE; x++) {
               grid[x][y].setOn(false);  // first set all cells to off
            }
         }
         // now create a Scanner for the input file, and try to open file,
         // uses a file chooser as described in L&L Section 9.8
         Scanner scan = new Scanner("");
         try {
            JFileChooser chooser = new JFileChooser();            
            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
               System.out.println("No File Chosen");
            } else {
               File file = chooser.getSelectedFile();
               scan = new Scanner (file);
            }
         } catch (IOException ioe) {
            System.out.println("File not found");
         }
         // file read, scan is Scanner for file, process file line by line 
         int x, y = 9;  // place pattern read from file at position 10, 10
         while (scan.hasNext()) {
            y++; x = 10;
            String line = scan.next();  // read a line from the file
            for(int i = 0; i < line.length(); i++) {
               x++;  // test each char, if it is '0' then switch cell on
               if(line.charAt(i) == 'O') grid[x][y].setOn(true);
            }
         }        
         repaint();
      }

      // get each cell to calculate what its next state will be, then repaint grid
      public void step() {
         for(int y = 0; y < Life.SIZE; y++) {
            for(int x = 0; x < Life.SIZE; x++) {
               grid[x][y].calcNext(grid);
            }
         }
         repaint();
      }
       // called by repaint, calls a method on each cell to set next state and draw
      public void paint(Graphics g) {
         g.clearRect(0, 0, Life.SIZE * 10, Life.SIZE * 10);
         for(int y = 0; y < Life.SIZE; y++) {
            for(int x = 0; x < Life.SIZE; x++) {
               grid[x][y].setAndDrawNext( g );  // passes the Cell the Graphics object
            }
         }
      }

      // listener triggered by timer events (inner class of inner class GridPanel)
      class TimeListener implements ActionListener {
         public void actionPerformed(ActionEvent ae) {
            step();  // every timer event triggers a step of the grid
         }
      } // TimeListener     

   } // GridPanel  (end of second inner class)
   

}  // PrimaryPanel  (end of PrimaryPanel)
