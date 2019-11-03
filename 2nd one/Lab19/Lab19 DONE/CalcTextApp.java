/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab19;


/** 
 * CalcTextApp.java
 * 
 * Lab19, COMP160,  2019
 * 
 *  A simple text based application front end to Calculator
 */

public class CalcTextApp {  

 // create an instance of the Calculator class
 private static Calculator c = new Calculator();

 /** Main method - performs a simple calculation on the calculator */ 
 public static void main(String[] args) {
  // A simple calculation, 50 - 26 =  
  c.inDigit(5);
  c.inDigit(0);
  c.inOperator("-");
  c.inDigit(2);
  c.inDigit(6);
  c.inEquals();
  System.out.println( "50 - 26 = " + c.getResult()); 
  c.inClear();
  
 } 

}  

