/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/** 
 * Calculator.java
 * 
 * Lab 19, COMP160,  2019
 * 
 * A calculator class - for SIMPLE calculations like 5 + 20 =
 * Large inputs will overload int, should convert to long 
 */

package lab25;


public class Calculator {  
  
  private int currentInput;          //current input
  private int previousInput;         // previous input
  private int result;            // result of calculation
  private String lastOperator = "";  // keeps track of the last operator entered
  
  
  /** New digit entered as integer value i - moves currentInput 1 decimal place to the left and adds i in "one's column" 
  @param i a digit */
  public void inDigit(int i) {
    currentInput = (currentInput * 10) + i;
  }
  
  
  /** Operator entered  + - or *   
  @param op an operator symbol, one of + - * */
  public void inOperator(String op){
      
      if(op.equals("=")){
          //special case which enter just one input and press equal
          if(lastOperator.equals("")){
              result=currentInput;
              return;
          }
          Calculate();
          lastOperator=op;
          currentInput=result;
      }else{
          
          //again special case lastoperaotor was "=" and press another operator
          if(lastOperator.equals("=")||lastOperator.equals("")){
              previousInput=currentInput;
              currentInput=0;
              lastOperator=op;
              
          }else{

              Calculate();
              previousInput=result;
              lastOperator=op;
              currentInput=0;
          }
          
          
      }

  }
  
  
   /** Equals operation sets result to previousInput + - or * currentInput (depending on lastOperator) */
  public void Calculate() {
    if (lastOperator.equals("+")) {
      result = previousInput + currentInput;
    } else if (lastOperator.equals("-")) { 
      result = previousInput - currentInput;
    } else if (lastOperator.equals("*"))  {
      result = previousInput * currentInput;
    } 
  }
  
  
  /** Clear operation */
  public void inClear() {
    currentInput = 0;
    previousInput = 0;
    result = 0;
    lastOperator = "";
  } 
  
  /** returns the current result 
  @return the current result as a string*/
  public String getResult() {  
    return Integer.toString(result);  //converts int to String
  }
  
  /** returns the previous input value
  @return the previous input as a string */
  public String getPreviousInput() {
    return Integer.toString(previousInput);
  }
  /** returns the current input value 
  @return the current input as a string */
  public String getCurrentInput() {
    return Integer.toString(currentInput);
  }
  
}

