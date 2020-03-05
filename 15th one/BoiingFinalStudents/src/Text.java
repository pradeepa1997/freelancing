/**
 * Text.java
 * @version 2.0.0

 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 This will show string in the screen
 */

public class Text extends ClosedShape {
    //The max width of the string 
    private int maxWidth;
    // The string 
    private String text;
	

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
    public Text (int insertionTime, int x, int y, int vx, int vy, int maxWidth,String text, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.maxWidth = maxWidth;
        this.text=text;
    
    }
    
    /**
     * Method to convert a Text class detail to a string.
     */
    public String toString () {
    	String result = "This is a String\n";
    	result += super.toString ();
	result += "Its maxWidth is " + this.maxWidth + "\n"+"String is"+this.text+"\n";
    	return result;
    }
    
    /**
     * @param Resets the maxWidth.
     */
    public void setmaxWidth (int maxWidth) {
    	this.maxWidth = maxWidth;
    }
    
    /**
     * @return The maxWidth of the string.
     */
    public int getmaxWidth() {
    	return maxWidth;
    }

    /**
     * @return The maxwidth of the string as width
     */
 	public int getWidth() {
		return maxWidth;
	}

 	/**
 	 * @return The height of the string
 	 */
 	public int getHeight() {
		return maxWidth;
	}
    
    /**
     * Draw the Square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
            g.fillText( text,x, y,maxWidth);
           
    	} 
    	else {
    		g.strokeText( text,x, y,maxWidth);
	    }
    }
}
