package shape;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ShapePanel extends JPanel{
    Shape array []= new Shape[20];
    int count =0 ;
    JPanel ControlPanel = new JPanel();
    JTextField showNum = new JTextField(2);
    JLabel countLabel =new JLabel("count");
    JPanel drawPanel = new drawPanel();
    JLabel whichbutton = new JLabel();//to know wich button clicked 
    JButton[] buttonlist = new JButton[7];
    //JButton stop = new JButton("stop");
    Timer timer;
    private final int DELAY =10;
    int count1=0;//this is for to move function when moving to keeep moving the shape.
    public ShapePanel(){
        //create 7 Jbuttons
        buttonlist[0]=new JButton("circle");
        buttonlist[1]=new JButton("square");
        buttonlist[2]=new JButton("oval");
        buttonlist[3]=new JButton("smiley");
        buttonlist[4]=new JButton("swirl");
        buttonlist[5]=new JButton("start");
        buttonlist[6]=new JButton("stop");

        for(int c=0; c<20;c++){
            array[c]=null;
        }//making the array to nulll
                    
        
        this.setSize(500,400);
              
		this.setBackground(Color.white);
		ControlPanel.setPreferredSize(new Dimension(100,400));
		ControlPanel.setBackground(Color.white); 
        
        // Button array
        for(int i=0;i<7;i++){
          ControlPanel.add(buttonlist[i]);
        }
        ControlPanel.add(countLabel);
        ControlPanel.add(showNum);//making the controlpanel
                 
                 
        this.add(ControlPanel);
                 
                 
                 
        ButtonListener buttonlistner = new ButtonListener();
        timer = new Timer(DELAY,buttonlistner);
       
        
        //BUtton array
        for(int i=0;i<7;i++){
            buttonlist[i].addActionListener(buttonlistner);
        }
        this.add(drawPanel);
    }
            
    private class ButtonListener implements ActionListener {
            
         
		public void actionPerformed (ActionEvent event) {
                  
                
            if(event.getSource()==timer){

                whichbutton.setText("move");     
                               
                            
            }else{
                if(event.getSource()==buttonlist[0]){
                    whichbutton.setText("circle");
                }else if(event.getSource()==buttonlist[1]){
                    whichbutton.setText("square");
                }else if(event.getSource()==buttonlist[2]){
                    whichbutton.setText("oval");
                }else if(event.getSource()==buttonlist[3]){
                    whichbutton.setText("smiley");
                }else if(event.getSource()==buttonlist[4]){
                    whichbutton.setText("swirl");
                }else if(event.getSource()==buttonlist[5]){
                    whichbutton.setText("add start button");
                    timer.start();
                }else if(event.getSource()==buttonlist[6]){

                    whichbutton.setText("stop button");
                    timer.stop();
                }else{
                        
                    //whichbutton.setText("add shape button");
                }
            }
                        
            repaint();
        }
		
                
	}//get the button click
        
        
    private class drawPanel extends JPanel{
             
                
	
		public drawPanel() {
			this.setPreferredSize(new Dimension(400,400));
                       
		}
                
        protected void paintComponent(Graphics g) {
          
            super.paintComponent(g);
            if(whichbutton.getText().equals(new String("circle"))){
                if(count<20){
                    array[count]=new Circle();
                    count++;
                    whichbutton.setText("");
                         
                           
                }
            }else if(whichbutton.getText().equals(new String("oval"))){
                if(count<20){
                    array[count]=new Oval();
                    count++;
                    whichbutton.setText("");
                         
                           
                }

            }else if(whichbutton.getText().equals(new String("square"))){
                if(count<20){
                    array[count]=new Square();
                    count++;
                    whichbutton.setText("");
                         
                           
                }

            }else if(whichbutton.getText().equals(new String("swirl"))){
                if(count<20){
                    array[count]=new Swirl();
                    count++;
                    whichbutton.setText("");
                         
                           
                }

            }else if(whichbutton.getText().equals(new String("smiley"))){
                if(count<20){
                    array[count]=new Smiley();
                    count++;
                    whichbutton.setText("");
                
                }

            }
            //after a button click new shape created and count increasing also storde inthe array
            if(count<21){
                for(int t=0 ; t <count;t++){
			        array[t].display(g);
                    showNum.setText(""+(t+1));
                }// showing the stored shapes 
                        
                if(whichbutton.getText().equals(new String("move"))){
                    if(count1<count){
                        array[count1].move();
                        count1++;
                    }
                    if(count1==count){
                        count1=0;// if count == count and to keep running again assign 0 to
                        //coutn 1 then we can use keep moving the shapes
                    }
                }
            }
		}
	}
}
