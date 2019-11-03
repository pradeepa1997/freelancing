package shape;

import javax.swing.JFrame;
/*
lab 21

shapes 1 ; building the structure

*/
public class ShapeApp {
    public static void main(String[] args) {
		
	    JFrame frame = new JFrame();
	    frame.add(new ShapePanel());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(20,20, 650,480);
        frame.setTitle("lab 21");
		frame.setVisible(true);
		frame.setResizable(false);
	}
    
}
