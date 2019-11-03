


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Shape {
     
    private int x;//x ,y for location
    private int y;
    private int width;// this is for size
    private int height;
    private Color color;
   
    public Shape(){
        this.x = randomrange(0,375);
        this.y= randomrange(0,375);
        this.width= randomrange(10, 30);
        this.height=this.width;
        this.color =new Color(randomrange(0, 255), randomrange(0, 255) ,randomrange(0, 255));
        
    }//all the measurmets created in randomly
     public int randomrange(int low,int hi){
        int value; 
        Random genarator = new Random();
        return genarator.nextInt(hi-low +1) +low;
    }//get random number
    
            
     public void display(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y,height, width);
        g2d.setColor(color); 
        g2d.fill(circle);
        
    }//draving the circle;
    
}
