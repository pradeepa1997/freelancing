package shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Square extends Shape{
    public Square(){
        super();
        this.height=randomrange(10, 30);
    }

    public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        // Ellipse2D.Double oval = new Ellipse2D.Double(x,y,height, width);
        // g2d.setColor(color); 
        // g2d.fill(oval);
        g2d.setColor(color);
        g2d.drawRect(x,y,width,height);


        g2d.setColor(color);
        g2d.fillRect(x,y,width,height);
        
    }//draving the circle;


}

