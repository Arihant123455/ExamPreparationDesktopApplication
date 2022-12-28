import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class one extends JPanel implements ActionListener
{
	static String Q;
	JButton b1,b2,b3,b4,b6,b7;
	JLabel l1,l2,l3,t;
	JRadioButton r1,r2,r3,r4;
	ButtonGroup bg;
	int x=930,y=110,k=0,count=1,marks=0;
	static int start=0;
	String s,ans,radio;
	String a1,a2,a3,a4,a5,a6,a7;
    JTextArea c;	
	ImageIcon img1;
	Image i1;
	Timer time;
	int sec=0,min=0;
//==========================================================================================================	
	one(FDemo f)
	{
	setForeground(Color.white);
    setLayout(null);
	Font o=new Font("Arial Rounded MT Bold",Font.BOLD,12);
	
	img1=new ImageIcon("exam.jpg");
	i1=img1.getImage();
	
	b1=new JButton("Start");
	b1.setOpaque(false);
	b1.setContentAreaFilled(false);
	b1.setBorderPainted(false);
	
	b2=new JButton("Previous");
	b2.setOpaque(false);
	b2.setContentAreaFilled(false);
	b2.setBorderPainted(false);
	
	b3=new JButton("Save");
	b3.setOpaque(false);
	b3.setContentAreaFilled(false);
	b3.setBorderPainted(false);
	
	b4=new JButton("Next");
	b4.setOpaque(false);
	b4.setContentAreaFilled(false);
	b4.setBorderPainted(false);
	
	b6=new JButton("Submit");
	b6.setOpaque(false);
	b6.setContentAreaFilled(false);
	b6.setBorderPainted(false);
	
	b1.setForeground(Color.white);
	b2.setForeground(Color.white);
	b3.setForeground(Color.white);
	b4.setForeground(Color.white);
	b6.setForeground(Color.white);
	
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	add(b6);
	
	b1.setBounds(190,460,145,70);
	b2.setBounds(380,460,145,70);
	b3.setBounds(570,460,145,70);
	b4.setBounds(755,460,145,70);
	b6.setBounds(930,460,145,70);

	Font o2=new Font("Arial Rounded MT Bold",Font.BOLD,20);
	b1.setFont(o2);
	b2.setFont(o2);
	b3.setFont(o2);
	b4.setFont(o2);
	b6.setFont(o2);
	
	Font o1=new Font("Arial Rounded MT Bold",Font.BOLD,23);
	t=new JLabel();
	l1=new JLabel();
	l2=new JLabel();
	l3=new JLabel();
	r1=new JRadioButton();
	r2=new JRadioButton();
	r3=new JRadioButton();
	r4=new JRadioButton();
	bg=new ButtonGroup();
	
	bg.add(r1);
	bg.add(r2);
	bg.add(r3);
	bg.add(r4);
	
	t.setBounds(633,50,500,60);
	l1.setBounds(200,100,800,100);
	l2.setBounds(100,70,500,50);
	l3.setBounds(150,50,90,50);
	r1.setBounds(228,275,380,50);
	r2.setBounds(680,280,380,50);
	r3.setBounds(225,370,380,50);
	r4.setBounds(675,372,380,50);
	r1.setForeground(Color.white);
	r2.setForeground(Color.white);
	r3.setForeground(Color.white);
	r4.setForeground(Color.white);
	l1.setForeground(Color.white);
	l3.setForeground(Color.white);
	
	r1.setBackground(Color.black);
	r2.setBackground(Color.black);
	r3.setBackground(Color.black);
	r4.setBackground(Color.black);
	
	l2.setForeground(new Color(128,0,64));
	
	add(l1);
	add(l2);
	add(l3);
	add(r1);
	add(r2);
	add(r3);
	add(r4);
	add(t);
	l1.setText("Question........");
	l3.setText("No.");
	r1.setText("Option_1");
	r2.setText("Option_2");
	r3.setText("Option_3");
	r4.setText("Option_4");
	
	Font o3=new Font("Arial Rounded MT Bold",Font.BOLD,30);
	l1.setFont(o1);
	l2.setFont(o3);
	l3.setFont(o1);
	r1.setFont(o1);
	r2.setFont(o1);
	r3.setFont(o1);
	r4.setFont(o1);
	t.setFont(o2);
	t.setForeground(Color.black);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b6.addActionListener(f);
	
	time=new Timer(1000,new ActionListener()
	{
	public void actionPerformed(ActionEvent e)
	{
	t.setText(String.valueOf(min)+":"+String.valueOf(sec));
	if(sec==60)
	{  
    sec=0;
	min++;
    if(min==20)
	{
	time.stop();  
    JOptionPane.showMessageDialog(null,"Time over");
	}
    }
    sec++;
	}
	});
	}
public void paintComponent(Graphics g)
{
	g.drawImage(i1,0,0,this);
}
public void save()
{
	if(r1.isSelected())
    ans=a3;
    else if(r2.isSelected())
	ans=a4;
    else if(r3.isSelected())
	ans=a5;
	else if(r4.isSelected())
	ans=a6;
    else 
	ans=null;

    if(a2!=null&&a7!=null)
    {
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from result where ques='"+a2+"' ");
	if(rs.next())
	st.executeUpdate("Update result set ans='"+ans+"' where ques='"+a2+"' ");
    else 
	st.executeUpdate("insert into result values('"+a2+"','"+a7+"','"+ans+"')");
	con.close();
	}
	catch(Exception e1){e1.printStackTrace();}
	}
	else return;
}
public void view(String Q)
{		
       save();
	   bg.clearSelection();
       int x=0;
       try{
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///examapp","root","root");
		Statement st=con.createStatement();	
		ResultSet r=st.executeQuery("Select * from "+Q+" ");
		while(r.next())
			x++;
		if(count<=0)
			count=1;
		else if(count>x)
			--count;
		ResultSet rs=st.executeQuery("Select * from "+Q+" where qno="+count+"");
		if(rs.next())
		{
			a1=rs.getString(1);
			a2=rs.getString(2);
			a3=rs.getString(3);
			a4=rs.getString(4);
			a5=rs.getString(5);
			a6=rs.getString(6);
			a7=rs.getString(7);
			
			l3.setText(rs.getString(1)+")");
            l1.setText(rs.getString(2));
            r1.setText(rs.getString(3)); 
            r2.setText(rs.getString(4)); 
            r3.setText(rs.getString(5)); 
            r4.setText(rs.getString(6)); 
		}
		ResultSet rs1=st.executeQuery("select * from result where ques='"+a2+"' ");
		if(rs1.next())
		{
			String v=rs1.getString(3);
			if(a3.equals(v))
			r1.setSelected(true);
			else if(a4.equals(v))
			r2.setSelected(true);
		    else if(a5.equals(v))
			r3.setSelected(true);
		    else if(a6.equals(v))
			r4.setSelected(true);
		    else
			bg.clearSelection();
		}
	   con.close();
	   }
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
}
  public void actionPerformed(ActionEvent e)
  {	
  time.start();
//==========================================================================================================
	if(e.getSource()==b4)
	{
	count++;
	view(Q);
	}
//==========================================================================================================
	if(e.getSource()==b2)
	{
	 --count;
	 view(Q);	 
	}
//==========================================================================================================
	if(e.getSource()==b1)
	{
		Q=tes.c.getSelectedItem();
		bg.clearSelection();
		view(Q);
	}
//=============================================================================================================
   if(e.getSource()==b3)
   {
	save();
   }
//==========================================================================================================
 }
}

                            // 4 4 4 4 4 4 4  
                            // 4 3 3 3 3 3 4   
                            // 4 3 2 2 2 3 4   
                            // 4 3 2 1 2 3 4   
                            // 4 3 2 2 2 3 4   
                            // 4 3 3 3 3 3 4   
                            // 4 4 4 4 4 4 4