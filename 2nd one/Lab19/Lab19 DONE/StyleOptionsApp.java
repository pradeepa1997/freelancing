
package Lab19;

//********************************************************************
//  StyleOptionsApp.java       adapted from Java Foundations
//
//  Demonstrates the use of check boxes.
//********************************************************************
import java.awt.GridLayout;
import javax.swing.*;
public class StyleOptionsApp {
    //-----------------------------------------------------------------
   //  Creates and presents the program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Style Options");
      frame.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
      
      StyleOptionsPanel panel = new StyleOptionsPanel();
      frame.getContentPane().add (panel);
      
      frame.setBounds(300, 300, 500, 500);
      GridLayout gl=new GridLayout(4,1);
      panel.setLayout(gl);
      frame.pack();
      frame.setVisible(true);
   }

}
