


/**
 * Rect.java
 * @version 2.0.0

 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
/**
 *
 * Rect is an Rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 *  bounding rectangle
 */

public class Rect extends ClosedShape {
   //The width and height of the Rectangle (major and minor axis)
	private int width, height;
	

    /**
     * Creates a Rect.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the Rectangle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the Rectangle is filled with colour, false if opaque.
     */
    public Rect (int insertionTime, int x, int y, int vx, int vy, int width,int height, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.width= width;
        this.height=height;
    
    }
    
    /**
     * Method to convert a Rectangle to a string.
     */
    public String toString () {
    	String result = "This is a Rectangle\n";
    	result += super.toString ();
	    result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }
    
    /**
     * @param Resets the width.
     */
    public void setWidth (int width) {
    	this.width = width;
    }

    /**
     * @param Resets the height.
     */
    public void setHeight (int height) {
    	this.height = height;
    }
    
    
    /**
     * @return The width of the Rectangle
     */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the Rectangle
 	 */
 	public int getHeight() {
		return height;
	}
    
    /**
     * Draw the Rectangle on the screen.
     * @param g The graphics object of the scene component.
     */

    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( x, y, width, height);
    	} 
    	else {
    		g.strokeRect( x, y, width, height );
	    }
    }
}
