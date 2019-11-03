package shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public abstract class Shape {
     
    protected int x;//x ,y for location
    protected int y;
    protected int width;// this is for size
    protected int height;
    public Color color;
    protected int movex=370;
    protected int movey=200;
    protected int changefactor=0;
   
    public Shape(){
        this.x = randomrange(0,375);
        this.y= randomrange(0,375);
        this.width= randomrange(10, 30);
        this.color =new Color(randomrange(0, 255), randomrange(0, 255) ,randomrange(0, 255));
        
    }//all the measurmets created in randomly
     public int randomrange(int low,int hi){
        int value; 
        Random genarator = new Random();
        return genarator.nextInt(hi-low +1) +low;
    }//get random number
    
            
    public abstract void display(Graphics g);
    //drawing method .It is a abstract method.
    
    public void move(){
         
         //this is for my moving structure
         
        if(x==0){
            x=375;
            y=randomrange(0, 375);
            if(y<150){
                changefactor =1;
            }else{ 
                changefactor =0;
            }
        }else if(x==375){
             
            if(changefactor== 1){
                x=0;
                y=0;
            }else{
                x=0;
                y=370;
            }
             
        }else{ 
            x=0;
        }
    }
}
