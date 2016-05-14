package source;
//Importing java packages for GUI implemenation and file handling
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Data 	//class name data is been made
 {
	static int indent;	//Static integers are been declared
	static int temp;	//Static integers are been declared
	
	public static void indent()	//Indent function is been made so that spacing can be provided
	{
		try	//			Expection handling is been used
		{
			File file = new File("\\Users\\Administrator\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");//FIle path is been declared
			FileWriter fw = new FileWriter(file,true);	//To write in file File Writter is been used
			fw.write("\n");	//Next line means the space is been printed
			for(temp = 0; temp<indent; temp++)
				fw.write("\t");
			fw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error writing in file");
		}
	}
	public static void incIndent()	//In this function the spacing is been increased as he if loop is been increased
	{
		++indent;
		Indent();
	}
	public static void decIndent()	//In this function the spacing is been decreased so that function can be impleted after the if loop
	{
		--indent;
		Indent();
	}
	
	public static void insert(String code)	//In this function the right window is been made by this 
	{
		try	//Expection handling is been used to catch the expections
		{
			File file = new File("\\Users\\Administrator\\Desktop\\College\\Semester 2\\OOP\\Project\\proj.py");
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			Data.indent();
			bw.write(code);
			bw.close();
			Project.frame2.dispose();
			Project.frame2 = new GUI("File contents","");
			Project.frame2.setSize(250,180);
			Project.frame2.setVisible(true);
			Project.frame2.setLocation(625,300);
		}
		catch(IOException e)
		{
			System.out.println("Error writing to file");
		}
	}
};