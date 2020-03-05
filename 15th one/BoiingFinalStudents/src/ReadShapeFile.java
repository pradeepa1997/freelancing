/*

 * This class reads a shape file. 
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author ME
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.
	
	// Method for create a Circle shape 
	private static ClosedShape createCircle(String data[]){

		int x=Integer.parseInt(data[1]);
		int y=Integer.parseInt(data[2]);
		int vx=Integer.parseInt(data[3]);
		int vy=Integer.parseInt(data[4]);
		int diameter=Integer.parseInt(data[6]);
		int r=Integer.parseInt(data[7]);
		int g=Integer.parseInt(data[8]);
		int b=Integer.parseInt(data[9]);
		int insertionTime=Integer.parseInt(data[10]);
		Color color=Color.rgb(r, g, b);
		boolean isFilled;
		if(data[5].equals("true")){
			isFilled=true;
		}else{
			isFilled=false;
		}
		Circle newShape=new Circle(insertionTime,x,y,vx,vy,diameter,color,isFilled);
		return newShape;
	}

	// Method for create a Oval shape
	private static ClosedShape createOval(String data[]){
		int x=Integer.parseInt(data[1]);
		int y=Integer.parseInt(data[2]);
		int vx=Integer.parseInt(data[3]);
		int vy=Integer.parseInt(data[4]);
		int width=Integer.parseInt(data[6]);
		int height=Integer.parseInt(data[7]);
		int r=Integer.parseInt(data[8]);
		int g=Integer.parseInt(data[9]);
		int b=Integer.parseInt(data[10]);
		int insertionTime=Integer.parseInt(data[11]);
		Color color=Color.rgb(r, g, b);
		boolean isFilled;
		if(data[5].equals("true")){
			isFilled=true;
		}else{
			isFilled=false;
		}
		Oval newShape=new Oval(insertionTime,x,y,vx,vy,width,height,color,isFilled);
		return newShape;
	}

	// Method for create a Square shape
	private static ClosedShape createSquare(String data[]){
		int x=Integer.parseInt(data[1]);
		int y=Integer.parseInt(data[2]);
		int vx=Integer.parseInt(data[3]);
		int vy=Integer.parseInt(data[4]);
		int side=Integer.parseInt(data[6]);
		int r=Integer.parseInt(data[7]);
		int g=Integer.parseInt(data[8]);
		int b=Integer.parseInt(data[9]);
		int insertionTime=Integer.parseInt(data[10]);
		Color color=Color.rgb(r, g, b);
		boolean isFilled;
		if(data[5].equals("true")){
			isFilled=true;
		}else{
			isFilled=false;
		}
		Square newShape=new Square(insertionTime,x,y,vx,vy,side,color,isFilled);
		return newShape;
	}

	// Method for create a Rect shape
	private static ClosedShape createRect(String data[]){
		int x=Integer.parseInt(data[1]);
		int y=Integer.parseInt(data[2]);
		int vx=Integer.parseInt(data[3]);
		int vy=Integer.parseInt(data[4]);
		int width=Integer.parseInt(data[6]);
		int height=Integer.parseInt(data[7]);
		int r=Integer.parseInt(data[8]);
		int g=Integer.parseInt(data[9]);
		int b=Integer.parseInt(data[10]);
		int insertionTime=Integer.parseInt(data[11]);
		Color color=Color.rgb(r, g, b);
		boolean isFilled;
		if(data[5].equals("true")){
			isFilled=true;
		}else{
			isFilled=false;
		}
		Rect newShape=new Rect(insertionTime,x,y,vx,vy,width,height,color,isFilled);
		return newShape;
	}
	// Method for create a text shape
	private static ClosedShape createText(String data[]){
		int x=Integer.parseInt(data[1]);
		int y=Integer.parseInt(data[2]);
		int vx=Integer.parseInt(data[3]);
		int vy=Integer.parseInt(data[4]);
		int maxWidth=Integer.parseInt(data[6]);
		String text=data[7];
		int r=Integer.parseInt(data[8]);
		int g=Integer.parseInt(data[9]);
		int b=Integer.parseInt(data[10]);
		int insertionTime=Integer.parseInt(data[11]);
		Color color=Color.rgb(r, g, b);
		boolean isFilled;
		if(data[5].equals("true")){
			isFilled=true;
		}else{
			isFilled=false;
		}
		Text newShape=new Text(insertionTime,x,y,vx,vy,maxWidth,text,color,isFilled);
		return newShape;
	}

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue
		while (in.hasNextLine()) {
			String temp=in.nextLine();
			String data[]=temp.split(" ");
			ClosedShape newShape;
			if(data[0].equals("circle")){
				newShape=createCircle(data);
			}else if(data[0].equals("oval")){
				newShape=createOval(data);
			}else if(data[0].equals("rect")){
				newShape=createRect(data);
			}else if(data[0].equals("square")){
				newShape=createSquare(data);
			}else if(data[0].equals("text")){
				newShape=createText(data);
			}else{
				continue;
			}
			shapeQueue.enqueue(newShape);
			
		}
		shapeQueue.print();
		in.close();
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		try {
			// HINT: You might want to open a file here.
			File input=new File(filename);
			Scanner in = new Scanner(input);
			return ReadShapeFile.readDataFile(in);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	    return null;
	}
	// public static void main(String[] args) {
	// 	readDataFile("ExampleShapesStill.txt");
	// }
}
