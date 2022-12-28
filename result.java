import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class result extends JPanel
{
	static JLabel l3,l4,l5,l6;
	JLabel l2;
	int count;
	JButton b1;
	String s1,s2;
	ImageIcon img1,img2,img3;
	Image i1,i2,i3;
	Font o1=new Font("Arial Rounded MT Bold",Font.BOLD,22);
	Font o2=new Font("Arial Rounded MT Bold",Font.BOLD,40);
	result(FDemo f)
	{
	    img3=new ImageIcon("back.png");
		i3=img3.getImage();
		img1=new ImageIcon("result.jpg");
		i1=img1.getImage();
		
		setLayout(null);
		
		l2=new JLabel("Result");
		l2.setForeground(Color.white);
		add(l2);
		l2.setBounds(530,0,200,200);
		l2.setFont(o2);
		
		l3=new JLabel("Total questions -  ");
		l3.setForeground(Color.white);
		add(l3);
		l3.setBounds(650,100,400,200);
		l3.setFont(o1);
		
		l4=new JLabel("Correct answers -  ");
		l4.setForeground(Color.white);
		add(l4);
		l4.setBounds(650,150,400,200);
		l4.setFont(o1);
		
		l5=new JLabel("Wrong answers -  ");
		l5.setForeground(Color.white);
		add(l5);
		l5.setBounds(650,200,400,200);
		l5.setFont(o1);
		
		l6=new JLabel("Total score -  ");
		l6.setForeground(Color.white);
		add(l6);
		l6.setBounds(650,250,400,200);
		l6.setFont(o1);
		
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		add(b1);
		b1.setBounds(20,20,60,60);
		b1.setFont(o1);
		b1.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	    g.drawImage(i3,20,20,this);
	}
}