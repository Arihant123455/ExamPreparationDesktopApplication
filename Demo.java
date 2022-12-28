import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class FDemo extends JFrame implements ActionListener
{
	CardLayout card;
    Container cn=getContentPane();
	login lg;
	login1 lg1;
	admin a;
	one o;
	home hm;
	home1 hm1;
	regis r1;
	page pg;
	result rs;
	verify v;
	course c;
	changep cp;
	intro i;
	profile p;
	res re;
	tes te;
	static String s1;
	FDemo()
	{
		card=new CardLayout();
		setLayout(card);
		
		hm=new home(this);
		add("home",hm);
		
		re=new res(this);
		add("res",re);
		
		rs=new result(this);
		add("result",rs);
		
		o=new one(this);
		add("one",o);
		
		i=new intro(this);
		add("intro",i);
		
		hm1=new home1(this);
		add("home1",hm1);
		
		lg=new login(this);
		add("login",lg);
		
		a=new admin(this);
		add("admin",a);
		
		lg1=new login1(this);
		add("login1",lg1);
		
		v=new verify(this);
		add("verify",v);
		
		r1=new regis(this);
		add("regis",r1);
		
		pg=new page(this);
		add("page",pg);
	
		c=new course(this);
		add("course",c);
		
		cp=new changep(this);
		add("change",cp);
		
		p=new profile(this);
		add("profile",p);
	
		te=new tes(this);
		add("tes",te);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==te.b2)
		{
			card.show(cn,"intro");
			te.l1.setText("");
			te.l2.setText("");
			te.l3.setText("");
			te.l4.setText("");
			te.b3.setText("");
			te.b3.setOpaque(true);
		    te.b3.setContentAreaFilled(true);
		    te.b3.setBorderPainted(true);
		}
		if(e.getSource()==p.b2)
			card.show(cn,"intro");
		if(e.getSource()==i.b2)
			card.show(cn,"login");
		if(e.getSource()==i.a2)
			card.show(cn,"tes");
		if(e.getSource()==i.a1)
		{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	        Statement st=con.createStatement();
	     	ResultSet rs=st.executeQuery("select * from regis where name='"+s1+"'");
			if(rs.next())
			{
				profile.tx1.setText(rs.getString(1));
				profile.tx2.setText(rs.getString(2));
				profile.tx3.setText(rs.getString(3));
				profile.tx4.setText(rs.getString(4));
				profile.tx5.setText(rs.getString(5));
				profile.tx6.setText(rs.getString(6));
				profile.tx7.setText(rs.getString(7));
			}
    		con.close();
    	}
		catch(Exception e1)
		{ System.out.println(e1); }
			card.show(cn,"profile");
		}
		if(e.getSource()==c.b1)
			card.show(cn,"admin");
		if(e.getSource()==cp.b2)
			card.show(cn,"admin");
		if(e.getSource()==a.b2)
			card.show(cn,"page");
		if(e.getSource()==a.b5)
			card.show(cn,"change");
		if(e.getSource()==a.b4)
		{
			res.results();
			card.show(cn,"res");
		}
		if(e.getSource()==a.b6)
			card.show(cn,"login1");
		if(e.getSource()==a.b3)
			card.show(cn,"verify");
		if(e.getSource()==a.b1)
			card.show(cn,"course");
		if(e.getSource()==rs.b1)
			card.show(cn,"login");
		if(e.getSource()==hm.b2)
			card.show(cn,"home1");
		if(e.getSource()==hm1.b1)
			card.show(cn,"login");
		if(e.getSource()==hm.b1)
			card.show(cn,"login1");
		if(e.getSource()==hm1.b3)
			card.show(cn,"home");
		if(e.getSource()==hm1.b2)
			card.show(cn,"regis");
		if(e.getSource()==lg1.b2)
			card.show(cn,"home");
		if(e.getSource()==lg.b2)
			card.show(cn,"home1");
		if(e.getSource()==r1.b2)
			card.show(cn,"home1");
		if(e.getSource()==pg.b1)
			card.show(cn,"admin");
		if(e.getSource()==v.b3)
			card.show(cn,"admin");
		if(e.getSource()==re.b1)
			card.show(cn,"admin");
