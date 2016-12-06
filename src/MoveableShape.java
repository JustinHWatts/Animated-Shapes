import java.awt.*;

/**
 * MoveableShape.java - An interface for a shape that may be moved around.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public interface MoveableShape
{
	/**
      Draws the shape.
      @param g2 the graphics context
	 */
	void draw(Graphics2D g2);
	
	/**
      Moves the shape by a given amount.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
	 */
	void translate(int dx, int dy);
}
