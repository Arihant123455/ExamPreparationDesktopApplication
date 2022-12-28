import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class page extends JPanel
{
	JTabbedPane tb1;
	Insert ins;
	Delete del;
	Update up;
	Search sc;
	ShowAll sh;
	Back b;
	ImageIcon img1;
	Image i1;
	JButton b1;
	page (){}
	page(FDemo f)
	{
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		
		setBackground(new Color(109,163,252));
		Font o=new Font("",Font.BOLD,16);
		setLayout(new BorderLayout());
		tb1=new JTabbedPane();
		
		b=new Back();
		tb1.add("Back",b);
		
		ins=new Insert();
		tb1.add("Insert",ins);
		
		sc=new Search();
		tb1.add("Search",sc);
		
		sh=new ShowAll();
		tb1.add("ShowAll",sh);
		
		up=new Update();
		tb1.add("Update",up);
		
		del=new Delete();
		tb1.add("Delete",del);
		
		b1=new JButton("Back");
		b1.setFont(o);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
        b1.addActionListener(f);		
		tb1.setTabComponentAt(0,b1);
     	tb1.setFont(o);
		add(tb1);
		tb1.addChangeListener(c);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
	void add1(Choice c)
	{
		try
		{
		c.removeAll();	
		c.add("Subject");	
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from course");
		while(rs.next())
		c.add(rs.getString(2));
		con.close();
		}
		catch(Exception e1){ System.out.println(e1); }
	}
	ChangeListener c=new ChangeListener()
	{
		public void stateChanged(ChangeEvent e)
		{
		 add1(Insert.l1);
		 add1(Search.l1);
		 add1(ShowAll.c);
		 add1(Update.c);
		 add1(Delete.c);
		 add1(tes.c);
		}
	};
}
class Back extends JPanel
{ 
    JLabel l1,l2,l3;
	ImageIcon img1;
	Image i1;
	Back()
	{
		setLayout(null);
		Font o=new Font("",Font.BOLD,23);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		l1=new JLabel("WELCOME TO COURSE MANGEMENT PAGE.");
		l2=new JLabel("Here, admin can insert, search, update, delete questions.");
		l3=new JLabel("And, can see all questions inserted of particular subject.");
	    add(l1);
	    add(l2);
	    add(l3);
		l1.setBounds(350,100,500,90);
		l2.setBounds(300,150,700,90);
		l3.setBounds(300,200,700,90);
		l1.setFont(o);
		l2.setFont(o);
		l3.setFont(o);
		l1.setForeground(Color.yellow);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
} 
class Insert extends JPanel implements ActionListener,ItemListener
{
	static Choice l1;
	Choice l2;
	JTextArea t1;
	JTextField t,t2,t3,t4,t5;
	JLabel u,u1,u2,u3,u4,u5,u6;
	JButton b1;
	int x=0;
	ImageIcon img1,img2;
	Image i1,i2;
	Insert()
	{
		img1=new ImageIcon("black.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("u1.png");
		i2=img2.getImage();
		setLayout(null);
		
		Font o=new Font("",Font.BOLD,23);
		Font o2=new Font("",Font.BOLD,30);
		Font o1=new Font("",Font.BOLD,15);
		
		l1=new Choice();
		l1.addItemListener(this);
		l1.setBounds(990,60,150,80);		
		add(l1);
		
		l2=new Choice();
		l2.add("None");
		l2.add("Option_1");
		l2.add("Option_2");
		l2.add("Option_3");
		l2.add("Option_4");
	
		t1=new JTextArea();
		t=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t.setEditable(false);
		
		u=new JLabel("Q.No");
		u1=new JLabel("1.");
		u2=new JLabel("2.");
		u3=new JLabel("3.");
		u4=new JLabel("4.");
		u5=new JLabel("Select subject:");
		u6=new JLabel("Correct Option:");
		
		b1=new JButton("Insert");
		add(b1);
		b1.setBounds(850,150,200,70);
		b1.addActionListener(this);
		
		t1.setLineWrap(true);
		t1.setBorder(BorderFactory.createLineBorder(Color.gray));
		t.setBounds(180,50,80,35);
		t1.setBounds(100,100,650,100);
		t2.setBounds(200,220,550,50);
		t3.setBounds(200,290,550,50);
		t4.setBounds(200,360,550,50);
		t5.setBounds(200,430,550,50);
		
		l2.setBounds(300,510,180,50);
		u.setBounds(100,40,70,50);
		u1.setBounds(130,220,70,50);
		u2.setBounds(130,290,70,50);
		u3.setBounds(130,360,70,50);
		u4.setBounds(130,430,70,50);
		u5.setBounds(790,50,180,50);
		u6.setBounds(100,500,180,50);
		
		add(l2);
		add(t);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		
		u.setForeground(Color.white);
		u1.setForeground(Color.white);
		u2.setForeground(Color.white);
		u3.setForeground(Color.white);
		u4.setForeground(Color.white);
		u5.setForeground(Color.white);
		u6.setForeground(Color.white);
		
		add(u);
		add(u1);
		add(u2);
		add(u3);
		add(u4);
		add(u5);
		add(u6);
	
		l1.setFont(o);
		l2.setFont(o);
		t.setFont(o);
		t1.setFont(o);
		t2.setFont(o);
		t3.setFont(o);
		t4.setFont(o);
		t5.setFont(o);
		b1.setFont(o2);
		
		u.setFont(o);
		u1.setFont(o);
		u2.setFont(o);
		u3.setFont(o);
		u4.setFont(o);
		u5.setFont(o);
		u6.setFont(o);
		
	}
	public void itemStateChanged(ItemEvent e)
	{	
	    x=0;
		String ch1=l1.getSelectedItem();
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
		Statement st=con.createStatement();
		ResultSet rs1=st.executeQuery("Select * from "+ch1+"");
		while(rs1.next())
		{ ++x; } 
		t.setText(""+(++x));	
		con.close();
		}
		catch(Exception e1){ System.out.println(e1); }
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,900,300,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
		String ch1=l1.getSelectedItem();
		String ch2=l2.getSelectedItem();
		
		String s=t.getText();
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=t5.getText();
		
		if(ch2=="Option_1")
		ch2=s2;
	    else if(ch2=="Option_2")
		ch2=s3;	
		else if(ch2=="Option_3")
		ch2=s4;	
		else if(ch2=="Option_4")
		ch2=s5;	
		
		if(ch1=="Subject")
			JOptionPane.showMessageDialog(null,"Select subject firstly");
		else 
		{
			if(s1.length()<5 || s2.length()<=0 || s3.length()<=0 || s4.length()<=0|| s5.length()<=0)
				JOptionPane.showMessageDialog(null,"Please, Complete all fields.");
			else if(ch2=="None")
		        JOptionPane.showMessageDialog(null,"Select option firstly");
			else
			{
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();	
			st.executeUpdate("insert into "+ch1+" values('"+s+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+ch2+"')");
			JOptionPane.showMessageDialog(null,"Question inserted");
			t.setText("");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			l1.select("Subject");
			l2.select("None");
			con.close();
			}		
			catch(Exception e1) { System.out.println(e1); }
			}
	    }
		}	
	}	
} 
class Search extends JPanel implements ActionListener
{
	JTextField t1;
	JLabel u1,a1,a2,a3,a4,a5,a6;
	JButton b1;
	ImageIcon img1,img2;
	Image i1,i2;
	static Choice l1;
	Search()
	{
		img1=new ImageIcon("black.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("se.jpg");
		i2=img2.getImage();
		
		setLayout(null);
		Font o=new Font("",Font.BOLD,16);
		Font o1=new Font("",Font.BOLD,23);
	    setBackground(new Color(109,163,252));
		
		l1=new Choice();
		l1.setBounds(550,50,150,80);
		add(l1);
		
		t1=new JTextField();
		add(t1);
		t1.setBounds(420,50,120,40);
		t1.setFont(o);
		
		u1=new JLabel("Enter question_no. : ");
		add(u1);
		u1.setBounds(250,50,160,40);
		u1.setFont(o);
		
		b1=new JButton("Search");
		add(b1);
		b1.setBounds(715,50,100,40);
		b1.setFont(o);
		b1.addActionListener(this);
		
		a1=new JLabel();
		a2=new JLabel();
		a3=new JLabel();
		a4=new JLabel();
		a5=new JLabel();
		a6=new JLabel();
		
		a1.setBounds(200,150,1000,60);
		a2.setBounds(300,210,400,60);
		a3.setBounds(300,270,400,60);
		a4.setBounds(300,330,400,60);
		a5.setBounds(300,390,400,60);
		a6.setBounds(300,450,0,60);
		
		a1.setFont(o1);
		a2.setFont(o1);
		a3.setFont(o1);
		a4.setFont(o1);
		a5.setFont(o1);
		a6.setFont(o1);
		l1.setFont(o1);
		
		add(a1);
		add(a2);
		add(a3);
		add(a4);
		add(a5);
		add(a6);
		
		u1.setForeground(Color.white);
		a1.setForeground(Color.white);
		a2.setForeground(Color.white);
		a3.setForeground(Color.white);
		a4.setForeground(Color.white);
		a5.setForeground(Color.white);
		a6.setForeground(Color.white);
	
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=t1.getText();
		String s2=l1.getSelectedItem();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	    Statement st=con.createStatement();
		if(s1.length()>=0 && s2!="Subject")
		{
		ResultSet rs=st.executeQuery("select * from "+s2+" where qno="+s1+" ");
	    if(rs.next())
		{
			a1.setText("Question - "+rs.getString(2));
			a2.setText("Option 1) "+rs.getString(3));
			a3.setText("Option 2) "+rs.getString(4));
			a4.setText("Option 3) "+rs.getString(5));
			a5.setText("Option 4) "+rs.getString(6));
			a6.setText("Correct - "+rs.getString(7));
		}
		else
		JOptionPane.showMessageDialog(null,"Question not found");
		}
		else
		JOptionPane.showMessageDialog(null,"Please, fill the field or select subject firstly");
		con.close();
		t1.setText("");
		l1.select("Subject");
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,850,300,this);
	}
}
class ShowAll extends JPanel implements ActionListener
{
	int y=0,x=1;
	ImageIcon img1;
	Image i1;
    JTable j1;
	String s1[]={"Q_No","Question","Option_1","Option_2","Option_3","Option_4","Correct"};
	String s2[][]=new String[100][7];
	static Choice c;
	JLabel l1;
	JScrollPane sp;
    Font f2=new Font("",Font.BOLD,13);
    Font o=new Font("",Font.BOLD,23);
	JButton b1;
	ShowAll()
	{
	setLayout(null);
	j1=new JTable(s2,s1);
    sp=new JScrollPane(j1);
    sp.setBounds(50,100,1200,400);
	j1.setPreferredScrollableViewportSize(new Dimension(1200,800));
	j1.setFont(f2);
	
	img1=new ImageIcon("black.jpg");
	i1=img1.getImage();
	
	l1=new JLabel("Select subject - ");
	l1.setBounds(350,40,200,50);
	add(l1);
	l1.setFont(o);
	l1.setForeground(Color.white);
	
	c=new Choice();
	c.setBounds(550,50,150,50);
	add(c);
	c.setFont(o);
	
	b1=new JButton("Search");
	add(b1);
	b1.setBounds(720,50,120,35);
	b1.addActionListener(this);
	b1.setFont(o);
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s=c.getSelectedItem();
		y=0;
        if(s=="Subject")		
			JOptionPane.showMessageDialog(null,"Select subject firstly");
		else 
		{
			try
		    {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
		    ResultSet rs1=st.executeQuery("select * from "+s+"");
			if(!rs1.next())
				JOptionPane.showMessageDialog(null,"Database of "+s+" is empty.");
		    ResultSet rs2=st.executeQuery("select * from "+s+"");
		    while(rs2.next())
		    {
            add(sp);
			s2[y][0]=rs2.getString(1);
			s2[y][1]=rs2.getString(2);
			s2[y][2]=rs2.getString(3);
			s2[y][3]=rs2.getString(4);
			s2[y][4]=rs2.getString(5);
			s2[y][5]=rs2.getString(6);
			s2[y][6]=rs2.getString(7);
			y++;
			}
			con.close();
		}
		catch(Exception e1)
		{ System.out.println(e1); }
		}	
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
}
class Update extends JPanel implements ActionListener
{
	JTextArea t1;
	JTextField t2,t3,t4,t5,t6;
	JLabel u1,u2,u3,u4,u5,u6,u7;
	JButton b1,b2;
	ImageIcon img1,img2;
	Image i1,i2;
	static Choice c;
	Choice l2;
	int count=0;
	Update()
	{
		img1=new ImageIcon("black.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("u2.png");
		i2=img2.getImage();
		setBackground(new Color(109,163,252));
		setLayout(null);
		Font o=new Font("",Font.BOLD,23);
		Font o1=new Font("",Font.BOLD,15);
		
		l2=new Choice();
		l2.add("None");
		l2.add("Option_1");
		l2.add("Option_2");
		l2.add("Option_3");
		l2.add("Option_4");
		
		t1=new JTextArea();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		
		u1=new JLabel("1.");
		u2=new JLabel("2.");
		u3=new JLabel("3.");
		u4=new JLabel("4.");
		u6=new JLabel("Correct Option:");
		u7=new JLabel("Question_no.");
		
		b2=new JButton("Update");
		add(b2);
		b2.setBounds(500,500,130,45);
		b2.addActionListener(this);
		
		b1=new JButton("Search");
		add(b1);
		b1.setBounds(280,50,120,35);
		b1.addActionListener(this);
		
		c=new Choice();
	    c.setBounds(420,50,150,50);
	    add(c);
	    c.setFont(o);
		
	    t1.setLineWrap(true);
		t1.setBorder(BorderFactory.createLineBorder(Color.gray));
		t1.setBounds(100,100,650,100);
		t2.setBounds(200,220,550,50);
		t3.setBounds(200,290,550,50);
		t4.setBounds(200,360,550,50);
		t5.setBounds(200,430,550,50);
		t6.setBounds(200,55,60,30);
		
		l2.setBounds(300,510,180,50);
		u1.setBounds(130,220,70,50);
		u2.setBounds(130,290,70,50);
		u3.setBounds(130,360,70,50);
		u4.setBounds(130,430,70,50);
		u6.setBounds(100,500,180,50);
		u7.setBounds(100,50,100,40);
		
		u1.setForeground(Color.white);
		u2.setForeground(Color.white);
		u3.setForeground(Color.white);
		u4.setForeground(Color.white);
		u6.setForeground(Color.white);
		u7.setForeground(Color.white);

		add(l2);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(u1);
		add(u2);
		add(u3);
		add(u4);
		add(u6);
		add(u7);
		
		l2.setFont(o);
		t1.setFont(o);
		t2.setFont(o);
		t3.setFont(o);
		t4.setFont(o);
		t5.setFont(o);
		t6.setFont(o1);
		
		u1.setFont(o);
		u2.setFont(o);
		u3.setFont(o);
		u4.setFont(o);
		u6.setFont(o);
		u7.setFont(o1);
		b1.setFont(o1);
		b2.setFont(o);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,800,200,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String a1,a2,a3,a4,a5,a6;
		String s1=c.getSelectedItem();
		String s2=t6.getText();
			 
		 if(e.getSource()==b1)
		{
			
			if(s1=="Subject")
			JOptionPane.showMessageDialog(null,"Select subject firstly");
		    else if(s2.length()<=0)
			JOptionPane.showMessageDialog(null,"Please fill the field");
			else
			{
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from "+s1+" where qno="+s2+"");
			if(rs.next())
			{
		      a1=rs.getString(2);
			  a2=rs.getString(3);
			  a3=rs.getString(4);
		      a4=rs.getString(5);
			  a5=rs.getString(6);
			  a6=rs.getString(7);
			  t6.setText(rs.getString(1));
			  t1.setText(a1);
			  t2.setText(a2);
			  t3.setText(a3);
			  t4.setText(a4);
			  t5.setText(a5);
				if(a6.equals(a2))
					a6="Option_1";
				else if(a6.equals(a3))
					a6="Option_2";
				else if(a6.equals(a4))
					a6="Option_3";
				else if(a6.equals(a5))
					a6="Option_4";
				con.close();
			}
			else 
			JOptionPane.showMessageDialog(null,"Question_no not found in database");
	        }
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			}
		}
		
		if(e.getSource()==b2)
		{
			a1=t1.getText();
			a2=t2.getText();
			a3=t3.getText();
			a4=t4.getText();
			a5=t5.getText();
			a6=l2.getSelectedItem();
			
			if(a6=="Option_1")
			a6=a2;
	    	else if(a6=="Option_2")
	 		a6=a3;
	     	else if(a6=="Option_3")
	 		a6=a4;
		    else if(a6=="Option_4")
			a6=a5;
		    else
			JOptionPane.showMessageDialog(null,"Select option firstly");
		
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
			if(a1.length()>=1 && a2.length()>=1 && a3.length()>=1 && a4.length()>=1 && a5.length()>=1)
			{
				st.executeUpdate("update "+s1+" set ques='"+a1+"',o1='"+a2+"',o2='"+a3+"',o3='"+a4+"',o4='"+a5+"',ans='"+a6+"' where qno="+s2+" ");
				JOptionPane.showMessageDialog(null,"DATA UPDATED..");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				l2.select("None");
			}
			else
				JOptionPane.showMessageDialog(null,"Firstly inserted some data..");
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		}
	 
	}
}
class Delete extends JPanel implements ActionListener
{
	JTextField t1;
	JLabel u1;
	JButton b1;
	ImageIcon img1,img2;
	Image i1,i2;
	static Choice c;
	Delete()
	{
		img1=new ImageIcon("black.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("u3.png");
		i2=img2.getImage();
		
		setLayout(null);
		Font o=new Font("",Font.BOLD,19);
		Font o1=new Font("",Font.BOLD,23);
	    setBackground(new Color(109,163,252));
		
		t1=new JTextField();
		add(t1);
		t1.setBounds(510,50,100,35);
		t1.setFont(o);
		
		c=new Choice();
	    c.setBounds(620,50,150,50);
	    add(c);
	    c.setFont(o1);
		
		u1=new JLabel("Enter question_no. : ");
		add(u1);
		u1.setBounds(300,50,220,40);
		u1.setFont(o);
		u1.setForeground(Color.white);
		
		b1=new JButton("Delete");
		add(b1);
		b1.setBounds(510,125,100,40);
		b1.setFont(o);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=c.getSelectedItem();
		String s2=t1.getText();
	    
		if(s1=="Subject")
		JOptionPane.showMessageDialog(null,"Select subject firstly");
		else if(s2.length()<=0)
		JOptionPane.showMessageDialog(null,"Please fill the field");
		else
		{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	    Statement st=con.createStatement();
		int x=st.executeUpdate("delete from "+s1+" where qno="+s2+"");
	    if(x>0)
	    JOptionPane.showMessageDialog(null,"Data deleted..");
	    else		
	    JOptionPane.showMessageDialog(null,"Data not found..");
		t1.setText("");
		}
		catch(Exception e1)
		{ System.out.println(e1); }
		}
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,0,187,this);
	}
}

