import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * AnimationWindow.java - Sets up the window to display the animated shapes for
 * the MultiShapeTest program. Handles the timer, placement, and size of the
 * various shapes.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public class AnimationWindow
{
	private static final int ICON_WIDTH = 500;
	private static final int ICON_HEIGHT = 400;
	private static final int BOAT_WIDTH = 100;
	private static final int PLANE_WIDTH = 100;
	private static final int CLOCK_WIDTH = 100;
	
	private JFrame frame;
	private JButton hide, exit;
	private JPanel buttonPanel;
	private MoveableShape planeShape, boatShape, clockShape;
	private ShapeIcon planeIcon, boatIcon, clockIcon;
	private JLabel planeLabel, boatLabel, clockLabel;
	private int x, y;
	private Timer t;
	
	/**
	 * Constructor for the AnimationWindow class. Sets up the elements of
	 * the animation window as well as the timer, placement, and size of
	 * the objects being animated.
	 */
	public AnimationWindow()
	{
		this.frame = new JFrame("Animation");
		frame.setLayout(new BorderLayout());
		
		this.hide = new JButton("Hide");
		this.exit = new JButton("Exit");
		
		this.buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		this.planeShape = new PlaneShape(0, 0, PLANE_WIDTH);
		this.boatShape = new BoatShape(0, 0, PLANE_WIDTH);
		this.clockShape = new ClockShape(0, 0, PLANE_WIDTH);
		
		this.planeIcon = new ShapeIcon(planeShape, ICON_WIDTH, ICON_HEIGHT);
		this.boatIcon = new ShapeIcon(boatShape, ICON_WIDTH, ICON_HEIGHT);
		this.clockIcon = new ShapeIcon(clockShape, ICON_WIDTH, ICON_HEIGHT);
		
		this.planeLabel = new JLabel(planeIcon);
		this.boatLabel = new JLabel(boatIcon);
		this.clockLabel = new JLabel(clockIcon);
		
		this.x = 0;
		this.y = 0;
		
		
		hide.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for hide button to hide and pause
			 * the animation window.
			 */
			public void actionPerformed(ActionEvent event)
			{
				frame.setVisible(false);
				t.stop();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for exit button to exit the
			 * animation window and stop any objects currently
			 * being animated.
			 */
			public void actionPerformed(ActionEvent event)
			{
				frame.dispose();
				planeIcon.removeAll();
				boatIcon.removeAll();
				clockIcon.removeAll();
			}
		});
		
		final int DELAY = 10;
		// Milliseconds between timer ticks
		this.t = new Timer(DELAY, new
			ActionListener()
         	{
				/**
				 * Sets action listener for timer to move the shapes
				 * across the window.
				 */
				public void actionPerformed(ActionEvent event)
				{
					planeIcon.moveShapes();
					planeLabel.repaint();
					boatIcon.moveShapes();
					boatLabel.repaint();
					clockIcon.moveShapes();
					clockLabel.repaint();
				}
         	});
	}
	
	/**
	 * Sets the animation window as visible and creates a new window
	 * if one has not already been created and hidden.
	 */
	public void makeVisible()
	{
		if(!frame.isVisible())
		{
			buttonPanel.add(hide);
			buttonPanel.add(exit);
			
			frame.setSize(500, 500);
			frame.add(buttonPanel, BorderLayout.SOUTH);
			frame.setResizable(false);
			frame.setVisible(true);
			
			t.start();
		}
	}
	
	/**
	 * Sends instructions to ShapeIcon class to create and place
	 * a new airplane in the window.
	 */
	public void addAirplane()
	{
		x = (int)(Math.random() * 300);
		y = (int)(Math.random() * 300);
		
		planeIcon.addShape(new PlaneShape(x, y, PLANE_WIDTH));
		planeLabel.setBounds(0, 0, ICON_WIDTH, ICON_HEIGHT);
		
		frame.add(planeLabel, BorderLayout.CENTER);
		if(!frame.isVisible())
			makeVisible();
	}
	
	/**
	 * Sends instructions to ShapeIcon class to create and place
	 * a new boat in the window.
	 */
	public void addBoat()
	{
		x = (int)(Math.random() * 300);
		y = (int)(Math.random() * 300);
		
		boatIcon.addShape(new BoatShape(x, y, BOAT_WIDTH));
		boatLabel.setBounds(0, 0, ICON_WIDTH, ICON_HEIGHT);
		
		frame.add(boatLabel, BorderLayout.CENTER);
		if(!frame.isVisible())
			makeVisible();
	}
	
	/**
	 * Sends instructions to ShapeIcon class to create and place
	 * a new clock in the window.
	 */
	public void addClock()
	{
		x = (int)(Math.random() * 300);
		y = (int)(Math.random() * 300);
		
		clockIcon.addShape(new ClockShape(x, y, CLOCK_WIDTH));
		clockLabel.setBounds(0, 0, ICON_WIDTH, ICON_HEIGHT);
		
		frame.add(clockLabel, BorderLayout.CENTER);
		if(!frame.isVisible())
			makeVisible();
	}
	
	/**
	 * Sends instructions to ShapeIcon class to remove the latest
	 * airplane from the window.
	 */
	public void removeAirplane()
	{
		planeIcon.remove();
	}
	
	/**
	 * Sends instructions to ShapeIcon class to remove the latest
	 * boat from the window.
	 */
	public void removeBoat()
	{
		boatIcon.remove();
	}
	
	/**
	 * Sends instructions to ShapeIcon class to remove the latest
	 * clock from the window.
	 */
	public void removeClock()
	{
		clockIcon.remove();
	}
}