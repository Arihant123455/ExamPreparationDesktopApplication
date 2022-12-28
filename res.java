import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class res extends JPanel
{
	static int y=0,x=1;
	ImageIcon img1,img2;
	Image i1,i2;
    JTable j1;
	JButton b1;
	static String s1[]={"Name","Subject","Correct_ans","Wrong_ans"};
	static String s2[][]=new String[100][4];
	static JScrollPane sp;
    Font f2=new Font("",Font.BOLD,13);
    Font o=new Font("",Font.BOLD,23);
	res(FDemo f)
	{
	setLayout(null);
	j1=new JTable(s2,s1);
    sp=new JScrollPane(j1);
    sp.setBounds(200,100,800,400);
	j1.setBackground(Color.pink);
	add(sp);
	j1.setPreferredScrollableViewportSize(new Dimension(1200,800));
	j1.setFont(f2);

	img1=new ImageIcon("b1.jpg");
	i1=img1.getImage();
	img2=new ImageIcon("back.png");
	i2=img2.getImage();
	
	b1=new JButton();
	b1.setOpaque(false);
	b1.setContentAreaFilled(false);
	b1.setBorderPainted(false);
	add(b1);
	b1.setForeground(Color.white);
	b1.setBounds(20,20,60,60);
	b1.addActionListener(f);
	results();
	}	
	static public void results()
	{
		x=0;
		y=0;
		try
		    {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
			Statement st=con.createStatement();
		    ResultSet rs2=st.executeQuery("select * from rev");
		    while(rs2.next())
		    {
			s2[y][0]=rs2.getString(1);
			s2[y][1]=rs2.getString(2);
			s2[y][2]=rs2.getString(3);
			s2[y][3]=rs2.getString(4);
			y++;
			}
			con.close();
		}
		catch(Exception e1)
		{ System.out.println(e1); }
	}
	public void paintComponent(Graphics g)
	{
		g.drawImage(i1,0,0,this);
		g.drawImage(i2,20,20,this);
	}
}