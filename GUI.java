package source;
//Importing java packages for GUI implementation and file handling
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class GUI extends JFrame	//JFrame is been inherited 
{
	public JButton[] Button = new JButton[10];	//JButton array is been made for 10 element
	public JTextArea[] Text = new JTextArea[3];	//JTextArea array is been made for 3 element
	public JLabel[] Label = new JLabel[4];	//JLabel array is been made
	private static String[] Variables = new String[10];	//Array of string is  been made
	Variables = new String[1];	//Implement linked list
 	static int ArraySize;	//Data member are been made
	public static int i=0;	//Interger is been declared to zero
	
	public GUI(String title)	//GUI Constructor is been made with one parameters 
	{
		super(title);	//Title name is been declared here
		setLayout(new GridLayout(4,2));
	}
	
	public GUI(String title,String frame)	//GUI constructor is been made with two parameters
	{
		super(title);	//Title name is been declared here 
		setLayout(new FlowLayout());
		try	//Exeception handling is been implemented here 
		{
			File file = new File("\\Users\\Administrator\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");	//The file path is been declared here 
			FileReader fr = new FileReader(file);	//Object of file reader is been made here 
			BufferedReader br = new BufferedReader(fr);	//Object of buffer writer is been made and the object of File reader is been passed here 
			Text[0] = new JTextArea();	//The Text area is been declared 
			Text[0].setEditable(false);	//This text area will not be visible
			Text[0].setBackground(null);//Background colour will be automatically same as parent
			add(Text[0]);	
			String strLine;	//string is been declared here 
			while ((strLine=br.readLine()) != null)
				Text[0].append(strLine+"\n");	//Appends every line of the file into frame
			br.close();//Buffer writer is been closed
			fr.close();//File writer is been closed
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
	}
	
	public GUI(String title,String frame, String function)	//	Constructor of three parameters is been made here 
	{
		super(title);	//	For title
		setLayout(new FlowLayout());	//For layout
		setSize(275,150);	//	Size is been set
		setLocation(750,390);	//Location is been set
		setVisible(true);//	Visibility is been set as true
		
		if(function=="Print")
		{
			Label[0] = new JLabel("Do you want to print a variable or a string?");//	A label is been declared here 
			Button[0] = new JButton("Variable");//	Button is been declared here
			Button[0].setActionCommand("Variable");//Action command is been set here 
			Button[1] = new JButton("String");//	Another button is declared here 
			Button[1].setActionCommand("String");//	Action command is been set here 
			Button[0].addActionListener(new ButtonListener());
			Button[1].addActionListener(new ButtonListener());
			add(Label[0]);//	Label is been added to window to display
			add(Button[0]);//	Button is been added to window to display
			add(Button[1]);//	Another button is been added to window to display
		}
//NOW IN THE FOLLOWING CODE ADD THE COMMANDS LIKE ACTIONLISTERNER BUTTON AND LABEL ARE BEEN USED AS SAME IT IS USED ABOVE			
		else if(function=="Variable")
		{
			setLayout(new FlowLayout());
			Label[0] = new JLabel("Enter the name of the variable you want to print");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			add(Text[0]);
			Button[0] = new JButton("Print Variable");
			Button[0].setActionCommand("PrintVariable");
			Button[0].addActionListener(new ButtonListener());
			add(Button[0]);
			setSize(300,100);
			setVisible(true);
		}
		
		else if(function=="String")
		{
			setLayout(new FlowLayout());
			Label[0] = new JLabel("Enter the string:");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Button[0] = new JButton("Print string");
			add(Button[0]);
			Button[0].setActionCommand("PrintString");
			Button[0].addActionListener(new ButtonListener());
			setLocation(750,390);
			setSize(200,100);
			setVisible(true);
		}
		
		else if(function=="New")
		{
			setLayout(new FlowLayout());
			Label[0] = new JLabel("Enter the name of the variable (Valid variable name only)");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Label[1] = new JLabel("Enter the value of the variable (Include quotes for String)");
			add(Label[1]);
			Text[1] = new JTextArea();
			Text[1].setLineWrap(true);
			Text[1].setSize(50,20);
			add(Text[1]);
			Button[0] = new JButton("Add variable");
			Button[0].setActionCommand("NewVariable");
			Button[0].addActionListener(new ButtonListener());
			add(Button[0]);
			setLocation(750,390);
			setSize(450,120);
			setVisible(true);
		}
		
		else if(function=="If")
		{
			setLayout(new FlowLayout());
			setSize(450,120);
			Label[0] = new JLabel("Enter the name of the first variable to be compared");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Label[1] = new JLabel("Enter the if condition to use(</>/==/!=)");
			add(Label[1]);
			Text[1] = new JTextArea();
			Text[1].setLineWrap(true);
			Text[1].setSize(50,20);
			add(Text[1]);
			Label[2] = new JLabel("Enter the number or variable to be compared with");
			add(Label[2]);
			Text[2] = new JTextArea();
			Text[2].setLineWrap(true);
			Text[2].setSize(50,20);
			add(Text[2]);
			Button[0] = new JButton("Continue");
			Button[0].setActionCommand("IfWindow");
			Button[0].addActionListener(new ButtonListener());
			add(Button[0]);
			
		}
		
		else if(function=="IfWindow")
		{
			setLayout(new GridLayout(4,2));
			Button[0] = new JButton("Print");
			Button[0].setActionCommand("Print");
			Button[1] = new JButton("New variable");
			Button[1].setActionCommand("New");
			Button[2] = new JButton("While");
			Button[2].setActionCommand("While");
			Button[3] = new JButton("Else");
			Button[3].setActionCommand("ElseWindow");
			Button[4] = new JButton("List(Array)");
			Button[4].setActionCommand("Array");
			Button[5] = new JButton("Increment");
			Button[5].setActionCommand("Increment");
			Button[6] = new JButton("Decrement");
			Button[6].setActionCommand("Decrement");
			Button[7] = new JButton("End if block");
			Button[7].setActionCommand("Endif");
			for(int i=0;i<=7;i++)
				{
					add(Button[i]);
					Button[i].addActionListener(new ButtonListener());
				}
		}
		
		else if(function=="ElseWindow")
		{
			setLayout(new GridLayout(4,2));
			Button[0] = new JButton("Print");
			Button[0].setActionCommand("Print");
			Button[1] = new JButton("New variable");
			Button[1].setActionCommand("New");
			Button[2] = new JButton("While");
			Button[2].setActionCommand("While");
			Button[3] = new JButton("List(Array)");
			Button[3].setActionCommand("Array");
			Button[4] = new JButton("Increment");
			Button[4].setActionCommand("Increment");
			Button[5] = new JButton("Decrement");
			Button[5].setActionCommand("Decrement");
			Button[6] = new JButton("End else block");
			Button[6].setActionCommand("Endif");
			for(int i=0;i<=6;i++)
				{
					add(Button[i]);
					Button[i].addActionListener(new ButtonListener());
				}
		}
		
		else if(function=="Array")
		{
			setLayout(new FlowLayout());
			setSize(450,120);
			Label[0] = new JLabel("Enter the name of the array");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Label[1] = new  JLabel("Enter the size of the array");
			add(Label[1]);
			Text[1]=new JTextArea();
			Text[1].setLineWrap(true);
			Text[1].setSize(50,20);
			add(Text[1]);
			Button[0]=new JButton("Enter the elements of array");
			Button[0].addActionListener(new ButtonListener());
			Button[0].setActionCommand("ArrayWindow");
			add(Button[0]);
		}
		
		else if(function=="ArrayWindow")
		{
			setLayout(new FlowLayout());
			setSize(450,120);
			Label[0] = new JLabel("Enter the first element of the Array");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Button[0] = new JButton("Insert element");
			Button[0].addActionListener(new ButtonListener());
			Button[0].setActionCommand("ArrayElement");
			add(Button[0]);
		}
		
		else if(function=="While")
		{
			setLayout(new FlowLayout());
			setSize(450,120);
			Label[0] = new JLabel("Enter the name of the first variable for the conditions");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Label[1] = new JLabel("Enter the condition of the while [>/</=/!=]");
			add(Label[1]);
			Text[1] = new JTextArea();
			Text[1].setLineWrap(true);
			Text[1].setSize(50,20);
			add(Text[1]);
			Label[2] = new JLabel("Enter the number or variable to be compared with ");
			add(Label[2]);
			Text[2] = new JTextArea();
			Text[2].setLineWrap(true);
			Text[2].setSize(50,20);
			add(Text[2]);
			Button[0] = new JButton("Continue");
			Button[0].setActionCommand("WhileWindow");
			Button[0].addActionListener(new ButtonListener());
			add(Button[0]);
		}
		
		else if(function=="WhileWindow")
		{
			setLayout(new GridLayout(4,2));
			Button[0] = new JButton("Print");
			Button[0].setActionCommand("Print");
			Button[1] = new JButton("New variable");
			Button[1].setActionCommand("New");
			Button[2] = new JButton("While");
			Button[2].setActionCommand("While");
			Button[3] = new JButton("List(Array)");
			Button[3].setActionCommand("Array");
			Button[4] = new JButton("Increment");
			Button[4].setActionCommand("Increment");
			Button[5] = new JButton("Decrement");
			Button[5].setActionCommand("Decrement");
			Button[6] = new JButton("End while");
			Button[6].setActionCommand("Endif");
			for(int i=0;i<=6;i++)
				{
					add(Button[i]);
					Button[i].addActionListener(new ButtonListener());
				}
		}
		
		else if(function=="Increment")
		{
			setLayout(new FlowLayout());
			Label[0] = new JLabel("Enter the name of the variable to increment");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Label[1] = new JLabel("Enter the value by which to increment the variable");
			add(Label[1]);
			Text[1] = new JTextArea();
			Text[1].setLineWrap(true);
			Text[1].setSize(50,20);
			add(Text[1]);
			Button[0] = new JButton("Increment");
			Button[0].addActionListener(new ButtonListener());
			Button[0].setActionCommand("IncrementWindow");
			add(Button[0]);
		}
		
		else if(function=="Decrement")
		{
			setLayout(new FlowLayout());
			Label[0] = new JLabel("Enter the name of the variable to decrement");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Label[1] = new JLabel("Enter the value by which to decrement the variable");
			add(Label[1]);
			Text[1] = new JTextArea();
			Text[1].setLineWrap(true);
			Text[1].setSize(50,20);
			add(Text[1]);
			Button[0] = new JButton("Decrement");
			Button[0].addActionListener(new ButtonListener());
			Button[0].setActionCommand("DecrementWindow");
			add(Button[0]);
		}
	}
	
	public static String checkVariable(String Var)//	Check variable is been made here so that it will detect the error if the variable is been made
	{
		for(String str: Variables)//	Enhanced for loop is been used 
		{
			if(str.equals(Var))	//IF the variable exist then it would show that the varibale exist
				return "Exists";
		}
		return "NotExists";//Other wise it wont 
	}
	
	public void addActionListeners()	//ActionListener array is been made here 
	{
		for(int i=0;i<=7;i++)
			{
				Project.frame.add(Project.frame.Button[i]);
				Button[i].addActionListener(new ButtonListener());
			}
	}
};