import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class intro extends JPanel 
{
	JButton b2,a1,a2;
	ImageIcon img1,img3;
	Image i1,i3;
	static JLabel l1;
	JLabel l2,l3;
	intro(FDemo f)
	{
		setLayout(null);
		Font o=new Font("Comic Sans MS",Font.BOLD,25);
		Font o1=new Font("Comic Sans MS",Font.BOLD,35);
		img1=new ImageIcon("log.jpg");
		i1=img1.getImage();
		img3=new ImageIcon("back.png");
		i3=img3.getImage();
		
		b2=new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBounds(20,20,60,60);
		add(b2);
		b2.addActionListener(f);
		
		a1=new JButton();
		a1.setBounds(310,200,200,200);
		add(a1);
		a1.setOpaque(false);
		a1.setContentAreaFilled(false);
		a1.setBorderPainted(false);
		a1.addActionListener(f);
		
		l1=new JLabel();
		l1.setBounds(430,80,330,70);
		l1.setFont(o1);
		add(l1);
		l1.setForeground(Color.yellow);
		
		a2=new JButton();
		a2.setBounds(650,220,260,180);
		a2.setOpaque(false);
		a2.setContentAreaFilled(false);
		a2.setBorderPainted(false);
		add(a2); 
		a2.addActionListener(f);
		
		l2=new JLabel("Edit profile");
		l2.setBounds(350,420,220,70);
		l2.setFont(o);
		add(l2);
		l2.setForeground(Color.yellow);
		
		l3=new JLabel("Give test");
		l3.setBounds(700,420,220,70);
		l3.setFont(o);
		add(l3);
		l3.setForeground(Color.yellow);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i3,20,20,this);
	}
}