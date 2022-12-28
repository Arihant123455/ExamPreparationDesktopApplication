import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class home1 extends JPanel
{
	JButton b1,b2,b3;
	ImageIcon img1;
	Image i1;
	ImageIcon img2;
	Image i2;
	ImageIcon img3;
	Image i3;
	ImageIcon img4;
	Image i4;
	ImageIcon img5;
	Image i5;
	home1(FDemo f)
	{
		img1=new ImageIcon("b1.jpg");
		i1=img1.getImage();
		img2=new ImageIcon("login.png");
		i2=img2.getImage();
		img3=new ImageIcon("regis.png");
		i3=img3.getImage();
		img4=new ImageIcon("back.png");
		i4=img4.getImage();
		
		setLayout(null);
		setBackground(new Color(109,163,252));
		Font o=new Font("Arial Rounded MT Bold",Font.BOLD,15);	
		
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
		
		add(b1);
		add(b2);
		add(b3);
		
		b1.setFont(o);
		b2.setFont(o);
		b3.setFont(o);
		
		b1.setBounds(410,250,130,60);
		b2.setBounds(600,250,130,60);
		b3.setBounds(20,20,60,60);
		
		b1.addActionListener(f);
		b2.addActionListener(f);
		b3.addActionListener(f);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,410,250,this);
		g.drawImage(i3,600,250,this);
		g.drawImage(i4,20,20,this);
	}
}