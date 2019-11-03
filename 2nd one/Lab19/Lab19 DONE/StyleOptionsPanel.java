/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab19;

//********************************************************************
//  StyleOptionsPanel.java      adapted from Java Foundations
//
//  Demonstrates the use of check boxes.
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StyleOptionsPanel extends JPanel
{
   private JLabel saying;
   private JRadioButton bold, italic,plain;
   private int style = Font.PLAIN;
   private String typeFace = "Helvetica";

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and some check boxes that
   //  control the style of the label's font.
   //-----------------------------------------------------------------
   public StyleOptionsPanel()
   {
      saying = new JLabel ("Say it with style!");
      saying.setFont (new Font (typeFace, style, 20));
      
      
      // checkboxes are initialized and properties are set here
      bold = new JRadioButton ("Bold");
      bold.setBackground (Color.cyan);
      italic = new JRadioButton ("Italic");
      italic.setBackground (Color.cyan);
      plain=new JRadioButton("Plain");
      plain.setBackground(Color.cyan);
      StyleListener listener = new StyleListener();
      bold.addItemListener (listener);
      italic.addItemListener (listener);
      plain.addItemListener(listener);
      
      // fields are to panel
      add (saying);
      add (bold);
      add (italic);
      add(plain);
      setBackground (Color.cyan);
      setPreferredSize (new Dimension(300, 300));
      
      // button group is created here and buttons are added
      ButtonGroup group=new ButtonGroup();
      group.add(bold);
      group.add(italic);
      group.add(plain);
      
   }

   //*****************************************************************
   //  Represents the listener for both check boxes.
   //*****************************************************************
   private class StyleListener implements ItemListener
   {
      //--------------------------------------------------------------
      //  Updates the style of the label font style.
      //--------------------------------------------------------------
      public void itemStateChanged (ItemEvent event)
      {
         style = Font.PLAIN;
         
         
         // perform action according to which button is selected
         
         
         if (bold.isSelected())
            style = Font.BOLD;

         if (italic.isSelected())
            style += Font.ITALIC;
         if(plain.isSelected())
            style += Font.PLAIN;

            saying.setFont (new Font (typeFace, style, 20));
      }
   }
}
