/*
 * CS 2110
 * Professor Graham
 * Lab Activity 20
 * ActionWindow.java
 * Winston Zhang
 * 20 Oct 2020
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ActionWindow extends JFrame
{
	JLabel instructionLabel;
	JTextField textField;
	JLabel resultLabel;
	JButton actionButton;
	
	FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);	
	
	public ActionWindow()
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
		ActionWindow frame = new ActionWindow();
		
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
		
		instructionLabel = new JLabel("Enter a distance in miles and click the button to convert to kilometers");
		panel1.add(instructionLabel);
		
		
		textField = new JTextField(40);
		panel2.add(textField);
		
		resultLabel = new JLabel("0 kilometers");
		panel3.add(resultLabel);
		
		class ButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getActionCommand().equals("changeLabel"))
				{
					int mi = Integer.parseInt(textField.getText());
					double km = ((double) mi) * 1.609344;
					String text = String.valueOf(km) + " kilometers";
					resultLabel.setText(text);
				}
			}
		}
		
		actionButton = new JButton("Convert");
		actionButton.setActionCommand("changeLabel");
		ButtonListener myListener = new ButtonListener();
		actionButton.addActionListener(myListener);
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
		ActionWindow.createAndShowGUI();
	}
}