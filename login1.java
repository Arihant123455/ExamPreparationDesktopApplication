import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class login1 extends JPanel
{
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	ImageIcon img1,img2,img3;
	Image i1,i2,i3;
	login1(FDemo f1)
	{
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("login.png");
		i2=img2.getImage();
		img3=new ImageIcon("back.png");
		i3=img3.getImage();
		
		setLayout(null);
		Font f=new Font("Arial Rounded MT Bold",Font.BOLD,18);
     	setBackground(new Color(109,163,252));
		l1=new JLabel("Enter admin id : ");
		l2=new JLabel("Enter Password : ");
		t1=new JTextField();
		t2=new JPasswordField();
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		b2=new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		l1.setBounds(370,200,180,40);
		l2.setBounds(370,250,180,40);
		t1.setBounds(580,200,240,40);
		t2.setBounds(580,250,240,40);
		b1.setBounds(525,310,120,60);
		b2.setBounds(20,20,60,60);
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		l1.setFont(f);
		l2.setFont(f);
		t1.setFont(f);
		t2.setFont(f);
		b1.setFont(f);
		b2.setFont(f);
		
		b1.addActionListener(f1);
		b2.addActionListener(f1);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,525,310,this);
		g.drawImage(i3,20,20,this);
	}
}