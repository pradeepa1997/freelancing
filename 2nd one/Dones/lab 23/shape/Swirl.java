/** Swirl.java
 * Lab 23, COMP160
 * draws a swirl - a shape drawn of 4 coloured circles clustered around a small black circle, with arc highlights
 */
package shape;

import java.awt.*;

public class Swirl extends Shape{
  Color shade;
  
  public Swirl(){
    height = 29; //overall height, for bouncing
    width = 29;  //for bouncing
    y = randomrange(0, 400 - height);
    x = randomrange(0, 400 - width);
    shade = new Color(randomrange(0,255),randomrange(0,255),randomrange(0,255));
  }
  
  /** sets the colour and draws the shape*/
  public void display(Graphics g){
    int w = 20; //width of 4 small ovals
    int h = 20; //height of 4 small ovals
    int centreX = x+15;
    int centreY = y+15;
    g.setColor(Color.black);
    g.fillOval(centreX-4, centreY-4,8,8);
    //draw 4 ovals
    g.setColor(shade);
    g.fillOval(centreX-w/2, y,w,h); //top
    g.fillOval(centreX-w/2, centreY-(h-15),w,h);//bottom
    g.fillOval(x,centreY-w/2,h,w);//left
    g.fillOval(centreX-(w-15),centreY-w/2,h,w);//right
    //if oval is dark, set colour to yellow for highlights
    if (shade.getRed() < 80 ||  shade.getGreen() < 80 || shade.getBlue() < 80) g.setColor(Color.yellow);
    else g.setColor(Color.black);
    //draw highlights
    g.fillOval(centreX-4, centreY-4,8,8);
    g.drawArc(centreX-w/2, y,w,h,20,200);//top
    g.drawArc(centreX-w/2, centreY-(h-15),w,h,200,200);//bottom
    g.drawArc(x,centreY-w/2,h,w,110,200);//left
    g.drawArc(centreX-(w-15),centreY-w/2,h,w,290,200);//right
  }
}