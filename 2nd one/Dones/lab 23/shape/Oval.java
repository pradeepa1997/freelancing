package shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Oval extends Shape{
    public Oval(){
        super();
        this.height=4*this.width;
    }

    public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double oval = new Ellipse2D.Double(x,y,width,height);
        g2d.setColor(color); 
        g2d.fill(oval);
        
    }//draving the circle;


}