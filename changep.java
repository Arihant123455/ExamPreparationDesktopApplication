import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class changep extends JPanel implements ActionListener
{
	JButton b1,b2;
	JLabel l1,l2;
	JPasswordField p1,p2;
	ImageIcon img1,img3;
	Image i1,i3;
	changep(FDemo f)
	{
		setLayout(null);
		Font o=new Font("Bookman Old Style",Font.BOLD,18);
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
		
		l1=new JLabel("Enter previous password - ");
		l1.setBounds(300,150,250,80);
		add(l1);
		l1.setForeground(Color.white);
		l1.setFont(o);
		
		l2=new JLabel("Enter new password -");
		add(l2);
		l2.setBounds(300,210,250,80);
		l2.setForeground(Color.white);
		l2.setFont(o);
		
		p1=new JPasswordField();
		p1.setBounds(570,170,220,45);
		add(p1);
		p1.setFont(o);
		
		p2=new JPasswordField();
		p2.setBounds(570,230,220,45);
		add(p2);
		p2.setFont(o);
		
		b1=new JButton("Change");
		add(b1);
		b1.setBounds(465,300,120,40);
		b1.setFont(o);
		
		b1.addActionListener(this);
		b2.addActionListener(f);
		
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i3,20,20,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=p1.getText();
		String s2=p2.getText();
		
		if(s1.length()<=0 && s2.length()<=0)
			JOptionPane.showMessageDialog(null,"Please fill the fields");
		else
		{
			  try{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
			int x=st.executeUpdate("update admin set upass='"+s2+"' where upass='"+s1+"' ");
			if(x!=0)
			JOptionPane.showMessageDialog(null,"Password changed");
		    else 
			JOptionPane.showMessageDialog(null,"Password doesn't match");
			p1.setText("");
			p2.setText("");
			con.close();
			}
			catch(Exception e1) { System.out.println(e1); }
		}
	}
}
// https://onlinepngtools.com/resize-png
// https://lovepik.com/download/detail/400489615?byso=1&type=0