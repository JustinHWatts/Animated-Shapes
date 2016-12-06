import java.awt.*;
import java.awt.geom.*;

/**
 * BoatShape.java - A boat shape that can be moved around.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public class BoatShape implements MoveableShape
{
	private int x, secondX;
	private int y, secondY;
	private int width;
	private boolean firstCopy, secondCopy;
	
	/**
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
	 */
	public BoatShape(int _x, int _y, int _width)
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
	 * Moves the boat a set amount of units.
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
	 * Draws a boat to specifications.
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
			Arc2D.Double base
				= new Arc2D.Double(x, y + width / 6, 
						width - 2, width / 3, 180, 180, Arc2D.CHORD);
			g2.setPaint(Color.red);
			g2.fill(base);
			g2.setPaint(Color.black);
			
			double[] xCoordsFlag = new double[]
					{x + width / 2, x + width * 1 / 3, x + width / 2};
			double[] yCoordsFlag = new double[]
					{y + 2, y + 6, y + 10};
			
			Path2D.Double flag
				= new Path2D.Double();
			boolean isFirst = true;
			for (int i = 0; i < 3; i++)
			{
				if (isFirst)
				{
					flag.moveTo(xCoordsFlag[i], yCoordsFlag[i]);
					isFirst = false;
				}
				else
					flag.lineTo(xCoordsFlag[i], yCoordsFlag[i]);
			}
			
			// The bottom of the mast
			Point2D.Double r1
				= new Point2D.Double(x + width / 2, y + width / 3);
			// The top of the mast
			Point2D.Double r2
				= new Point2D.Double(x + width / 2, y + 2);
			// The middle of the flag
			Point2D.Double r3
				= new Point2D.Double(x + width * 1 / 3, y + 6);
			// The bottom of the flag
			Point2D.Double r4
				= new Point2D.Double(x + width / 2, y + 10);
			
			Line2D.Double mast
            	= new Line2D.Double(r1, r2);
			Line2D.Double flagTop
				= new Line2D.Double(r2, r3);
			Line2D.Double flagBottom
				= new Line2D.Double(r3, r4);
			
			g2.draw(base);
			g2.setPaint(Color.pink);
			g2.draw(mast);
			g2.setPaint(Color.black);
			g2.draw(flag);
			g2.setPaint(Color.magenta);
			g2.fill(flag);
			g2.setPaint(Color.black);
			g2.draw(flagTop);
			g2.draw(flagBottom);
		}
		
		if (secondCopy)
		{
			Arc2D.Double base2
				= new Arc2D.Double(x, y + width / 6, 
						width - 2, width / 3, 180, 180, Arc2D.CHORD);
			g2.setPaint(Color.red);
			g2.fill(base2);
			g2.setPaint(Color.black);
			
			double[] xCoordsFlag2 = new double[]
					{x + width / 2, x + width * 1 / 3, x + width / 2};
			double[] yCoordsFlag2 = new double[]
					{y + 2, y + 6, y + 10};
			
			Path2D.Double flag2
				= new Path2D.Double();
			boolean isFirst2 = true;
			for (int i = 0; i < 3; i++)
			{
				if (isFirst2)
				{
					flag2.moveTo(xCoordsFlag2[i], yCoordsFlag2[i]);
					isFirst2 = false;
				}
				else
					flag2.lineTo(xCoordsFlag2[i], yCoordsFlag2[i]);
			}
			
			// The bottom of the mast
			Point2D.Double r12
				= new Point2D.Double(x + width / 2, y + width / 3);
			// The top of the mast
			Point2D.Double r22
				= new Point2D.Double(x + width / 2, y + 2);
			// The middle of the flag
			Point2D.Double r32
				= new Point2D.Double(x + width * 1 / 3, y + 6);
			// The bottom of the flag
			Point2D.Double r42
				= new Point2D.Double(x + width / 2, y + 10);
			
			Line2D.Double mast2
            	= new Line2D.Double(r12, r22);
			Line2D.Double flagTop2
				= new Line2D.Double(r22, r32);
			Line2D.Double flagBottom2
				= new Line2D.Double(r32, r42);
			
			g2.draw(base2);
			g2.setPaint(Color.pink);
			g2.draw(mast2);
			g2.setPaint(Color.black);
			g2.draw(flag2);
			g2.setPaint(Color.magenta);
			g2.fill(flag2);
			g2.setPaint(Color.black);
			g2.draw(flagTop2);
			g2.draw(flagBottom2);
		}
	}
}