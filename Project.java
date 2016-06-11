import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

class GUI extends JFrame
{
	public JButton[] Button = new JButton[10];
	public JTextArea[] Text = new JTextArea[3];
	public JLabel[] Label = new JLabel[4];
	private static String[] Variables = new String[10];
	static int ArraySize;
	public static int i=1;
	
	public GUI(String title,String frame,String function)
	{
		super(title);
		setLayout(new FlowLayout());
		setSize(275,150);
		setLocation(750,390);
		setVisible(true);
		
		if(function=="Print")
		{
			Label[0] = new JLabel("Do you want to print a variable or a string?");
			Button[0] = new JButton("Variable");
			Button[0].setActionCommand("Variable");
			Button[1] = new JButton("String");
			Button[1].setActionCommand("String");
			Button[0].addActionListener(new ButtonListener());
			Button[1].addActionListener(new ButtonListener());
			add(Label[0]);
			add(Button[0]);
			add(Button[1]);
		}
		
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
			Button[0] = new JButton("Input from User");
			Button[0].setActionCommand("VariableInput");
			Button[0].addActionListener(new ButtonListener());
			add(Button[0]);
			Button[1] = new JButton("Add variable");
			Button[1].setActionCommand("NewVariable");
			Button[1].addActionListener(new ButtonListener());
			add(Button[1]);
			setLocation(750,390);
			setSize(450,120);
			setVisible(true);
		}
		
		else if(function=="VariableInput")
		{
			setLayout(new FlowLayout());
			Label[0] = new JLabel("Enter the prompt for the user");
			add(Label[0]);
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,20);
			add(Text[0]);
			Button[0] = new JButton("Add Variable");
			Button[0].setActionCommand("NewVariableInput");
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
			Label[0] = new JLabel("Enter the 1th element of the Array");
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

