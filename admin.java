import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class admin extends JPanel
{
	ImageIcon img1,img2,img3;
	Image i1,i2,i3;
	JButton b1,b2,b3,b4,b5,b6;
	JLabel l1,l2,l3,l4,l5,l6;
	admin(FDemo f1)
	{
		setLayout(null);
		Font f=new Font("Arial Rounded MT Bold",Font.BOLD,18);	
		img1=new ImageIcon("v1.jpg");
		i1=img1.getImage();
		
		l1=new JLabel("Add Course");
		l1.setBounds(240,230,200,40);
		l1.setForeground(Color.yellow);
		l1.setFont(f);
		add(l1);
		l2=new JLabel("Manage Course");
		l2.setBounds(540,230,200,40);
		l2.setForeground(Color.yellow);
		l2.setFont(f);
		add(l2);
		l3=new JLabel("Verify student");
		l3.setBounds(865,230,200,40);
		l3.setForeground(Color.yellow);
		l3.setFont(f);
		add(l3);
		l4=new JLabel("Review marks");
		l4.setBounds(240,480,200,50);
		l4.setForeground(Color.yellow);
		l4.setFont(f);
		add(l4);
		l5=new JLabel("Change password");
		l5.setBounds(540,480,200,40);
		l5.setForeground(Color.yellow);
		l5.setFont(f);
		add(l5);
		l6=new JLabel("Logout");
		l6.setBounds(890,480,200,40);
		l6.setForeground(Color.yellow);
		l6.setFont(f);
		add(l6);
		
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		b2=new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		b3=new JButton();
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		
		b4=new JButton();
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		
		b5=new JButton();
		b5.setOpaque(false);
		b5.setContentAreaFilled(false);
		b5.setBorderPainted(false);
		
		b6=new JButton();
		b6.setOpaque(false);
		b6.setContentAreaFilled(false);
		b6.setBorderPainted(false);
		
		b1.setBounds(250,100,180,120);
		b2.setBounds(550,100,180,120);
		b3.setBounds(850,90,180,120);
		b4.setBounds(240,330,180,140);
		b5.setBounds(550,350,180,120);
		b6.setBounds(850,350,180,120);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		b1.addActionListener(f1);
		b2.addActionListener(f1);
		b3.addActionListener(f1);
		b4.addActionListener(f1);
		b5.addActionListener(f1);
		b6.addActionListener(f1);
    }
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
	}
}