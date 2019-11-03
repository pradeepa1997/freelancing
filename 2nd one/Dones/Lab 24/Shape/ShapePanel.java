
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
//Exeption handerlling function
public class ShapePanel extends JPanel{
    static void validate(int count,int index)throws InvalidInputException{  
        if(count<index)  
         throw new InvalidInputException("not valid");    
    }  




   // Shape arraylist
    ArrayList<Shape> shapes=new ArrayList<Shape>();
    JPanel ControlPanel = new JPanel();
    JTextField showNum = new JTextField(2);
    JLabel countLabel =new JLabel("Remove which?");
    JLabel lastindex=new JLabel("Last shape index");
    JPanel drawPanel = new drawPanel();
    JLabel whichbutton = new JLabel();//to know wich button clicked 
    JButton[] buttonlist = new JButton[8];
    JTextField remove=new JTextField(5);
    //JButton stop = new JButton("stop");
    Timer timer;
    private final int DELAY =10;
    int count1=0;//this is for to move function when moving to keeep moving the shape.
    public ShapePanel(){
        //create 8 Jbuttons
        buttonlist[0]=new JButton("circle");
        buttonlist[1]=new JButton("square");
        buttonlist[2]=new JButton("oval");
        buttonlist[3]=new JButton("smiley");
        buttonlist[4]=new JButton("swirl");
        buttonlist[5]=new JButton("start");
        buttonlist[6]=new JButton("stop");
        buttonlist[7]=new JButton("remove");
        
        
        this.setSize(500,400);
              
		this.setBackground(Color.white);
		ControlPanel.setPreferredSize(new Dimension(100,400));
		ControlPanel.setBackground(Color.white); 
        
        // add Button arraylist to control panel
        for(int i=0;i<8;i++){
          ControlPanel.add(buttonlist[i]);
        }
        ControlPanel.add(countLabel);
        ControlPanel.add(remove);
        ControlPanel.add(lastindex);
        ControlPanel.add(showNum);//making the controlpanel
                 
                 
        this.add(ControlPanel);
                 
                 
                 
        ButtonListener buttonlistner = new ButtonListener();
        timer = new Timer(DELAY,buttonlistner);
       
        
        //BUtton arraylist
        for(int i=0;i<8;i++){
            buttonlist[i].addActionListener(buttonlistner);
        }
        this.add(drawPanel);
        
    }
            
    private class ButtonListener implements ActionListener {
            
         
		public void actionPerformed (ActionEvent event) {
                  
            //listning to events   
            if(event.getSource()==timer){

                whichbutton.setText("move");     
                               
            //Identifieng which button has click                
            }else{
                if(event.getSource()==buttonlist[0]){
                    //circle
                    whichbutton.setText("circle");
                }else if(event.getSource()==buttonlist[1]){
                    //sqaure
                    whichbutton.setText("square");
                }else if(event.getSource()==buttonlist[2]){
                    //oval
                    whichbutton.setText("oval");
                }else if(event.getSource()==buttonlist[3]){
                    //smiley
                    whichbutton.setText("smiley");
                }else if(event.getSource()==buttonlist[4]){
                    //swirl
                    whichbutton.setText("swirl");
                }else if(event.getSource()==buttonlist[5]){
                    //start
                    whichbutton.setText("add start button");
                    timer.start();
                }else if(event.getSource()==buttonlist[6]){
                    //stop
                    whichbutton.setText("stop button");
                    timer.stop();
                }else if(event.getSource()==buttonlist[7]){
                    //remove button
                    try{//to determine errors
                        String temp=remove.getText();
                        int index=Integer.parseInt(temp);
                        //custom erro function call
                        validate(shapes.size(), index);
                        shapes.remove(index);
                    }catch(NumberFormatException e){
                        System.out.println("This is a not a number");
                        remove.setText("");
                    }catch(Exception m){
                        System.out.println("This is a invalid index");
                        remove.setText("");
                    }
                }
            }
                        
            repaint();
        }
		
                
	}//get the button click
        
        
    private class drawPanel extends JPanel{
             
                
	
		public drawPanel() {
			this.setPreferredSize(new Dimension(400,400));
                       
		}
        //drawing graphic items(shape and panel)
        protected void paintComponent(Graphics g) {
          
            super.paintComponent(g);
            //this block will ditermine which shape and create it

            if(whichbutton.getText().equals(new String("circle"))){
    
                Shape cir=new Circles();
                shapes.add(cir);
                whichbutton.setText("");
                         
            }else if(whichbutton.getText().equals(new String("oval"))){

                // array[count]=new Oval();
                shapes.add(new Oval());
                whichbutton.setText("");
                         
            }else if(whichbutton.getText().equals(new String("square"))){

                //array[count]=new Square();
                shapes.add(new Square());
                whichbutton.setText("");

            }else if(whichbutton.getText().equals(new String("swirl"))){
    
                //array[count]=new Swirl();
                shapes.add(new Swirl());
                whichbutton.setText("");
                         
            }else if(whichbutton.getText().equals(new String("smiley"))){
                
                // array[count]=new Smiley();
                shapes.add(new Smiley());
                whichbutton.setText("");

            }
            //after a button click new shape created and count increasing also storde inthe arraylist
            for(int i=0;i<shapes.size();i++){
                shapes.get(i).display(g);
                shapes.get(i).showIndex(i,g);
                showNum.setText(""+(i+1));
                if(i==0){
                    showNum.setText("-1");
                }
            }// showing the stored shapes 
                        
            if(whichbutton.getText().equals(new String("move"))){
                if(count1<shapes.size()){
                    //array[count1].move();
                    shapes.get(count1).move();
                    count1++;
                }
                if(count1==shapes.size()){
                    count1=0;
                    // if count == count and to keep running again assign 0 to
                    //coutn 1 then we can use keep moving the shapes
                }
            }
        }
	}
}
