


/**
 * Square.java
 * @version 2.0.0

 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Square's bounding Square.
 */

public class Square extends ClosedShape {
    //The Side of the Square
	private int side;
	

    /**
     * Creates a Square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the Square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the Square is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
    	this.side = side;
    
    }
    
    /**
     * Method to convert a Square to a string.
     */
    public String toString () {
    	String result = "This is a Square\n";
    	result += super.toString ();
	result += "Its side is " + this.side + "\n";
    	return result;
    }
    
    /**
     * @param Resets the side.
     */
    public void setSide (int side) {
    	this.side = side;
    }
    
    /**
     * @return The side of the Square.
     */
    public int getSide() {
    	return side;
    }

    /**
     * @return The width of the Square
     */
 	public int getWidth() {
		return side;
	}

 	/**
 	 * @return The height of the Square
 	 */
 	public int getHeight() {
		return side;
	}
    
    /**
     * Draw the Square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( x, y, side, side);
    	} 
    	else {
    		g.strokeRect( x, y, side, side );
	    }
    }
}
