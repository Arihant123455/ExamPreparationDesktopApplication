import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class course extends JPanel
{ 
	ImageIcon img1;
	Image i1;
	JButton b1;
	JTabbedPane tb1;
	back1 b;
	add1 a;
	delete1 d;
	update1 u;
	course(FDemo f)
	{
		setLayout(new BorderLayout());
		tb1=new JTabbedPane();
		Font o=new Font("",Font.BOLD,18);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		
		b=new back1();
		tb1.add("back",b);
		
		a=new add1();
		tb1.add("Add",a);
		
		u=new update1();
		tb1.add("Update",u);
		
		d=new delete1();
		tb1.add("Delete",d);
		
		b1=new JButton("Back");
		b1.setFont(o);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
        b1.addActionListener(f);		
		tb1.setTabComponentAt(0,b1);
		add(tb1);
		tb1.setFont(o);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
} 
class back1 extends JPanel
{ 
	ImageIcon img1;
	Image i1;
	JLabel l1,l2;
	back1()
	{
		setLayout(null);
		Font o=new Font("",Font.BOLD,23);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		
		l1=new JLabel("WELCOME");
		l2=new JLabel("Here, admin can add courses.");
		add(l1);
	    add(l2);
	    l1.setBounds(550,100,500,90);
		l2.setBounds(450,150,700,90);
		l1.setFont(o);
		l2.setFont(o);
		l1.setForeground(Color.blue);
		l2.setForeground(Color.white);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
}
class add1 extends JPanel implements ActionListener
{ 
	ImageIcon img1;
	Image i1;
	JTextField t1,t2,t3,t4;
	JTabbedPane tb1;
	JButton b1;
	static int x=0;
	JLabel l1,l2,l3,l4;
	add1()
	{
		setLayout(null);
		Font o=new Font("",Font.BOLD,20);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		
		t1=new JTextField();
		t1.setEditable(false);
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		ResultSet rs;
		Statement st;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	        st=con.createStatement();
	     	rs=st.executeQuery("Select * from course");
			while(rs.next())
			x++;
			con.close();
		}
		catch(Exception e1)
		{ System.out.println(e1); }
		
		t1.setText(""+(++x));
		t1.setBounds(330,150,80,50);
		t2.setBounds(450,150,210,50);
		t3.setBounds(710,150,100,50);
		
		t1.setFont(o);
		t2.setFont(o);
		t3.setFont(o);
		
		add(t1);
		add(t2);
		add(t3);
		
		l1=new JLabel("S.NO");
		l2=new JLabel("Course Name");
		l3=new JLabel("Timer");
		l4=new JLabel("mm");
		l1.setBounds(330,100,80,50);
		l2.setBounds(450,100,210,50);
		l3.setBounds(710,100,100,50);
		l4.setBounds(830,150,100,50);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		l1.setFont(o);
		l2.setFont(o);
		l3.setFont(o);
		l4.setFont(o);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		b1=new JButton("Add");
		b1.setBounds(500,250,90,40);
		add(b1);
		b1.setFont(o);
		b1.addActionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
            Statement st= con.createStatement();
	     	st.executeUpdate("insert into course values('"+s1+"','"+s2+"','"+s3+"')");
			JOptionPane.showMessageDialog(null,"Course added");
			st.executeUpdate("create table "+s2+"(qno varchar(30),ques varchar(200),o1 varchar(100),o2 varchar(100),o3 varchar(100),o4 varchar(100),ans varchar(100))");
			t1.setText(""+(++x));
			t2.setText("");
			t3.setText("");
			con.close();
		}
		catch(Exception e1)
		{ System.out.println(e1); }
	}
}
class update1 extends JPanel implements ActionListener
{ 
	ImageIcon img1;
	Image i1;
	JTabbedPane tb1;
	JTextField t,t1,t2,t3;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2;
	update1()
	{
		setLayout(null);
		Font o=new Font("",Font.BOLD,23);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		
		t=new JTextField();
		t.setBounds(470,90,120,40);
		t.setFont(o);
		add(t);
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t1.setBounds(350,200,80,50);
		t2.setBounds(450,200,210,50);
		t3.setBounds(710,200,100,50);
		
		t1.setFont(o);
		t2.setFont(o);
		t3.setFont(o);
		
		l1=new JLabel("S.NO");
		l2=new JLabel("Course Name");
		l3=new JLabel("Timer");
		l4=new JLabel("mm");
		l5=new JLabel("S.NO");
		l5.setBounds(370,90,120,50);
		add(l5);
		l5.setFont(o);
		l5.setForeground(Color.white);
		
		l1.setBounds(330,150,80,50);
		l2.setBounds(450,150,210,50);
		l3.setBounds(710,150,100,50);
		l4.setBounds(830,200,100,50);
		l1.setFont(o);
		l2.setFont(o);
		l3.setFont(o);
		l4.setFont(o);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		b1=new JButton("Search");
		b1.setBounds(650,90,120,40);
		add(b1);
		b1.setFont(o);
		b1.addActionListener(this);
		
		b2=new JButton("Update");
		b2.setBounds(450,300,120,40);
		b2.setFont(o);
		b2.addActionListener(this);
		add(t1);
		add(t2);
		add(t3);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(b2);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
	public void actionPerformed(ActionEvent e)
	{
	 if(e.getSource()==b1)
	 {
		 String s1=t.getText();
		    try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
			if(s1.length()>=1)
			{
			ResultSet rs=st.executeQuery("select * from course where sno="+s1+"");
			if(rs.next())
			{
				t1.setText(rs.getString(1));
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
				con.close();
			}
			else 
			JOptionPane.showMessageDialog(null,"S_NO not found in database");
           }
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
	 }
	 
	 if(e.getSource()==b2)
	 {
		 String a1=t1.getText();
		 String a2=t2.getText();
		 String a3=t3.getText();
		    try
			{
		    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
			if(a1.length()>=1&&a2.length()>=1&&a3.length()>=1)
			st.executeUpdate("update course set coursen='"+a2+"',time='"+a3+"' where sno="+a1+"");
	        JOptionPane.showMessageDialog(null,"Course updated");
			t.setText("");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
	 
	}
}
}
class delete1 extends JPanel implements ActionListener
{ 
	ImageIcon img1;
	Image i1;
	JTabbedPane tb1;
	JTextField t;
	JLabel l5;
	JButton b1;
	delete1()
	{
		setLayout(null);
		Font o=new Font("",Font.BOLD,23);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		t=new JTextField();
		t.setBounds(540,90,220,40);
		t.setFont(o);
		add(t);
		
		l5=new JLabel("Course NO.");
		l5.setBounds(370,90,200,50);
		add(l5);
		l5.setFont(o);
		l5.setForeground(Color.white);
		
		b1=new JButton("Delete");
		b1.setBounds(515,160,120,40);
		add(b1);
		b1.setFont(o);
		b1.addActionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		 if(e.getSource()==b1)
	     {
		 String s1=t.getText();
		    try
			{
			 Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
			if(s1.length()>=1)
			{
			ResultSet rs=st.executeQuery("select * from course where sno="+s1+"");
			if(rs.next())
			{
			st.executeUpdate("drop table "+rs.getString(2)+" ");
			st.executeUpdate("delete from course where sno="+s1+"");
			con.close();
			t.setText("");
			JOptionPane.showMessageDialog(null,"Course deleted");
			}
			else 
			JOptionPane.showMessageDialog(null,"S_NO not found in database");
            }
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
	      }
	}
}