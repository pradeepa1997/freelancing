

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Circles extends Shape{
    public Circles(){
        super();
        this.height=this.width;
    }

    public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
         //creating object
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,height, width);
         // select color for object
        g2d.setColor(color); 
        //fill it using above color
        g2d.fill(circle);
    
    
        
    }//drawing the circle;


}