package just;

import javax.swing.JFrame;

public class TrafficLightApp {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
	    frame.add(new TrafficLightPanel());
	   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(20,20, 300,300);
	    frame.setVisible(true);
	}

}
