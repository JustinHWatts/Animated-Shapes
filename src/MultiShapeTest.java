import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * MultiShapeTest.java - Driver to test the Plane, Boat, and Clock
 * Animation Program. A user selects one to three of the aforementioned
 * objects to project on a window where the objects will move from
 * left to right, wrapping upon hitting the right edge of the window.
 *
 * @author Justin Watts
 * @version 10/16/15
 */
public class MultiShapeTest
{
	/**
	 * Main method of MultiShapeTest program. Sets up main window.
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Icon Animator");
		frame.setLayout(new BorderLayout());
		
		Box box = Box.createVerticalBox();
		final JCheckBox airplaneBox = new JCheckBox("Airplane");
		airplaneBox.setSelected(true);
		final JCheckBox boatBox = new JCheckBox("Boat");
		final JCheckBox clockBox = new JCheckBox("Clock");
		box.add(airplaneBox);
		box.add(boatBox);
		box.add(clockBox);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton show = new JButton("Show");
		JButton add = new JButton("Add");
		JButton remove = new JButton("Remove");
		JButton exit = new JButton("Exit");
		
		final AnimationWindow animationWindow = new AnimationWindow();
		
		show.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for show button to display the
			 * animation window.
			 */
			public void actionPerformed(ActionEvent event)
			{
				animationWindow.makeVisible();
			}
		});
		
		add.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for add button to add selected
			 * objects to the animation window.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (airplaneBox.isSelected())
					animationWindow.addAirplane();
				if (boatBox.isSelected())
					animationWindow.addBoat();
				if (clockBox.isSelected())
					animationWindow.addClock();
			}
		});
		
		remove.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for remove button to remove selected
			 * objects from the animation window.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (airplaneBox.isSelected())
					animationWindow.removeAirplane();
				if (boatBox.isSelected())
					animationWindow.removeBoat();
				if (clockBox.isSelected())
					animationWindow.removeClock();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			/**
			 * Sets action listener for exit button to shut down the
			 * entire program.
			 */
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
		buttonPanel.add(show);
		buttonPanel.add(add);
		buttonPanel.add(remove);
		buttonPanel.add(exit);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(box, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
}