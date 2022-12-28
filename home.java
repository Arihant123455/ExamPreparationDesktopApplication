import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class home extends JPanel
{
	JButton b1,b2;
	JLabel l1,l2;
	ImageIcon img1;
	Image i1;
	ImageIcon img2;
	Image i2;
	ImageIcon img3;
	Image i3;
	home(FDemo f)
	{
		setLayout(null);
		Font o=new Font("Bookman Old Style",Font.BOLD,25);
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("p1.png");
		i2=img2.getImage();
		img3=new ImageIcon("p2.png");
		i3=img3.getImage();
		b1=new JButton();
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		
		b2=new JButton();
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		
		l1=new JLabel("Admin");
		l2=new JLabel("Student");
		
		add(l1);
		add(l2);
		add(b1);
		add(b2);
		
		l1.setBounds(450,360,150,80);
		l2.setBounds(670,360,150,80);
		b1.setBounds(420,210,150,150);
		b2.setBounds(620,205,150,150);
		
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		
		l1.setFont(o);
		l2.setFont(o);
		b2.setFont(o);
		b2.setFont(o);
		
		b1.addActionListener(f);
		b2.addActionListener(f);
		
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,400,170,this);
		g.drawImage(i3,620,190,this);
	}
}
//https://onlinepngtools.com/resize-png
//https://lovepik.com/download/detail/400489615?byso=1&type=0