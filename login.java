import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class login extends JPanel 
{
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	static String s1;
	Checkbox cb1;
	ImageIcon img1,img2,img3;
	Image i1,i2,i3;
	login(FDemo f1)
	{
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("login.png");
		i2=img2.getImage();
		img3=new ImageIcon("back.png");
		i3=img3.getImage();
		
		setLayout(null);
		Font f=new Font("Arial Rounded MT Bold",Font.BOLD,15);
		Font o1=new Font("Arial Rounded MT Bold",Font.BOLD,20);
	    setBackground(new Color(109,163,252));
		
		l1=new JLabel("Enter user name : ");
		l2=new JLabel("Enter Password : ");
		t1=new JTextField();
		t2=new JPasswordField();
		
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		b2=new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		cb1=new Checkbox("show password");
		if(cb1.getState())
		t2.setEchoChar((char)0);
			
		l1.setBounds(380,200,180,40);
		l2.setBounds(380,250,200,40);
		t1.setBounds(580,200,200,40);
		t2.setBounds(580,250,200,40);
		
		b1.setBounds(520,310,160,70);
		b2.setBounds(20,20,60,60);
		
		cb1.setBounds(580,300,160,30);
	//	add(cb1);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		
		l1.setFont(o1);
		l2.setFont(o1);
		t1.setFont(o1);
		t2.setFont(o1);
		b1.setFont(f);
		b2.setFont(f);
		cb1.setFont(f);
	    b1.addActionListener(f1);
		b2.addActionListener(f1);
	}
	void show(String s)
	{
		this.s1=s;
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,520,310,this);
		g.drawImage(i3,20,20,this);
	}
}