

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Square extends Shape{
    public Square(){
        super();
        this.height=this.width;
    }

    public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        // select color for object
        g2d.setColor(color);
        //creating object
        g2d.drawRect(x,y,width,height);

        // select color for object
        g2d.setColor(color);
        //filling object
        g2d.fillRect(x,y,width,height);
        
    }//drawing the square;


}

