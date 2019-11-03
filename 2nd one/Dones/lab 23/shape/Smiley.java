package shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

//import javafx.scene.paint.Color;

class Smiley extends Shape{
   Color yellow,black;
    public Smiley(){
        super();
        this.height=this.width=30;
        yellow=new Color(255,255,0);
        black=new Color(0,0,0);


    }

    public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        //drawing big circle
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,height, width);
        g2d.setColor(yellow);
        g2d.fill(circle);

        //Drawing two eyes
        //1st one
        g2d.setColor(black);
        g2d.drawOval(x, y, height,width);
        circle=new Ellipse2D.Double(x+7.0,y+8.0,4,4);
        //second one
        g2d.fill(circle);
        circle=new Ellipse2D.Double(x+20.0,y+8.0,4,4);
        g2d.fill(circle);
        g.drawArc(x+8,y+10,15,13,190,160);

    }//draving the Smile;


}