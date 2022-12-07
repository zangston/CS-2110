/*
 * CS 2110
 * Professor Graham
 * Lab Activity 20
 * SimpleWindow.java
 * Winston Zhang
 * 20 Oct 2020
 */

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SimpleWindow extends JFrame
{
	JLabel instructionLabel;
	JTextField textField;
	JLabel resultLabel;
	JButton actionButton;
	
	FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);	
	
	public SimpleWindow()
	{
		instructionLabel = new JLabel();
	}
	
	public static void main(String[] arg)
	{
		WindowRunnable myWindow = new WindowRunnable();
	
		javax.swing.SwingUtilities.invokeLater(myWindow);

	}
	
	public static void createAndShowGUI()
	{
		SimpleWindow frame = new SimpleWindow();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentsToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addComponentsToPane(Container pane)
	{
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		panel5.setLayout(mainLayout);
		
		instructionLabel = new JLabel("this is the instruction label");
		panel1.add(instructionLabel);
		
		
		textField = new JTextField(40);
		panel2.add(textField);
		
		resultLabel = new JLabel("this is the result label");
		panel3.add(resultLabel);
		
		actionButton = new JButton("Action");
		panel4.add(actionButton);
		
		panel5.add(panel1);
		panel5.add(panel2);
		panel5.add(panel3);
		panel5.add(panel4);
		pane.add(panel5);
	}
}

class WindowRunnable implements Runnable
{
	public void run()
	{
		SimpleWindow.createAndShowGUI();
	}
}