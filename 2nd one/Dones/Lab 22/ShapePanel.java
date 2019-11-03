



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer; 

public class ShapePanel extends JPanel{
    Shape array []= new Shape[20];
    int count =0 ;
    JPanel ControlPanel = new JPanel();
    JButton addShape = new JButton("add shape");
    JTextField showNum = new JTextField(2);
    JLabel countLabel =new JLabel("count");
    JPanel drawPanel = new drawPanel();
    JLabel whichbutton = new JLabel();//to know wich button clicked 
    JButton start = new JButton("start");
    JButton stop = new JButton("stop");
    Timer timer;
    private final int DELAY =10;
    int count1=0;//this is for to move function when moving to keeep moving the shape.
    public ShapePanel(){
        
        for(int c=0; c<20;c++){
            array[c]=null;
        }//making the array tinulll
                    
        
        this.setSize(500,400);
              
		this.setBackground(Color.white);
		ControlPanel.setPreferredSize(new Dimension(100,400));
		ControlPanel.setBackground(Color.white); 
        ControlPanel.add(addShape);
        ControlPanel.add(start);
        ControlPanel.add(stop);
        ControlPanel.add(countLabel);
        ControlPanel.add(showNum);//making the controlpanel
                 
                 
        this.add(ControlPanel);
                 
                 
                 
        ButtonListener buttonlistner = new ButtonListener();
        timer = new Timer(DELAY,buttonlistner);
        addShape.addActionListener(buttonlistner);
        start.addActionListener(buttonlistner);
        stop.addActionListener(buttonlistner);//start and stops button
        this.add(drawPanel);
    }
            
    private class ButtonListener implements ActionListener {
            
         
		public void actionPerformed (ActionEvent event) {
                  
                
            if(event.getSource()==timer){

                whichbutton.setText("move");     
                               
                            
            }else{
                if(event.getSource()==stop){
                    whichbutton.setText("stop button");
                    timer.stop();
                }else if(event.getSource()== start){

                    whichbutton.setText("add start button");
                    timer.start();
                }else{
                        
                    whichbutton.setText("add shape button");
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
            if(whichbutton.getText().equals(new String("add shape button"))){
                if(count<20){
                    array[count]=new Shape();
                    count++;
                    whichbutton.setText("");
                         
                           
                }
            }//after a button click new shape created and count increasing also storde inthe array
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
