/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab25;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

public class CalculatorGUIPanel extends JFrame {
 
  // variable for fields are created here
  
  JButton b1;
  JButton b2;
  JButton b3;
  JButton b4;
  JButton b5;
  JButton b6;
  JButton b7;
  JButton b8;
  JButton b9;
  JButton b10;
  JButton b0;
  JButton multiply;
  JButton plus;
  JButton minus;
  JButton clear;
  JButton equal;
  JTextField show;
  JLabel pressButton;
 
  // make a reference of Calculator class
  
  Calculator calc;
  
  // make reference of scanner class
  
  Scanner scan ;
  
  
  public CalculatorGUIPanel() {
    //Creating calculator object

    calc=new Calculator();
    
    // fields are initialized here  
      
    b1=new JButton("1");
    b2=new JButton("2");
    b3=new JButton("3");
    b4=new JButton("4");
    b5=new JButton("5");
    b6=new JButton("6");
    b7=new JButton("7");
    b8=new JButton("8");
    b9=new JButton("9");
    b10=new JButton("10");
    b0=new JButton("0");
    multiply=new JButton("*");
    plus=new JButton("+");
    minus=new JButton("-");
    clear=new JButton("C");
    equal=new JButton("=");
    show=new JTextField(10);
    pressButton=new JLabel("Press a button");
    
    
    // layour of frame is set to null here
    
    setLayout(null);
    
    // fields are added to the frame
    
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    add(b7);
    add(b8);
    add(b9);
    add(b10);
    add(b0);
    add(multiply);
    add(plus);
    add(minus);
    add(clear);
    add(equal);
    add(pressButton);
    add(show);
    
    
    // Bounds are set here for different fields
    
    
    b1.setBounds(10, 35, 50, 50);
    b2.setBounds(70, 35, 50, 50);
    b3.setBounds(130, 35, 50, 50);
    b4.setBounds(10, 95, 50, 50);
    b5.setBounds(70, 95, 50, 50);
    b6.setBounds(130, 95, 50, 50);
    b7.setBounds(10, 155, 50, 50);
    b8.setBounds(70, 155, 50, 50);
    b9.setBounds(130, 155, 50, 50);
    clear.setBounds(10, 215, 50, 50);
    b0.setBounds(70, 215, 50, 50);
    equal.setBounds(130, 215, 50, 50);
    plus.setBounds(10, 275, 50, 50);
    multiply.setBounds(70, 275, 50, 50);
    minus.setBounds(130, 275, 50, 50);
    pressButton.setBounds(10, 10, 500,25);
    show.setBounds(10, 335, 170, 25);
    
    
    // variable of ButtonListener for button events 
    
    ButtonListener l=new ButtonListener();
    
    
    // actionlistener for buttons is set here
    
    
    b1.addActionListener(l);
    b2.addActionListener(l);
    b3.addActionListener(l);
    b4.addActionListener(l);
    b5.addActionListener(l);
    b6.addActionListener(l);
    b7.addActionListener(l);
    b8.addActionListener(l);
    b9.addActionListener(l);
    b10.addActionListener(l);
    b0.addActionListener(l);
    minus.addActionListener(l);
    plus.addActionListener(l);
    multiply.addActionListener(l);
    clear.addActionListener(l);
    equal.addActionListener(l);
    
  }
  
  
  /** represents a listener for button presses */
  private class ButtonListener implements ActionListener{
    
    /** what to do when a button has been pressed */
    public void actionPerformed(ActionEvent aE) {
        JButton whichButton = (JButton) aE.getSource();
        
        // this code shows which button is clicked and corresponging operation has been done
        
        if("+".equals(whichButton.getText()))
        {
            
            calc.inOperator("+");
            show.setText(calc.getResult());
           
        }
        else  if("*".equals(whichButton.getText()))
        {
            calc.inOperator("*");
            show.setText(calc.getResult());
        }
        else  if("-".equals(whichButton.getText()))
        {
            calc.inOperator("-");
            show.setText(calc.getResult());
        }
        else if("C".equals(whichButton.getText()))
        {
            
            calc.inClear();
            show.setText(calc.getResult());
        }
        
        else if("=".equals(whichButton.getText()))
        {
            calc.inOperator("=");
            show.setText(calc.getResult());
        }
        else
        {
            int i=0;
            scan = new Scanner(whichButton.getText());
            i = scan.nextInt();
            calc.inDigit(i);
            if(!calc.getResult().equals("0")){  
                show.setText(calc.getResult());
            }else{
                show.setText(calc.getCurrentInput());
            }
            
            
            
        }
      
    }
  }
  public static void main(String args[])
  {
      
       // Frame is created here and its properties are set here
      
      
       CalculatorGUIPanel frame=new CalculatorGUIPanel();
       frame.setBounds(400, 100, 200, 420);
       frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setResizable(false);
      
  }
  
} 