//=======================================================================================================
		if(e.getSource()==te.b3)
		{
			
			if(te.c.getSelectedItem()=="Subject")
			JOptionPane.showMessageDialog(null,"Select subject firstly");	
            else
			card.show(cn,"one");
		}
//=======================================================================================================
		if(e.getSource()==o.b6)
		{
		String s11="",s2="";
		int count=0,c1=0;
        int response = JOptionPane.showConfirmDialog(null, "Are you sure?\nYou want to submit", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION)  
		{
			try 
		    {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	        Statement st=con.createStatement();
	     	ResultSet rs1=st.executeQuery("select * from result");
			while(rs1.next())
			{
			s11=rs1.getString(2);
		    s2=rs1.getString(3);
			if(s11.equals(s2))
			count++;
		    if(!s11.equals(s2))
			c1++;
			}
			st.executeUpdate("update rev set score='"+count+"', wrong='"+c1+"' where name='"+s1+"' ");
			float a=count;
			float b=count+c1;
			result.l3.setText("Total questions -  "+(count+c1));
			result.l4.setText("Correct answers -  "+count);
			result.l5.setText("Wrong answers -  "+c1);
			result.l6.setText("Total score -  "+(a/b)*100+"%");
	     	con.close();
    	}
		catch(Exception e1)
		{ System.out.println(e1); }	
        card.show(cn,"result");
		}
		}
//=======================================================================================================
		if(e.getSource()==lg.b1)
		{
			s1=lg.t1.getText();
			String s2=lg.t2.getText();
			try
			{
			if(s1.length()<=0 || s2.length()<=0)
			JOptionPane.showMessageDialog(lg1.b1,"Enter data firstly");
			else
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
            Statement st= con.createStatement();
			st.executeUpdate("delete from result");
			ResultSet rs=st.executeQuery("select * from regis where name='"+s1+"' AND password='"+s2+"' AND verify='verfied'");
			if(rs.next())
			{
				card.show(cn,"intro");
				i.l1.setText("WELCOME  \t"+s1);
				ResultSet r=st.executeQuery("select * from rev where name='"+s1+"' ");
				if(!r.next())
				st.executeUpdate("insert into rev(name) values('"+s1+"') ");
			}
			else
			JOptionPane.showMessageDialog(lg.b1,"Invalid username or password");
		
		    lg.t1.setText("");
		    lg.t2.setText("");
			con.close();
			}
			}
			catch(Exception e1){e1.printStackTrace();}
		}
//=======================================================================================================
		if(e.getSource()==lg1.b1)
		{
			String s1=lg1.t1.getText();
			String s2=lg1.t2.getText();
			if(s1.length()<=0 || s2.length()<=0)
			{
				JOptionPane.showMessageDialog(lg1.b1,"Enter data firstly");
			}
		    else
			{
		    try{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
            Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from admin where userid='"+s1+"' AND upass='"+s2+"'");
			if(rs.next())
			card.show(cn,"admin");
			else
			JOptionPane.showMessageDialog(lg1.b1,"Acess denied");
			lg1.t1.setText("");
			lg1.t2.setText("");
			con.close();
			}
			catch(Exception e1) { System.out.println(e1); }
			}
		}
	}
}
class Demo
{
	public static void main(String ar[])
	{
		FDemo f=new FDemo();
		f.setVisible(true);
		//f.setResizable(false);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		Image i=t.getImage("s2.png");
		f.setIconImage(i);
		int x=(d.width-1300)/2;
		int y=(d.height-700)/2;
		f.setBounds(x,y,1300,700);
		f.setTitle("Online Exam Preparation Desktop Application");
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
// C:\Users\win 10\Videos\Capture