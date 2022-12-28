import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class fdemo extends JFrame
{
	JRadioButton r1,r2;
	ButtonGroup bg;
	fdemo()
	{
		setLayout(new FlowLayout());
		r1=new JRadioButton("Female",true);
		r2=new JRadioButton("Male");
		bg=new ButtonGroup();
		
		bg.add(r1);
		bg.add(r2);
		add(r1);
		add(r2);
		
		System.out.println(""+bg.getSelection());
	}
}
class test1
{
	public static void main(String ar[])
	{
		fdemo f=new fdemo();
		f.setVisible(true);
		f.setBounds(100,100,1300,700);
	}
}





// import java.util.*;
// class test1
// {
	// public static void main(String arr[])
	// {
		// ArrayList<String> ar=new ArrayList<>();
		// ar.add("India");
		// ar.add("Germeny");
		// ar.add("Guyana");
		// ar.add("Brazil");
		// ar.set(1,"sudan");
		// ar.set(2,"egypt");
		// ar.remove(2);
		// List<String> li=ar.subList(0,ar.size()/2);
		// Iterator<String> itr=li.iterator();
		// while(itr.hasNext())
		// {
			// int index=1;
			// itr.next();
			// if(li.subList(0,ar.size()/3).contains("_r%")&&(index>=0&&index<li.size()))
			// {
				// li.remove(index);
				// index++;
			// }
		// }
		// System.out.println(li);
	// }
// }