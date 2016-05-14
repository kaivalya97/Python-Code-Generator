package source;
//Importing Java packages for GUI implementation and File handling
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class ButtonListener implements ActionListener		//Implements from the Java interface ActionListener
{
		public void actionPerformed(ActionEvent event	//Abstract function which is mandatory to override in a class implementing the interface
		{
			String command = event.getActionCommand();	//Gets the action command from the event and sets it to a String
			switch(command)		//Executes commands according to the button pressed
			{
				case "Print":	//Executed when the "Print" button is pressed
					GUI Popup = new GUI("Variable or String?","",command);	//Instantiates GUI object "Popup" which invokes the constructor
					break;
					
				case "PrintString":		//Executed when the button "Print String" is pressed
					dispose();		//Closes the "Print String" window
					Data.insert("print('"+Text[0].getText()+"')");		//Inserts the appropriate Python code into the file
					break;
					
				case "PrintVariable":	//Executed when the button "Print Variable" is pressed
					try		//Used exception handling for the checkVariable function
					{
						String Check = checkVariable(Text[0].getText());	//Passes the value of the name of the variable entered to the 
						if(Check=="Exists")
							dispose();	//Closes the Print Variable window
							Data.insert("print("+Text[0].getText()+")");	//Inserts the appropriate Python code into the file
					}
					catch(NullPointerException npe)		//Executed when an exception occurs in the checkVariable function
					{
						setSize(440,125);	//Increases the size of the Print Variable frame for a new Label
						Label[1] = new JLabel("The variable doesn't exist. Make a variable using the 'New Variable' button");	//Adds a label indicating the variable doesn't exist
						add(Label[1]);
					}
					break;
					
				case "String":	//Executed when the button "String" is pressed
					dispose();	//Closes the Print window
					GUI Stringin = new GUI("Insert String","",command);	//Creates a new frame and invokes the GUI constructor
					break;
					
				case "Variable":	//Executed when the button "Variable" is pressed
					dispose();	//Closes the Print window
					GUI Variable = new GUI("Insert Variable","",command);	//Creates a new frame and invokes the GUI constructor
					break;
					
				case "New":	//Executed when the button "New variable" is pressed
					GUI New = new GUI("New Variable","",command);	//Creates a new frame and invokes the GUI constructor
					break;
					
				case "NewVariable":	//Executed when the button "Add Variable" is pressed
					dispose();	//Closes the New Variable window
					Data.insert(Text[0].getText()+"="+Text[1].getText());	//Inserts the appropriate Python code into the file
					Variables[i] = Text[0].getText();	//Inserts the name of the new variable in the String Array 'Variables' of GUI class
					i++;	//Increments the arbitrary variable for counting the number of variables
					break;
					
				case "If":	//Executed when the button "If" is pressed
					GUI If = new GUI("If condition","",command);	//Cretes a new frame and invokes the GUI constructor
					break;
					
				case "IfWindow":	//Executed when the button "Continue" is pressed
					dispose();	//Closes the "if" window
					GUI IfElse = new GUI("Statements inside If","",command);	//Creates a new frame and invokes the GUI constructor
					Data.insert("if("+Text[0].getText()+Text[1].getText()+Text[2].getText()+"):");	//Inserts the appropriate Python code into the file
					Data.incIndent();	//Invokes the incIndent function in the Data class which increases the Indentation of the python code
					break;
					
				case "ElseWindow":	//Executed when the button "Else" is pressed
					dispose	//Closes the "If" window
					Data.decIndent();	//Decreases the indentation of the python code
					Data.insert("else:");	//Inserts the appropriate Python code into the file
					Data.incIndent();	//Increases the indentation of the python code
					GUI Else = new GUI("Statements inside else","",command);	//Creates a new frame and invokes the constructor of the GUI class
					break;
					
				case "Delete":	//Executed when the button "Delete last char" is pressed
					try		//Implemented exception handling for file management
					{
						RandomAccessFile file= new RandomAccessFile("\\Users\\Administrator\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py", "rw");
						long length = file.length();		//Arbitrary variable which stores the length of the file
						file.setLength(length - 1);		//Decreases the length of the file by 1 or deletes the last character of the file
						file.close();		//Closes the file object
						Project.frame2.dispose();	//Closes the frame2 window
						Project.frame2 = new GUI("File contents","");		//Reopens frame2 for the file contents
						Project.frame2.setSize(250,180);		//Sets the size of frame2
						Project.frame2.setVisible(true);		//Makes frame2 visible
						Project.frame2.setLocation(625,300);	//Sets the location of frame2
					}
					catch(Exception e)	//Catches exception in file IO
					{
						System.out.println("Error in file IO");
					}
					break;
					
				case "Endif":		//Runs when the "End if block" or "End while" is pressed
					dispose();		//Closes the If or while window
					Data.decIndent();	//Decreases the indentation in the python code
					break;
					
				case "Array":		//Runs when the "List(Array)" button is clicked
					GUI ArrayWindow = new GUI("Array","",command);	//Creates a new frame and invokes the GUI constructor
					break;
					
				case "ArrayWindow":	//Runs when the button "Enter elements" is pressed
					dispose();	//Closes the Array window
					ArraySize = Integer.parseInt(Text[1].getText());	//Gets the size of the array from the text box
					GUI ArrayElement = new GUI("Enter elements","",command);	//Creates a new frame and invokes the constructor of GUI class				
					Data.insert(Text[0].getText()+" = {");		//Inserts the appropriate Python code into the file
					break;
					
				case "ArrayElement":
					if(i<=ArraySize)	//Runs when the counter is less than or equal to than the array size
					{
						try
						{
							File file = new File("\\Users\\Administrator\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
							FileWriter fw = new FileWriter(file,true);
							Label[0].setText("Enter the "+(i+1)+"th  element of the array");
							fw.write(Text[0].getText());
							if(i<ArraySize && i!=0)
								fw.write(",");		//Inserts the appropriate Python code into the file
							else if(i==ArraySize)
							{
								fw.write("}");		//Inserts the appropriate Python code into the file
								dispose();		//Closes the "Enter elements" window
							}
							else if(i==0);
							Text[0].setText(null);		//Resets the text area for the next array element input
							i++;		//Increments the counter for the next element
							fw.close();		//Closes the FileWriter
							Project.frame2.dispose();		//Closes the frame2
							Project.frame2 = new GUI("File contents","");		//Creates the window frame2
							Project.frame2.setSize(250,180);
							Project.frame2.setVisible(true);
							Project.frame2.setLocation(625,300);
						}
						catch(IOException e)
						{
							System.out.println("Error writing to file");
						}
					}
					else
						dispose();		//Closes the window when the couter is greater than the arraysize
					break;
					
				case "While":		//Runs when the button "While" is pressed
					GUI While = new GUI("While","",command);	//Creates a new frame and invokes the constructor of GUI
					break;
					
				case "WhileWindow":		//Runs when the button "Continue" is pressed
					dispose();		//Closes the window
					GUI WhileWindow = new GUI("Statements inside while","",command);
					Data.insert("while("+Text[0].getText()+Text[1].getText()+Text[2].getText()+"):");	//Inserts the appropriate Python code into the file
					Data.incIndent();	//Increases in indentation in the python code
					break;
				case "Increment":		//Runs when the button "Increment" is pressed
					GUI Increment = new GUI("Increment","",command);	//Creates a new frame and invokes the GUI construcor
					break;
				case "IncrementWindow":	//Runs when the button "Increment" is pressed
					try
					{
						String Check = checkVariable(Text[0].getText());		//Checks whether the variable which is incremented exists
						if(Check=="Exists")
							dispose();
							Data.insert(Text[0].getText()+" += "+Text[1].getText());		//Inserts the appropriate Python code into the file
					}
					catch(NullPointerException npe)
					{
						setSize(440,125);
						Label[1] = new JLabel("The variable doesn't exist. Make a variable using the 'New Variable' button");
						add(Label[1]);
					}
					break;
				case "Decrement":
					GUI Decrement = new GUI("Decrement","",command);
					break;
				case "DecrementWindow":
					try
					{
						String Check = checkVariable(Text[0].getText());		//Checks whether the variable which is decremented exists
						if(Check=="Exists")
							dispose();
							Data.insert(Text[0].getText()+" -= "+Text[1].getText());		//Inserts the appropriate Python code into the file
					}
					catch(NullPointerException npe)
					{
						setSize(440,125);
						Label[1] = new JLabel("The variable doesn't exist. Make a variable using the 'New Variable' button");
						add(Label[1]);
					}
					break;
			}
		}
	};