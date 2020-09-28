/**
 * This class creates a Plot object and defines several methods to measure the plot
 * @author MQuander
 *
 */
public class Plot {
	private int x, y;
	private int width, depth;
	/**
	 * No-arg constructor to set default values
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	/**
	 * Constructor to set values with parameters passed to it
	 * @param x Value of X coordinate for the plot
	 * @param y Value of Y coordinate for the plot
	 * @param width Value of the width for the plot
	 * @param depth Value of the depth for the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	/**
	 * Constructor takes a Property object and sets the objects values to it's measurements
	 * @param pr Property object
	 */
	public Plot(Property pr) {
		this.x = pr.getX(); 
		this.y = pr.getY(); 
		this.width = pr.getWidth(); 
		this.depth = pr.getDepth();
	}
	/**
	 * Constructor takes a Plot object and copies it's values
	 * @param pl Plot object
	 */
	public Plot(Plot pl) {
		this.x = pl.getX();
		this.y = pl.getY();
		this.width = pl.getWidth();
		this.depth = pl.getDepth();
	}
	/**
	 * Method takes a Plot object and tests if it overlaps any other objects in the array
	 * @param pl Plot object to add to the array
	 * @return true or false if added to array
	 */
	public boolean overlaps(Plot pl) {
		boolean returnValue = false;
		
		if(pl.getX() + pl.getWidth() > this.getX() && pl.getX() + pl.getWidth() <= this.getX() + this.getWidth() || pl.getX() >= this.getX() && pl.getX() < this.getX() + this.getWidth())
			
			if(pl.getY() + pl.getDepth() > this.getY() && pl.getY() + pl.getDepth() <= this.getY() + this.getDepth() || pl.getY() >= this.getY() && pl.getY() < this.getY() + this.getDepth())
		
				returnValue = true;
		
		
		/*
		if(((pl.getX() > this.getX()) && (pl.getX() < this.getX() + this.getWidth())) && (pl.getY() < this.getY() + this.getDepth()))
			 ((pl.getX() > this.getX()) && (pl.getX() < this.getX() + this.getWidth())) && ((pl.getY() > this.getY()) && (pl.getY() < this.getY() + this.getDepth()))
			returnValue = true; 
		*/
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Method takes a Plot object and tests if it is within the management company's plot
	 * @param pl Plot object to add to the array
	 * @return true or false if added to array
	 */
	public boolean encompasses(Plot pl) {
		boolean returnValue;
		// 	(0 + 1 <= 0 + 10) && (0 + 1 <= 0 + 10)				(0, 0, 10, 10) && (0,0, 1, 1)
		if((pl.getX() + pl.getWidth() <= this.getX() + this.getWidth()) && (pl.getY() + pl.getDepth() <= this.getY() + this.getDepth()))
			returnValue = true;
		else
			returnValue = false;
		
		return returnValue;
	}
	/**
	 * Set method to set the value of the X coordinate
	 * @param x X coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Set method to set the value of the Y coordinate
	 * @param y Y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Set method to set the value of the width
	 * @param width Width of plot
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * Set method to set the value of the depth
	 * @param depth Depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/**
	 * Get method to return x value
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Get method to return y value
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Get method to return width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Get method to return depth
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * Method to display the Plots info
	 * @return String
	 */
	public String toString() {
		return "X: " + getX() + "\nY: " + getY() + "\nWidth: " + 
				getWidth() + "\nDepth: " + getDepth();
	}
}
