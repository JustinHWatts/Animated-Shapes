import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * ShapeIcon.java - An icon that contains a moveable shape.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public class ShapeIcon implements Icon
{
	private int width;
	private int height;
	private ArrayList<MoveableShape> shapes;
	
	/**
	 * Constructor for ShapeIcon class. Creates an array list
	 * of a particular type of shape.
	 * 
	 * @param shape type of shape being created
	 * @param width width of shape as an int
	 * @param height height of shape as an int
	 */
	public ShapeIcon(MoveableShape shape, int width, int height)
	{
		shapes = new ArrayList<MoveableShape>();
		this.width = width;
		this.height = height;
	}
   
	/**
	 * Getter for the width of the shape.
	 */
	public int getIconWidth()
	{
		return width;
	}

	/**
	 * Getter for the height of the shape.
	 */
	public int getIconHeight()
	{
		return height;
	}

	/**
	 * Displays the shapes within the array list.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < shapes.size(); i++)
			shapes.get(i).draw(g2);
	}
	
	/**
	 * Adds a shape to the array list.
	 * 
	 * @param shape the shape being added
	 */
	public void addShape(MoveableShape shape)
	{
		shapes.add(shape);
	}
	
	/**
	 * Animates the shapes to move from left to right one unit.
	 */
	public void moveShapes()
	{
		for (int i = 0; i < shapes.size(); i++)
			shapes.get(i).translate(1, 0);
	}
	
	/**
	 * Removes a shape from the array list.
	 */
	public void remove()
	{
		if(shapes.isEmpty() == false)
			shapes.remove(shapes.size() - 1);
	}
	
	/**
	 * Removes all shapes from the array list.
	 */
	public void removeAll()
	{
		shapes.removeAll(shapes);
	}
}