		else if(function=="Run")
		{
			Text[0] = new JTextArea();
			Text[0].setLineWrap(true);
			Text[0].setSize(50,200);
			try 
            {
				//String path = "C:/Users/kaivalya/Desktop/College/Semester 2/OOP/Project/proj.py";
				//String cmd = "cmd.exe /c cd C:/Users/kaivalya/Desktop/College/Semester 2/OOP/Project/ && python proj.py";
				String cmd = "cmd.exe /c python \"C:/Users/kaivalya/Desktop/College/Semester 2/OOP/Project/proj.py\"";
				//System.out.println(cmd);
                Process p = Runtime.getRuntime().exec(cmd); 
                p.waitFor(); 
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
                String line; 
                while((line = reader.readLine()) != null) 
                { 
                    Text[0].append(line+"\n");
                } 
            }
            catch(Exception e) 
			{
				e.printStackTrace();
			}
			Text[0].setEditable(false);
			Text[0].setBackground(null);
			add(Text[0]);
		}
	}
	
	public GUI(String title,String frame)
	{
		super(title);
		setLayout(new FlowLayout());
		try
		{
			File file = new File("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Text[0] = new JTextArea();
			Text[0].setEditable(false);
			Text[0].setBackground(null);
			add(Text[0]);
			String strLine;
			while ((strLine=br.readLine()) != null)
				Text[0].append(strLine+"\n");
			br.close();
			fr.close();
		}
		catch(IOException e)
		{
			System.out.println("Error reading file");
		}
	};
	
	public GUI(String title)
	{
		super(title);
		setLayout(new GridLayout(3,3));
	}
	
	public static String CheckVariable(String Var)
	{
		for(String str: Variables)
		{
			if(str.equals(Var))
				return "Exists";
		}
		return "NotExists";
	}
	
	public void addActionListeners()
	{
		for(int i=0;i<=8;i++)
			{
				Project.frame.add(Project.frame.Button[i]);
				Button[i].addActionListener(new ButtonListener());
			}
	}
	
	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String command = event.getActionCommand();
			switch(command)
			{
				case "Print":
					GUI Popup = new GUI("Variable or String?","",command);
					break;
					
				case "PrintString":
					dispose();
					Data.Insert("print('"+Text[0].getText()+"')");
					break;
					
				case "PrintVariable":
					try
					{
						String Check = CheckVariable(Text[0].getText());
						if(Check=="Exists")
							dispose();
							Data.Insert("print("+Text[0].getText()+")");
					}
					catch(NullPointerException npe)
					{
						setSize(440,125);
						Label[1] = new JLabel("The variable doesn't exist. Make a variable using the 'New Variable' button");
						add(Label[1]);
					}
					break;
					
				case "String":
					dispose();
					GUI Stringin = new GUI("Insert String","",command);
					break;
					
				case "Variable":
					dispose();
					GUI Variable = new GUI("Insert Variable","",command);
					break;
					
				case "New":
					GUI New = new GUI("New Variable","",command);
					break;
					
				case "NewVariable":
					dispose();
					Data.Insert(Text[0].getText()+" = "+Text[1].getText());
					Variables[i] = Text[0].getText();
					i++;
					break;
					
				case "VariableInput":
					dispose();
					Data.Insert(Text[0].getText()+" = input(\"");
					Variables[i] = Text[0].getText();
					i++;
					GUI VariableInput = new GUI("Variable Input","",command);
					break;
				
				case "NewVariableInput":
					dispose();
					System.out.println("1");
					try
					{
						File file = new File("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
						FileWriter fw = new FileWriter(file,true);
						System.out.println(Text[0].getText());
						fw.write(Text[0].getText()+"\")");
						fw.close();
						Point a = Project.frame2.getLocation();
						int x = Project.frame2.getWidth();
						int y = Project.frame2.getHeight();
						Project.frame2.dispose();
						Project.frame2 = new GUI("File contents","");
						Project.frame2.setSize(x,y);
						Project.frame2.setVisible(true);
						Project.frame2.setLocation(a);
					}
					catch(IOException e)
					{
						System.out.println("Error writing to file");
					}
					break;

				case "If":
					GUI If = new GUI("If condition","",command);
					break;
					
				case "IfWindow":
					dispose();
					GUI IfElse = new GUI("Statements inside If","",command);
					Data.Insert("if("+Text[0].getText()+Text[1].getText()+Text[2].getText()+"):");
					Data.incIndent();
					break;
					
				case "ElseWindow":
					dispose();
					Data.decIndent();
					Data.Insert("else:");
					Data.incIndent();
					GUI Else = new GUI("Statements inside else","",command);
					break;
					
				case "Delete":
					try
					{
						Data.deleteChar();
						Point a = Project.frame2.getLocation();
						int x = Project.frame2.getWidth();
						int y = Project.frame2.getHeight();
						Project.frame2.dispose();
						Project.frame2 = new GUI("File contents","");
						Project.frame2.setSize(x,y);
						Project.frame2.setVisible(true);
						Project.frame2.setLocation(a);
					}
					catch(Exception e)
					{
						System.out.println("Error in file IO");
					}
					break;
					
				case "Endif":
					dispose();
					Data.decIndent();
					break;
					
				case "Array":
					GUI ArrayWindow = new GUI("Array","",command);
					break;
					
				case "ArrayWindow":
					dispose();
					ArraySize = Integer.parseInt(Text[1].getText());
					GUI ArrayElement = new GUI("Enter elements","",command);					
					Data.Insert(Text[0].getText()+" = {");
					break;
					
				case "ArrayElement":
					if(i<(ArraySize))
					{
						try
						{
							File file = new File("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
							FileWriter fw = new FileWriter(file,true);
							Label[0].setText("Enter the "+(i+1)+"th element of the array");
							fw.write(Text[0].getText()+",");
							/*if(i<(ArraySize-2))
								fw.write(",");*/
							Text[0].setText(null);
							fw.close();
							Point a = Project.frame2.getLocation();
							int x = Project.frame2.getWidth();
							int y = Project.frame2.getHeight();
							Project.frame2.dispose();
							Project.frame2 = new GUI("File contents","");
							Project.frame2.setSize(x,y);
							Project.frame2.setVisible(true);
							Project.frame2.setLocation(a);
							i++;
						}
						catch(IOException e)
						{
							System.out.println("Error writing to file");
						}
					}
					else
					{
						try
						{
							File file = new File("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
							FileWriter fw = new FileWriter(file,true);
							fw.write(Text[0].getText()+"}");
							fw.close();
							Point a = Project.frame2.getLocation();
							int x = Project.frame2.getWidth();
							int y = Project.frame2.getHeight();
							Project.frame2.dispose();
							Project.frame2 = new GUI("File contents","");
							Project.frame2.setSize(x,y);
							Project.frame2.setVisible(true);
							Project.frame2.setLocation(a);
							dispose();
						}
						catch(IOException e)
						{
							System.out.println("Error writing to file");
						}
					}
					break;
					
				case "While":
					GUI While = new GUI("While","",command);
					break;
					
				case "WhileWindow":
					dispose();
					GUI WhileWindow = new GUI("Statements inside while","",command);
					Data.Insert("while("+Text[0].getText()+Text[1].getText()+Text[2].getText()+"):");
					Data.incIndent();
					break;
				case "Increment":
					GUI Increment = new GUI("Increment","",command);
					break;
				case "IncrementWindow":
					try
					{
						String Check = CheckVariable(Text[0].getText());
						if(Check=="Exists")
							dispose();
							Data.Insert(Text[0].getText()+" += "+Text[1].getText());
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
						String Check = CheckVariable(Text[0].getText());
						if(Check=="Exists")
							dispose();
							Data.Insert(Text[0].getText()+" -= "+Text[1].getText());
					}
					catch(NullPointerException npe)
					{
						setSize(440,125);
						Label[1] = new JLabel("The variable doesn't exist. Make a variable using the 'New Variable' button");
						add(Label[1]);
					}
					break;
				case "Run":
					GUI Run = new GUI("Run Python Code","",command);
					break;
			}
		}
	};
};

class Data
{
	static int indent;
	static int temp;
	
	public static void Indent()
	{
		try
		{
			File file = new File("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
			FileWriter fw = new FileWriter(file,true);
			fw.write("\n");
			for(temp = 0; temp<indent; temp++)
				fw.write("\t");
			fw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error writing in file");
		}
	}
	public static void incIndent()
	{
		++indent;
		Indent();
	}
	public static void decIndent()
	{
		--indent;
		Indent();
	}
	
	public static void deleteChar()
	{
		try
		{
			RandomAccessFile file= new RandomAccessFile("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py", "rw");
			long length = file.length();
			file.setLength(length - 1);
			file.close();
		}
		catch(IOException e)
		{
			System.out.println("Error writing in file");
		}
	}

	public static void Insert(String code)
	{
		try
		{
			File file = new File("\\Users\\kaivalya\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			Data.Indent();
			bw.write(code);
			bw.close();
			Point a = Project.frame2.getLocation();
			int x = Project.frame2.getWidth();
			int y = Project.frame2.getHeight();
			Project.frame2.dispose();
			Project.frame2 = new GUI("File contents","");
			Project.frame2.setSize(x,y);
			Project.frame2.setVisible(true);
			Project.frame2.setLocation(a);
		}
		catch(IOException e)
		{
			System.out.println("Error writing to file");
		}
	}
};

public class Project
{
	public static GUI frame,frame2;
	
	public static void main(String[] Args)
	{
		Scanner input = new Scanner(System.in);
		String string;
		
		frame = new GUI("Python code generator");
		frame2 = new GUI("File contents","");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,180);
		frame.setLocation(350,300);
		
		//Defining and adding buttons to main frame:
		frame.Button[0] = new JButton("Print");
		frame.Button[0].setActionCommand("Print");
		frame.Button[1] = new JButton("New variable");
		frame.Button[1].setActionCommand("New");
		frame.Button[2] = new JButton("While loop");
		frame.Button[2].setActionCommand("While");
		frame.Button[3] = new JButton("If");
		frame.Button[3].setActionCommand("If");
		frame.Button[4] = new JButton("List(Array)");
		frame.Button[4].setActionCommand("Array");
		frame.Button[5] = new JButton("Delete last char");
		frame.Button[5].setActionCommand("Delete");
		frame.Button[6] = new JButton("Increment");
		frame.Button[6].setActionCommand("Increment");
		frame.Button[7] = new JButton("Decrement");
		frame.Button[7].setActionCommand("Decrement");
		frame.Button[8] = new JButton("Run Python Code");
		frame.Button[8].setActionCommand("Run");

		frame.addActionListeners();
		
		frame.setVisible(true);
		frame2.setSize(250,180);
		frame2.setVisible(true);
		frame2.setLocation(700,100);
	}
};