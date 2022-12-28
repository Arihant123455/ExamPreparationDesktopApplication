import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class tes extends JPanel implements ActionListener
{
	JButton b1,b2,b3;
	ImageIcon img1,img3;
	Image i1,i3;
	static Choice c;
	JLabel l,l1,l2,l3,l4;
	FDemo f1;
	Font o=new Font("Bookman Old Style",Font.BOLD,23);
	tes() {}
	tes(FDemo f)
	{
		f1=f;
		setLayout(null);
		img1=new ImageIcon("b1.jpg");
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
		
		c=new Choice();
		c.setBounds(600,110,150,50);
		add(c);
		c.setFont(o);
		
		b1=new JButton("Start");
		b1.setBounds(500,175,120,40);
		add(b1);
		b1.setFont(o);
		b1.addActionListener(this);
		
		l=new JLabel("Select Subject");
		l.setBounds(350,100,220,60);
		add(l);
		l.setFont(o);
		l.setForeground(Color.white);
		
		b3=new JButton();
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.addActionListener(f1);
		b3.setFont(o);
		b3.setBounds(500,450,120,40);
		add(b3);
		
		l1=new JLabel();
		l1.setBounds(300,300,500,40);
		l1.setFont(o);
		l1.setForeground(Color.white);
		add(l1);
		
		l2=new JLabel();
		l2.setBounds(300,350,500,40);
		l2.setFont(o);
		l2.setForeground(Color.white);
		add(l2);
		
		l3=new JLabel();
		l3.setBounds(300,400,800,40);
		l3.setFont(o);
		l3.setForeground(Color.white);
		add(l3);
		
		l4=new JLabel();
		l4.setBounds(450,250,500,40);
		l4.setFont(o);
		l4.setForeground(Color.white);
		add(l4);
		
		page p=new page();
		p.add1(c);
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i3,20,20,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String a=c.getSelectedItem();
		if(a=="Subject")
			JOptionPane.showMessageDialog(null,"Select subject firstly");
  		else
		{
		 try 
		 {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	        Statement st=con.createStatement();
	     	st.executeUpdate("update rev set subj='"+a+"' where name='"+FDemo.s1+"' ");
			con.close();
    	 }
		catch(Exception e1)
		{ System.out.println(e1); }	
		l4.setText("INSTRUCTIONS");
		l1.setText("- All the questions are in MCQ pattern");
		l2.setText("- You have to answer all the questions");
		l3.setText("- Exam will be submitted automatically when time ends");
		b3.setOpaque(true);
		b3.setContentAreaFilled(true);
		b3.setBorderPainted(true);
		b3.setText("OK");
		}
	}
}