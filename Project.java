package source;
//Importing Java packages for GUI implementation and File handling
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Project
{
	public static GUI frame,frame2;	//Static data members (objects of GUI class)
	
	public static void main(String[] Args)	//Main function
	{
		frame = new GUI("Python code generator");	//Instantiating static data member "frame"
		frame2 = new GUI("File contents","");	//Instantiating static data member "frame2"
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Terminates the program when "frame" is closed
		frame.setSize(275,180);		//Sets the dimensions of the frame
		frame.setLocation(350,300);	//Sets the location of the frame with x and y as arguments
		
		//Defining and adding buttons to main frame:
		frame.Button[0] = new JButton("Print");	//Button for printing variable or string
		frame.Button[0].setActionCommand("Print");	//Setting action command for ButtonListener
		frame.Button[1] = new JButton("New variable");	//Button for making a new variable
		frame.Button[1].setActionCommand("New");	//Setting action command for ButtonListener
		frame.Button[2] = new JButton("While loop");	//Button for while loop
		frame.Button[2].setActionCommand("While");	//Setting action command for ButtonListener
		frame.Button[3] = new JButton("If");	//Button for if window
		frame.Button[3].setActionCommand("If");		//Setting action command for ButtonListener
		frame.Button[4] = new JButton("List(Array)");	//Button for Array window
		frame.Button[4].setActionCommand("Array");	//Setting action command for ButtonListener
		frame.Button[5] = new JButton("Delete last char");	//Button for deleting the last character of the file
		frame.Button[5].setActionCommand("Delete");	//Setting action command for ButtonListener
		frame.Button[6] = new JButton("Increment");	//Button for incrementing a variable by a given value
		frame.Button[6].setActionCommand("Increment");	//Setting action command for ButtonListener
		frame.Button[7] = new JButton("Decrement");	//Button for decrementing a variable by a given value
		frame.Button[7].setActionCommand("Decrement");	//Setting action command for ButtonListener
		
		frame.addActionListeners();		//Function from GUI class to add ActionListeners to all buttons of the frame
		
		frame.setVisible(true);		//Makes the frame visible
		frame2.setSize(250,180);	//Sets the size of the second frame
		frame2.setVisible(true);	//Makes the second frame visible
		frame2.setLocation(625,300);	//Sets the location of the second frame
	}
};