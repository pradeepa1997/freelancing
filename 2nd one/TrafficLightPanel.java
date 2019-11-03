package just;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


 

public class TrafficLightPanel extends JPanel {
	
	JLabel lastPressedLabel = new JLabel();
	JButton red = new JButton();
	JButton amber = new JButton();
	JButton green = new JButton();
	JPanel buttonPanel = new JPanel();
	JPanel lightPanel = new LightPanel();
	
	
	public TrafficLightPanel() {
		
		this.setSize(200,300);
		this.setBackground(Color.blue);
		buttonPanel.setPreferredSize(new Dimension(80,290));
		buttonPanel.setBackground(Color.white);
		lastPressedLabel.setText("last pressed");
		red.setText("Red");
		amber.setText("Amber");
		green.setText("Green");
		buttonPanel.add(red);
		buttonPanel.add(amber);
		buttonPanel.add(green);
		buttonPanel.add(lastPressedLabel);
		this.add(buttonPanel);
		ButtonListener bl = new ButtonListener();
		red.addActionListener(bl);
		amber.addActionListener(bl);
		green.addActionListener(bl);
		this.add(lightPanel);
	}
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			if(event.getSource() == red) {
				lastPressedLabel.setText("Red");
				buttonPanel.setBackground(Color.red);
			}
			
			else if(event.getSource() == amber) {
				lastPressedLabel.setText("Amber");
				buttonPanel.setBackground(Color.orange);
			}
			else if(event.getSource() == green) {
				lastPressedLabel.setText("Green");
				buttonPanel.setBackground(Color.green);
			}
			repaint();
		}
	}
	
	private class LightPanel extends JPanel {
		
		public LightPanel() {
			this.setPreferredSize(new Dimension(80,290));
			
		}
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillOval(20, 30, 40, 40);
			g.fillOval(20, 80, 40, 40);
			g.fillOval(20, 130, 40, 40);
			if(lastPressedLabel.getText().equals(new String("Red"))) { //you gotta understand this!~
				g.setColor(Color.red);
				g.fillOval(20, 30, 40, 40);
			}else if (lastPressedLabel.getText() == "Amber") {
				g.setColor(Color.orange);
				g.fillOval(20, 80, 40, 40);
			}else {
				g.setColor(Color.green);
				g.fillOval(20, 130, 40, 40);
			}
			
		}
	}
	



}
