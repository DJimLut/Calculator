import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;

public class Calculator 
{
	// properties of my GUI
	public JFrame frame1 = new JFrame("Calculator.java");
	public JPanel panel1 = new JPanel();
	public JPanel buttonPanel = new JPanel();
	public JPanel buttonGrid = new JPanel();
	public JButton button0 = new JButton("0");
	public JButton button1 = new JButton("1");
	public JButton button2 = new JButton("2");
	public JButton button3 = new JButton("3");
	public JButton button4 = new JButton("4");
	public JButton button5 = new JButton("5");
	public JButton button6 = new JButton("6");
	public JButton button7 = new JButton("7");
	public JButton button8 = new JButton("8");
	public JButton button9 = new JButton("9");
	public JButton buttonDec = new JButton(".");
	public JButton buttonEnt = new JButton("Enter");
	public JButton buttonAdd = new JButton("+");
	public JButton buttonSub = new JButton("-");
	public JButton buttonMult = new JButton("*");
	public JButton buttonDiv = new JButton("/");
	public JButton buttonClr = new JButton("C");
	public JButton buttonBlank1 = new JButton(" ");
	public JButton buttonBlank2 = new JButton(" ");
	public JButton buttonBlank3 = new JButton(" ");
	public JTextField display = new JTextField("After each calculation, hit C.");
	public boolean add = false;
	public boolean sub = false;
	public boolean div = false;
	public boolean mult = false;
	public double temp = 0;
	public double solvedTemp = 0;
	
	public Calculator()
	{
		// building the window
		frame1.setVisible(true);
		frame1.setSize(400, 400);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // adding exit on close operation
		frame1.add(panel1);
		panel1.setBackground(new Color(133,133,133)); // setting color of my choice, looks nicer in my opinion
		panel1.setLayout(new BorderLayout());
		panel1.add(display, BorderLayout.CENTER);
		display.setEditable(false);
		display.setFont(new Font("SansSerif", Font.BOLD, 20));
		panel1.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.add(buttonGrid);
		buttonGrid.setLayout(new GridLayout(4, 5));
		//adding buttons and listeners
		buttonGrid.add(button7);
		button7.addActionListener(new ButtonListener());
		buttonGrid.add(button8);
		button8.addActionListener(new ButtonListener());
		buttonGrid.add(button9);
		button9.addActionListener(new ButtonListener());
		buttonGrid.add(buttonDiv);
		buttonDiv.addActionListener(new ButtonListener());
		buttonGrid.add(buttonBlank1);
		buttonGrid.add(button4);
		button4.addActionListener(new ButtonListener());
		buttonGrid.add(button5);
		button5.addActionListener(new ButtonListener());
		buttonGrid.add(button6);
		button6.addActionListener(new ButtonListener());
		buttonGrid.add(buttonMult);
		buttonMult.addActionListener(new ButtonListener());
		buttonGrid.add(buttonBlank2);
		buttonGrid.add(button1);
		button1.addActionListener(new ButtonListener());
		buttonGrid.add(button2);
		button2.addActionListener(new ButtonListener());
		buttonGrid.add(button3);
		button3.addActionListener(new ButtonListener());
		buttonGrid.add(buttonSub);
		buttonSub.addActionListener(new ButtonListener());
		buttonGrid.add(buttonBlank3);
		buttonGrid.add(button0);
		button0.addActionListener(new ButtonListener());
		buttonGrid.add(buttonDec);
		buttonDec.addActionListener(new ButtonListener());
		buttonGrid.add(buttonEnt);
		buttonEnt.addActionListener(new ButtonListener());
		buttonGrid.add(buttonAdd);
		buttonAdd.addActionListener(new ButtonListener());
		buttonGrid.add(buttonClr);
		buttonClr.addActionListener(new ButtonListener());
	}
	
	public class ButtonListener implements ActionListener // inner class that implements the ActionListener interface
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//displaying the button clicked.
			if (e.getSource().equals(button7))
			{
					display.setText(display.getText() + "7");
			}
			
			else if (e.getSource().equals(button8))
			{
					display.setText(display.getText() + "8");
			}
			
			else if (e.getSource().equals(button9))
			{
					display.setText(display.getText() + "9");
			}

			//setting a temporary value with the current display, then clearing the display when any of the operators are clicked.
			else if (e.getSource().equals(buttonDiv))
			{
				temp = Double.parseDouble(display.getText());
				display.setText("");
				div = true;
			}

			else if (e.getSource().equals(button4))
			{
					display.setText(display.getText() + "4");
			}

			else if (e.getSource().equals(button5))
			{
					display.setText(display.getText() + "5");
			}

			else if (e.getSource().equals(button6))
			{
					display.setText(display.getText() + "6");
			}

			else if (e.getSource().equals(buttonMult))
			{
				temp = Double.parseDouble(display.getText());
				display.setText("");
				mult = true;
			}

			else if (e.getSource().equals(button1))
			{
					display.setText(display.getText() + "1");
			}

			else if (e.getSource().equals(button2))
			{
					display.setText(display.getText() + "2");
			}

			else if (e.getSource().equals(button3))
			{
					display.setText(display.getText() + "3");
			}

			else if (e.getSource().equals(buttonSub))
			{
				temp = Double.parseDouble(display.getText());
				display.setText("");
				sub = true;
			}

			else if (e.getSource().equals(button0))
			{
					display.setText(display.getText() + "0");
			}

			else if (e.getSource().equals(buttonDec))
			{
				display.setText(display.getText() + ".");
			}

			else if (e.getSource().equals(buttonEnt))
			{
				solvedTemp = Double.parseDouble(display.getText()); //setting the current display to a different temporary value.
				//running checks if any of the operator booleans are true then performing the operation if so.
				if (add == true)
					solvedTemp += temp;
				else if (sub == true)
					solvedTemp = temp - solvedTemp;
				else if (mult == true)
					solvedTemp *= temp;
				else if (div == true)
					solvedTemp = temp / solvedTemp;
				
				//displaying the result.
				display.setText("" + solvedTemp);
				
				//resetting the operator booleans to false
				add = false;
				sub = false;
				mult = false;
				div = false;
				
				//setting the temp values back to 0.
				temp = 0;
				solvedTemp = 0;
			}

			else if (e.getSource().equals(buttonAdd))
			{
				temp = Double.parseDouble(display.getText());
				display.setText("");
				add = true;
			}

			else if (e.getSource().equals(buttonClr))
			{
				//clearing the displaying and resetting variables.
				display.setText("");
				add = false;
				sub = false;
				mult = false;
				div = false;
				
				temp = 0;
				solvedTemp = 0;
			}
			
			else
			{
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Calculator calc1 = new Calculator(); // creating a new object of the calculator class.
	}
}
