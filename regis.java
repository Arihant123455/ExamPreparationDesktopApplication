import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class regis extends JPanel implements ActionListener
{
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField tx1,tx3,tx4,tx5;
	JPasswordField tx2;
	ImageIcon img1,img2,img3;
	Image i1,i2,i3;
	JRadioButton r1,r2;
	ButtonGroup bg;
	Choice c1,c2,c3;
	regis(FDemo f)
	{
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("regis.png");
		i2=img2.getImage();
		img3=new ImageIcon("back.png");
		i3=img3.getImage();
		
		setBackground(new Color(109,163,252));
		setLayout(null);
		Font o=new Font("Arial Rounded MT Bold",Font.BOLD,18);
		l1=new JLabel("Enter Name: ");
		l2=new JLabel("Enter Password: ");
		l3=new JLabel("Enter Contact no.:");
		l4=new JLabel("Enter Email address:");
		l5=new JLabel("Select Gender:");
		l6=new JLabel("Enter DOB");
		l7=new JLabel("Enter Address:");
		r1=new JRadioButton("Female");
		r2=new JRadioButton("Male");
		r1.setBackground(Color.black);
		r2.setBackground(Color.black);
		r1.setForeground(Color.white);
		r2.setForeground(Color.white);
		
		tx1=new JTextField();
		tx2=new JPasswordField();
		tx3=new JTextField();
		tx4=new JTextField();
		tx5=new JTextField();
		b1=new JButton();
		b2=new JButton();
		bg=new ButtonGroup();
		c1=new Choice();
		c2=new Choice();
		c3=new Choice();
		bg.add(r1);
		bg.add(r2);
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		l5.setForeground(Color.white);
		l6.setForeground(Color.white);
		l7.setForeground(Color.white);
		// r1.setForeground(Color.white);
		// r2.setForeground(Color.white);
		
		l1.setBounds(300,100,180,40);
		l2.setBounds(300,150,180,40);
		l3.setBounds(300,200,180,40);
		l4.setBounds(300,250,210,40);
		l5.setBounds(300,300,210,40);
		l6.setBounds(300,350,210,40);
		l7.setBounds(300,400,210,40);
		tx1.setBounds(530,100,240,40);
		tx2.setBounds(530,150,240,40);
		tx3.setBounds(530,200,240,40);
		tx4.setBounds(530,250,240,40);
		tx5.setBounds(530,400,240,40);
		r1.setBounds(530,300,100,40);
		r2.setBounds(650,300,100,40);
		c1.setBounds(530,350,60,40);
		c2.setBounds(600,350,60,40);
		c3.setBounds(670,350,100,40);
		c1.addItem("0");
		c2.addItem("0");
		c3.addItem("0");
		for(int i=1;i<=31;i++)
		c1.addItem(""+i);
	    for(int i=1;i<=12;i++)
		c2.addItem(""+i);
		for(int i=1900;i<=2022;i++)
		c3.addItem(""+i);
		
		b1.setBounds(430,480,110,40);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		b2.setBounds(20,20,60,60);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
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
		add(b1);
		add(b2);
		add(r1);
		add(r2);
		add(c1);
		add(c2);
		add(c3);
		
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
		b1.setFont(o);
		b2.setFont(o);
		r1.setFont(o);
		r2.setFont(o);
		c1.setFont(o);
		c2.setFont(o);
		c3.setFont(o);
	    b1.addActionListener(this);
	    b2.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,430,480,this);
		g.drawImage(i3,20,20,this);
	}
	public void actionPerformed(ActionEvent e)
	{
	   String s1=tx1.getText();
	   String s2=tx2.getText();
	   String s3=tx3.getText();
	   String s4=tx4.getText();
	   String s5=tx5.getText();
	   String s6;
	   String s7="";
	   if(r1.isSelected())
		   s6="Female";
	   else
		   s6="Male";
	   if(c1.getSelectedItem()!="0" &&c2.getSelectedItem()!="0" &&c3.getSelectedItem()!="0" )
	   {
	   s7=""+c1.getSelectedItem();
	   s7=s7+"/"+c2.getSelectedItem();
	   s7=s7+"/"+c3.getSelectedItem();
	   }
	   else
		   JOptionPane.showMessageDialog(null,"fill date of birth");
	   String s8="";
	   try
	   {
	    if(s1.length()<=0 || s2.length()<=0|| s3.length()<=0|| s4.length()<=0|| s5.length()<=0|| s6.length()<=0|| s7.length()<=2)
	   {
		   JOptionPane.showMessageDialog(null,"Insert data firstly");
	   }
       else 
	   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
       Statement st= con.createStatement();
	   st.executeUpdate("insert into regis value('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
	   tx1.setText("");
	   tx2.setText("");
	   tx3.setText("");
	   tx4.setText("");
	   tx5.setText("");
	   c1.select("0");
	   c2.select("0");
	   c3.select("0");
	   bg.clearSelection();
	   con.close();
	   JOptionPane.showMessageDialog(null,"DATA INSERTED....");
	   }
	   }
	   catch(Exception e1)
	   {
		   System.out.println(e1);
	   }
	}
}