import java.awt.*;
import java.awt.geom.*;

/**
 * PlaneShape.java - A plane shape that can be moved around.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public class PlaneShape implements MoveableShape
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
	public PlaneShape(int _x, int _y, int _width)
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
	 * Moves the plane a set amount of units.
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
	 * Draws a plane to specifications.
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
			Arc2D.Double front
				= new Arc2D.Double(x + width / 2, y + width / 3, 
						width / 2, width / 5, 270, 180, Arc2D.OPEN);
			g2.setPaint(Color.white);
			g2.fill(front);
			g2.setPaint(Color.black);
			
			Arc2D.Double tail
				= new Arc2D.Double(x, y + width * 1 / 6, 
						width / 5, width / 3, 0, 180, Arc2D.OPEN);
			g2.setPaint(Color.blue);
			g2.fill(tail);
			g2.setPaint(Color.black);
			
			Arc2D.Double upperWing
				= new Arc2D.Double(x + width * 2 / 5, y + width * 1 / 5, 
						width / 5, width / 4, 0, 180, Arc2D.OPEN);
			Arc2D.Double lowerWing
				= new Arc2D.Double(x + width * 2 / 5, y + width * 1 / 5, 
						width / 5, width / 2, 180, 180, Arc2D.OPEN);
			g2.fill(upperWing);
			g2.fill(lowerWing);
			
			double[] xCoordsBody = new double[]
					{x + width * 3 / 4, x, x, x + width / 6,
							x + width * 3 / 4};
			double[] yCoordsBody = new double[]
					{y + width / 3, y + width * 1 / 3, y + width * 2 / 5, 
							y + width * 7 / 13, y + width * 7 / 13};
			double[] xCoordsTail = new double[]
					{x, x, x + width / 5};
			double[] yCoordsTail = new double[]
					{y + width * 1 / 3, y + width * 2 / 5, y + width / 3};
			
			Path2D.Double body
				= new Path2D.Double();
			boolean isFirst = true;
			for (int i = 0; i < 5; i++)
			{
				if (isFirst)
				{
					body.moveTo(xCoordsBody[i], yCoordsBody[i]);
					isFirst = false;
				}
				else
					body.lineTo(xCoordsBody[i], yCoordsBody[i]);
			}
			
			Path2D.Double tailExtension
				= new Path2D.Double();
			isFirst = true;
			for (int i = 0; i < 3; i++)
			{
				if (isFirst)
				{
					tailExtension.moveTo(xCoordsTail[i], yCoordsTail[i]);
					isFirst = false;
				}
				else
					tailExtension.lineTo(xCoordsTail[i], yCoordsTail[i]);
			}
			
			// The top right of the plane
			Point2D.Double r1
				= new Point2D.Double(x + width * 3 / 4, y + width / 3);
			// The top left of the plane
			Point2D.Double r2
				= new Point2D.Double(x + width / 5, y + width / 3);
			// The bottom right of the plane
			Point2D.Double r3
				= new Point2D.Double(x + width * 3 / 4, y + width * 7 / 13);
			// The bottom left of the plane
			Point2D.Double r4
				= new Point2D.Double(x + width / 6, y + width * 7 / 13);
			// The upper base of the tail
			Point2D.Double r5
				= new Point2D.Double(x, y + width * 1 / 3);
			// The lower base of the tail
			Point2D.Double r6
				= new Point2D.Double(x, y + width * 2 / 5);
			
			Line2D.Double top
				= new Line2D.Double(r1, r2);
			Line2D.Double bottom
				= new Line2D.Double(r3, r4);
			Line2D.Double tailExtensionLine
				= new Line2D.Double(r5, r6);
			Line2D.Double backEnd
				= new Line2D.Double(r6, r4);
			
			g2.draw(front);
			g2.draw(tail);
			g2.draw(upperWing);
			
			g2.draw(body);
			g2.setPaint(Color.white);
			g2.fill(body);
			g2.draw(tailExtension);
			g2.setPaint(Color.blue);
			g2.fill(tailExtension);
			g2.setPaint(Color.black);
			
			g2.draw(lowerWing);
			g2.fill(lowerWing);
			g2.draw(top);
			g2.draw(bottom);
			g2.draw(tailExtensionLine);
			g2.draw(backEnd);
		}
		
		if (secondCopy)
		{
			Arc2D.Double front2
				= new Arc2D.Double(x + width / 2, y + width / 3, 
						width / 2, width / 5, 270, 180, Arc2D.OPEN);
			g2.setPaint(Color.white);
			g2.fill(front2);
			g2.setPaint(Color.black);
			
			Arc2D.Double tail2
				= new Arc2D.Double(x, y + width * 1 / 6, 
						width / 5, width / 3, 0, 180, Arc2D.OPEN);
			g2.setPaint(Color.blue);
			g2.fill(tail2);
			g2.setPaint(Color.black);
			
			Arc2D.Double upperWing2
				= new Arc2D.Double(x + width * 2 / 5, y + width * 1 / 5, 
						width / 5, width / 4, 0, 180, Arc2D.OPEN);
			Arc2D.Double lowerWing2
				= new Arc2D.Double(x + width * 2 / 5, y + width * 1 / 5, 
						width / 5, width / 2, 180, 180, Arc2D.OPEN);
			g2.fill(upperWing2);
			g2.fill(lowerWing2);
			
			double[] xCoordsBody2 = new double[]
					{x + width * 3 / 4, x, x, x + width / 6,
							x + width * 3 / 4};
			double[] yCoordsBody2 = new double[]
					{y + width / 3, y + width * 1 / 3, y + width * 2 / 5, 
							y + width * 7 / 13, y + width * 7 / 13};
			double[] xCoordsTail2 = new double[]
					{x, x, x + width / 5};
			double[] yCoordsTail2 = new double[]
					{y + width * 1 / 3, y + width * 2 / 5, y + width / 3};
			
			Path2D.Double body2
				= new Path2D.Double();
			boolean isFirst2 = true;
			for (int i = 0; i < 5; i++)
			{
				if (isFirst2)
				{
					body2.moveTo(xCoordsBody2[i], yCoordsBody2[i]);
					isFirst2 = false;
				}
				else
					body2.lineTo(xCoordsBody2[i], yCoordsBody2[i]);
			}
			
			Path2D.Double tailExtension2
				= new Path2D.Double();
			isFirst2 = true;
			for (int i = 0; i < 3; i++)
			{
				if (isFirst2)
				{
					tailExtension2.moveTo(xCoordsTail2[i], yCoordsTail2[i]);
					isFirst2 = false;
				}
				else
					tailExtension2.lineTo(xCoordsTail2[i], yCoordsTail2[i]);
			}
			
			// The top right of the plane
			Point2D.Double r12
				= new Point2D.Double(x + width * 3 / 4, y + width / 3);
			// The top left of the plane
			Point2D.Double r22
				= new Point2D.Double(x + width / 5, y + width / 3);
			// The bottom right of the plane
			Point2D.Double r32
				= new Point2D.Double(x + width * 3 / 4, y + width * 7 / 13);
			// The bottom left of the plane
			Point2D.Double r42
				= new Point2D.Double(x + width / 6, y + width * 7 / 13);
			// The upper base of the tail
			Point2D.Double r52
				= new Point2D.Double(x, y + width * 1 / 3);
			// The lower base of the tail
			Point2D.Double r62
				= new Point2D.Double(x, y + width * 2 / 5);
			
			Line2D.Double top2
				= new Line2D.Double(r12, r22);
			Line2D.Double bottom2
				= new Line2D.Double(r32, r42);
			Line2D.Double tailExtensionLine2
				= new Line2D.Double(r52, r62);
			Line2D.Double backEnd2
				= new Line2D.Double(r62, r42);
			
			g2.draw(front2);
			g2.draw(tail2);
			g2.draw(upperWing2);
			
			g2.draw(body2);
			g2.setPaint(Color.white);
			g2.fill(body2);
			g2.draw(tailExtension2);
			g2.setPaint(Color.blue);
			g2.fill(tailExtension2);
			g2.setPaint(Color.black);
			
			g2.draw(lowerWing2);
			g2.fill(lowerWing2);
			g2.draw(top2);
			g2.draw(bottom2);
			g2.draw(tailExtensionLine2);
			g2.draw(backEnd2);
		}
	}
}