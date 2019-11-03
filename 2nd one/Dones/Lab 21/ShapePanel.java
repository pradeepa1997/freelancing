



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShapePanel extends JPanel{
    Shape array []= new Shape[20];
    int count =0 ;
    JPanel ControlPanel = new JPanel();
    JButton addShape = new JButton("add shape");
    JTextField showNum = new JTextField(2);
    JLabel countLabel =new JLabel("count");
    JPanel drawPanel = new drawPanel();
    JLabel true_or_not = new JLabel();
    
    public ShapePanel(){
        
                this.setSize(500,400);
		this.setBackground(Color.white);
		ControlPanel.setPreferredSize(new Dimension(100,400));
		ControlPanel.setBackground(Color.white); 
                 ControlPanel.add(addShape);
                 ControlPanel.add(countLabel);
                 ControlPanel.add(showNum);
                 this.add(ControlPanel);
                 
                 ButtonListener buttonlistner = new ButtonListener();
                 addShape.addActionListener(buttonlistner);
                 this.add(drawPanel);
    }
            
    	private class ButtonListener implements ActionListener {
            
         
		public void actionPerformed (ActionEvent event) {
                         true_or_not.setText("click");
			repaint();
		}
                
	}//get the button click
        
        
        private class drawPanel extends JPanel  {
             
                
		
		public drawPanel() {
			this.setPreferredSize(new Dimension(400,400));
                       
		}
                
                protected void paintComponent(Graphics g) {
          
                    super.paintComponent(g);
                    if(true_or_not.getText().equals(new String("click"))){
                         if(count<20){
                         array[count]=new Shape();
                         count++;
                         }
                       
                     }//after a button click new shape created and count increasing also storde inthe array
                     if(count<21){
                        for(int t=0 ; t <count;t++){
			array[t].display(g);
                        showNum.setText(""+(t+1));
                    }// showing the stored shapes 

                }
			
	     }
	}
        
        
    
}
