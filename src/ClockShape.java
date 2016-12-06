import java.awt.*;
import java.awt.geom.*;

/**
 * ClockShape.java - A clock shape that can be moved around.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public class ClockShape implements MoveableShape
{
	private int x, secondX;
	private int y, secondY;
	private int width;
	private boolean firstCopy, secondCopy;
	
	/**
      Constructs a clock item.
      
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
	 */
	public ClockShape(int _x, int _y, int _width)
	{
		this.x = _x;
		this.y = _y;
		this.secondX = 0;
		this.secondY = _y;
		this.width = _width;
		
		firstCopy = true;
		secondCopy = false;
	}

	/**
	 * Moves the clock a set amount of units.
	 * 
	 * @param dx change in the x coordinate
     * @param dy change in the y coordinate
	 */
	public void translate(int dx, int dy)
	{
		x += dx;
		secondX += dx;
		y += dy;
		secondY += dy;
	}

	/**
	 * Draws a clock to specifications.
	 */
	public void draw(Graphics2D g2)
	{
		if(x == 325)
		{
			secondX = 0;
			secondCopy = true;
			
			if(x == 375)
			{
				firstCopy = false;
				x = -1;
			}
		}
		
		if(secondX == 325)
		{
			x = 0;
			firstCopy = true;
			
			if(secondX == 375)
			{
				secondCopy = false;
				secondX = -1;
			}
		}
		
		if (firstCopy)
		{
			Ellipse2D.Double outerClock
				= new Ellipse2D.Double(x, y, 
						width / 2, width / 2);
			g2.fill(outerClock);
			Ellipse2D.Double innerClock
				= new Ellipse2D.Double(x + 3, y + 3, 
						width * 4 / 9, width * 4 / 9);
			g2.setPaint(Color.white);
			g2.fill(innerClock);
			g2.setPaint(Color.black);
		
			// The middle of the clock
			Point2D.Double r1
				= new Point2D.Double(x + width / 4, y + width / 4);
			// The top of the hour hand
			Point2D.Double r2
				= new Point2D.Double(x + width * 6 / 15, y + width * 6 / 15);
			// The top of the minute hand
			Point2D.Double r3
				= new Point2D.Double(x + width * 2 / 9, y + width * 1 / 9);
		
			Line2D.Double hourHand
				= new Line2D.Double(r1, r2);
			Line2D.Double minuteHand
				= new Line2D.Double(r1, r3);
      
			g2.draw(outerClock);
			g2.draw(innerClock);
			g2.draw(hourHand);
			g2.setPaint(Color.magenta);
			g2.draw(minuteHand);
			g2.setPaint(Color.black);
		}
		
		if (secondCopy)
		{
			Ellipse2D.Double outerClock2
				= new Ellipse2D.Double(x, y, 
						width / 2, width / 2);
			g2.fill(outerClock2);
			Ellipse2D.Double innerClock2
				= new Ellipse2D.Double(x + 3, y + 3, 
						width * 4 / 9, width * 4 / 9);
			g2.setPaint(Color.white);
			g2.fill(innerClock2);
			g2.setPaint(Color.black);
		
			// The middle of the clock
			Point2D.Double r3
				= new Point2D.Double(x + width / 4, y + width / 4);
			// The top of the hour hand
			Point2D.Double r4
				= new Point2D.Double(x + width * 6 / 15, y + width * 6 / 15);
			// The top of the minute hand
			Point2D.Double r5
				= new Point2D.Double(x + width * 2 / 9, y + width * 1 / 9);
		
			Line2D.Double hourHand2
				= new Line2D.Double(r3, r4);
			Line2D.Double minuteHand2
				= new Line2D.Double(r3, r5);
      
			g2.draw(outerClock2);
			g2.draw(innerClock2);
			g2.draw(hourHand2);
			g2.setPaint(Color.magenta);
			g2.draw(minuteHand2);
			g2.setPaint(Color.black);
		}
	}
}