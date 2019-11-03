package shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Circle extends Shape{
    public Circle(){
        super();
        this.height=this.width;
    }

    public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,height, width);
        g2d.setColor(color); 
        g2d.fill(circle);
    
        
    }//draving the circle;


}