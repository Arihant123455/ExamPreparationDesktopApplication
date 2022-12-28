import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class profile extends JPanel implements ActionListener
{
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	static JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
	ImageIcon img1,img3;
	Image i1,i3;
	String s;
	Font o=new Font("Arial Rounded MT Bold",Font.BOLD,18);
	profile(FDemo f)
	{
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img3=new ImageIcon("back.png");
		i3=img3.getImage();
		
		setLayout(null);
		
		l1=new JLabel("Enter Name: ");
		l2=new JLabel("Enter Password: ");
		l3=new JLabel("Enter Contact no.:");
		l4=new JLabel("Enter Email address:");
		l5=new JLabel("Select Gender:");
		l6=new JLabel("Enter DOB");
		l7=new JLabel("Enter Address:");
		
		tx1=new JTextField();
		tx2=new JTextField();
		tx3=new JTextField();
		tx4=new JTextField();
		tx5=new JTextField();
		tx6=new JTextField();
		tx7=new JTextField();
		
		l1.setBounds(300,100,180,40);
		l2.setBounds(300,150,180,40);
		l3.setBounds(300,200,180,40);
		l4.setBounds(300,250,210,40);
		l5.setBounds(300,300,210,40);
		l6.setBounds(300,350,210,40);
		l7.setBounds(300,400,210,40);
		
		tx1.setBounds(530,100,320,40);
		tx2.setBounds(530,150,320,40);
		tx3.setBounds(530,200,320,40);
		tx4.setBounds(530,250,320,40);
		tx5.setBounds(530,300,320,40);
		tx6.setBounds(530,350,320,40);
		tx7.setBounds(530,400,320,40);
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		l5.setForeground(Color.white);
		l6.setForeground(Color.white);
		l7.setForeground(Color.white);
		
		b1=new JButton("Update");
		b1.setBounds(450,475,150,40);
		b1.setFont(o);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton();
		b2.setBounds(20,20,60,60);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		add(b2);
	    b2.addActionListener(f);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		
		add(tx1);
		add(tx2);
		add(tx3);
		add(tx4);
		add(tx5);
		add(tx6);
		add(tx7);
		
		
		l1.setFont(o);
		l2.setFont(o);
		l3.setFont(o);
		l4.setFont(o);
		l5.setFont(o);
		l6.setFont(o);
		l7.setFont(o);
		
		tx1.setFont(o);
		tx2.setFont(o);
		tx3.setFont(o);
		tx4.setFont(o);
		tx5.setFont(o);
		tx6.setFont(o);
		tx7.setFont(o);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i3,20,20,this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s1 = tx1.getText();
		String s2 = tx2.getText();
		String s3 = tx3.getText();
		String s4 = tx4.getText();
		String s5 = tx5.getText();
		String s6 = tx6.getText();
		String s7 = tx7.getText();
		try
		{
	     Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
		 Statement st=con.createStatement();
		 st.executeUpdate("update regis set name='"+s1+"',password='"+s2+"',contno='"+s3+"',email='"+s4+"',addr='"+s7+"',gender='"+s5+"' where dob="+s6+" ");
		 JOptionPane.showMessageDialog(null,"DATA UPDATED..");
		 tx1.setText("");
		 tx2.setText("");
		 tx3.setText("");
		 tx4.setText("");
		 tx5.setText("");
		 tx6.setText("");
		 tx7.setText("");
		}
		catch(Exception e5)
		{
			JOptionPane.showMessageDialog(null,e5);
		}
	}
}