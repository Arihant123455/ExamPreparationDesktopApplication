import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class verify extends JPanel implements ActionListener
{
	String s="";
	String s1,s2,s3,s4;
	String a="Verfied";
	JLabel l0,l1,l2,l3,l4,a1;
	JButton b1,b3,b2;
	ImageIcon img1,img2;
	Image i1,i2;
	Font o=new Font("Arial Rounded MT Bold",Font.BOLD,20);
	Font o1=new Font("Arial Rounded MT Bold",Font.BOLD,25);
	verify()
	{}
	verify(FDemo f1)
	{
		setLayout(null);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("back.png");
		i2=img2.getImage();
		l0=new JLabel();
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		a1=new JLabel("VERIFICATION PAGE");
		
		a1.setBounds(470,70,400,40);
		l0.setBounds(500,200,400,40);
		l1.setBounds(380,200,400,40);
		l2.setBounds(380,250,400,40);
		l3.setBounds(380,300,400,40);
		l4.setBounds(380,350,400,40);
		
		a1.setForeground(Color.white);
		l0.setForeground(Color.white);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		
		add(a1);
		add(l0);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		b2=new JButton("Refresh");
		b2.setBounds(525,140,120,40);
		b2.addActionListener(this);
		add(b2);
	    
		b3=new JButton();
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.setBounds(20,20,60,60);
		b3.addActionListener(f1);
		add(b3);
	
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBounds(525,430,120,40);
		b1.setFont(o);
		b1.addActionListener(this);
		add(b1);
		
		a1.setFont(o1);
		l0.setFont(o);
		l1.setFont(o);
		l2.setFont(o);
		l3.setFont(o);
		l4.setFont(o);
		b2.setFont(o);
		
		view();
	}
	void view()
	{
	    try 
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
            Statement st= con.createStatement();
	     	ResultSet rs=st.executeQuery("select * from regis where verify='"+s+"'");
			if(rs.next())
			{
				b1.setOpaque(true);
		        b1.setContentAreaFilled(true);
		        b1.setBorderPainted(true);
				b1.setText("Verify");
				s1=rs.getString(1);
				s2=rs.getString(2);
				s3=rs.getString(3);
				s4=rs.getString(4);
				l0.setText("");
				l1.setText("Name = "+s1);
				l2.setText("Password = "+s2);
				l3.setText("Contact no. = "+s3);
				l4.setText("Email address ="+s4);
			}
			else
			{
				l0.setText("Data not found");
			}
    		con.close();
    	}
		catch(Exception e1)
		{ System.out.println(e1); }
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try 
	    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
            Statement st= con.createStatement();
	     	st.executeUpdate("Update regis set verify='"+a+"' where name='"+s1+"'");
			JOptionPane.showMessageDialog(null,"Data verified");
			l0.setText("");
			l1.setText("");
			l2.setText("");
			l3.setText("");
			l4.setText("");
			b1.setText("");
			b1.setOpaque(false);
		    b1.setContentAreaFilled(false);
		    b1.setBorderPainted(false);
			b1.removeActionListener(this);
			con.close();
         	}
		   catch(Exception e1)
		   { System.out.println(e1); }
		}
		if(e.getSource()==b2)
		{ view(); }
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,20,20,this);
	}
}