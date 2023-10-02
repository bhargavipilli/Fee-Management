import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class managefee extends JFrame implements ActionListener
{
    public static void main(String args[]) throws ClassNotFoundException,SQLException//,NumberFormatException
    {
        JFrame f1=new JFrame("FEE");
        JLabel l1=new JLabel("Fee Report");
        l1.setBounds(220,50,100,30);
        JButton b11=new JButton("Admin Login");
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame f2=new JFrame("Admin Login");
                JLabel l21=new JLabel("Admin Login");
                l21.setBounds(170,75,100,30);
                JLabel l22=new JLabel("Name : ");
                l22.setBounds(100,125,100,30);
                JLabel l23=new JLabel("Password : ");
                l23.setBounds(100,175,100,30);
                JTextField t21=new JTextField();
                t21.setBounds(225,125,100,30);
                JPasswordField t22=new JPasswordField();
                t22.setBounds(225,175,100,30);
                JButton b21=new JButton("Login");
                b21.setBounds(100,250,100,30);
                JButton b22=new JButton("Back");
                b22.setBounds(250,250,100,30);
                b22.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    f2.setVisible(false);
                }
                });
                f2.add(l21);f2.add(b22);
                f2.add(l22);
                f2.add(l23);
                f2.add(t21);
                f2.add(t22);
                f2.add(b21);
                b21.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String s1=t21.getText();
                        System.out.println(s1);
                        char[] arr=t22.getPassword();
                        String s2=new String(arr);
                        System.out.println(s2);
                        if( s1.contentEquals("Bhargavi") && s2.contentEquals("Bsvr259"))
                        {
                            JFrame f3=new JFrame("Admin Section");
                            JButton b31=new JButton("Add Accountant");
                            b31.setBounds(200,90,150,30);
                            JButton b32=new JButton("View Accountant");
                            b32.setBounds(200,140,150,30);
                            b32.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                JFrame f7=new JFrame("Accountant");
                                JScrollPane spr;
                                JTable t1;
                                int k,j;k=0;j=0;
                                String cols[]={"ID","name","password","email","Contact_No"};
                                String y[][]=new String[5][5];
                                try{
                                    String url= "jdbc:mysql://localhost:3306/fee";
                                    String user="system";
                                    String pw="root";
                                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                                    System.out.println("entered");
                                    Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password  
                                    System.out.println("connected");
                                    String qq="select * from admin";
                                    Statement st=con.createStatement();
                                    ResultSet rt=st.executeQuery(qq);   
                                    while(rt.next())
                                    {   
                                        y[k][j++]=rt.getString("ID");
                                        y[k][j++]=rt.getString("name");
                                        y[k][j++]=rt.getString("password");
                                        y[k][j++]=rt.getString("email");
                                        y[k][j++]=rt.getString("Contact_No");
                                        j=0;
                                        k=k+1;
                                    }
                                    System.out.println("successfully");
                                    rt.close();
                                    st.close();
                                    con.close();
                                    }
                                    catch(Exception er)
                                    {
                                        er.printStackTrace();
                                    }
                                    t1=new JTable(y,cols);
                                    t1.setBounds(30,40,200,300);
                                    spr=new JScrollPane(t1);
                                    f7.add(spr);
                                    f7.setSize(500,400);
                                    f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    f7.setVisible(true);
                        }         
                        }
                        );
                        JButton b33=new JButton("Logout");
                        b33.setBounds(200,190,150,30);
                        b33.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e)
                            {
                                if(e.getSource()==b33)
                                {
                                    f3.setVisible(false);
                                }
                            }
                        });
                        b31.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame f4=new JFrame("Add Accountant");
                                JLabel l46=new JLabel("Accountant Section");
                                l46.setBounds(150,25,200,30);
                                JLabel l45=new JLabel("ID");
                                l45.setBounds(50,75,100,30);
                                JLabel l41=new JLabel("Name :");
                                l41.setBounds(50,125,100,30);
                                JLabel l42=new JLabel("Password :");
                                l42.setBounds(50,175,100,30);
                                JLabel l43=new JLabel("Email :");
                                l43.setBounds(50,225,100,30);
                                JLabel l44=new JLabel("Contact No :");
                                l44.setBounds(50,275,100,30);
                                JTextField t41=new JTextField();
                                t41.setBounds(150,75,150,30);
                                JPasswordField t42=new JPasswordField();
                                t42.setBounds(150,175,150,30);
                                JTextField t43=new JTextField();
                                t43.setBounds(150,125,150,30);         
                                JTextField t44=new JTextField();
                                t44.setBounds(150,225,150,30);
                                JTextField t45=new JTextField();
                                t45.setBounds(150,275,150,30);
                                JButton b41=new JButton("Add Accoutant");
                                b41.setBounds(170,325,200,30);
                                JButton b42=new JButton("Back");
                                b42.setBounds(400,275,100,30);
                                b42.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e)
                                        {
                                            if(e.getSource()==b42)
                                            {
                                                f4.setVisible(false);
                                            }
                                        }   
                                    });
                                b41.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        if(  t41.getText().trim().length()>0 && t42.getText().trim().length()>0 && t43.getText().trim().length()>0 && t44.getText().trim().length()>0 && t45.getText().trim().length()>0)
                                            {
                                            String url= "jdbc:mysql://localhost:3306/fee";
                                            String user="system";
                                            String pw="root";
                                            try{
                                                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                                                    System.out.println("entered");
                                                
                                                    Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password  
                                                    System.out.println("connected");
                                                
                                                    String Qry="INSERT into admin (id,name,password,Email,Contact_No)"+"VALUES (?,?,?,?,?)";
                                                    PreparedStatement pstmt=con.prepareStatement(Qry);
                                                    pstmt.setString(1,t41.getText() );
                                                    pstmt.setString(2,t43.getText());          
                                                    pstmt.setString(3,t42.getText());
                                                    pstmt.setString(4,t44.getText());
                                                    pstmt.setString(5,t45.getText());
                                                    pstmt.execute();
                                                    JOptionPane.showMessageDialog(f4,"Accountant added");
                                                    System.out.println("inserted successfully");
                                                    con.close();
                                                }
                                                 catch(SQLException er)
                                                {
                                                    JOptionPane.showMessageDialog(f4," Enter all the  detials correctly:(");
                                                }
                                                 catch(Exception er)
                                                {
                                                    er.printStackTrace();
                                                }
                                            }
                                    
                                    else{
                                            JOptionPane.showMessageDialog(f4,"   Please fill all detials");
                                            System.out.println("enter detials");
                                        }
                                }
                                });
                                f4.add(l46);
                                f4.add(l45);
                                f4.add(t45);
                                f4.add(l41);
                                f4.add(l42);
                                f4.add(l43);
                                f4.add(l44);
                                f4.add(t41);
                                f4.add(t42);
                                f4.add(t43);
                                f4.add(t44);
                                f4.add(b41);
                                f4.add(b42);
                                f4.setLayout(null);
                                f4.setSize(500,400);
                                f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f4.setVisible(true);
                            }
                            
                        });

                        f3.add(b31);
                        f3.add(b32);
                        f3.add(b33);
                        f3.setLayout(null);
                        f3.setSize(500,400);
                        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        f3.setVisible(true);
                    }
                      else{
                        JLabel fl=new JLabel("Check the name and password once again");
                        fl.setBounds(100,300,400,30);
                        f2.add(fl);
                        //System.out.println("incorrect password or user name");
                        JOptionPane.showMessageDialog(f2,"incorrect password or user name");
                    }
                }
                  });
                f2.setLayout(null);
                f2.setSize(500,400);
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f2.setVisible(true);
                  }
        });
        b11.setBounds(150,125,200,30);
        JButton b12=new JButton("Accountant Login");
        b12.setBounds(150,200,200,30);
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f5=new JFrame("Accountant Section");
                JLabel l51=new JLabel("Accoutant Section");
                l51.setBounds(170,0,200,30);
                JButton b51=new JButton("Add Student");
                b51.setBounds(75,75,150,30);
                b51.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                                JFrame f6=new JFrame("Add Student");         
                                JLabel l61=new JLabel("Roll No");
                                l61.setBounds(50,25,100,30);
                                //add students
                                JLabel l62=new JLabel("Name :");
                                l62.setBounds(50,75,100,30);
                                JLabel l63=new JLabel("Email :");
                                l63.setBounds(50,125,100,30);
                                JLabel l64=new JLabel("Course :");
                                l64.setBounds(50,175,100,30);
                                JLabel l65=new JLabel("Fee :");
                                l65.setBounds(50,225,100,30);
                                JLabel l66=new JLabel("Paid :");
                                l66.setBounds(50,275,100,30);
                                JLabel l67=new JLabel("Due:");
                                l67.setBounds(50,325,200,30);
                                JLabel l68=new JLabel("Address :");
                                l68.setBounds(50,375,100,30);
                                JLabel l69=new JLabel("City :");
                                l69.setBounds(50,425,100,30);
                                JLabel l610=new JLabel("State :");
                                l610.setBounds(50,475,100,30);
                                JLabel l611=new JLabel("Country :");
                                l611.setBounds(50,525,100,30);
                                JLabel l612=new JLabel("Contact No :");
                                l612.setBounds(50,575,100,30);

                                //Textfields
                                JTextField t612=new JTextField();
                                t612.setBounds(150,25,150,30);
                                JTextField t61=new JTextField();
                                t61.setBounds(150,75,150,30);
                                JTextField t62=new JTextField();
                                t62.setBounds(150,175,150,30);
                                JTextField t63=new JTextField();
                                t63.setBounds(150,125,150,30);         
                                JTextField t64=new JTextField();
                                t64.setBounds(150,225,150,30);
                                JTextField t65=new JTextField();
                                t65.setBounds(150,275,150,30);
                                JTextField t66=new JTextField();
                                t66.setBounds(150,325,150,30);
                                JTextField t67=new JTextField();
                                t67.setBounds(150,375,150,30);
                                JTextField t68=new JTextField();
                                t68.setBounds(150,425,150,30);         
                                JTextField t69=new JTextField();
                                t69.setBounds(150,475,150,30);
                                JTextField t610=new JTextField();
                                t610.setBounds(150,525,150,30);
                                JTextField t611=new JTextField();
                                t611.setBounds(150,575,150,30);
                                JButton b61=new JButton("Add Student");
                                b61.setBounds(150,625,150,30);
                                b61.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        if(  t61.getText().trim().length()>0 && t62.getText().trim().length()>0 && t63.getText().trim().length()>0 && t64.getText().trim().length()>0 && t65.getText().trim().length()>0
                                        && t66.getText().trim().length()>0 && t67.getText().trim().length()>0  && t68.getText().trim().length()>0  && t611.getText().trim().length()>0 && t612.getText().trim().length()>0)
                                            {
                                            String url= "jdbc:mysql://localhost:3306/fee";
                                            String user="system";
                                            String pw="root";
                                            try{
                                                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                                                    System.out.println("entered");
                                                
                                                    Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password  
                                                    System.out.println("connected");
                                                
                                                    String Qry="INSERT into student (Roll_no,name,email,course,fee,paid,due,address,city,state,country,contact_no)"+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                                                    PreparedStatement pstmt=con.prepareStatement(Qry);
                                                    pstmt.setString(1,t612.getText() );
                                                    pstmt.setString(2,t61.getText() );
                                                    pstmt.setString(3,t63.getText());          
                                                    pstmt.setString(4,t62.getText());
                                                    pstmt.setString(5,t64.getText());
                                                    pstmt.setString(6,t65.getText());
                                                    pstmt.setString(7,t66.getText());
                                                    pstmt.setString(8,t67.getText());
                                                    pstmt.setString(9,t68.getText());
                                                    pstmt.setString(10,t69.getText());
                                                    pstmt.setString(11,t610.getText());
                                                    pstmt.setString(12,t611.getText());
                                                    pstmt.execute();
                                                    JOptionPane.showMessageDialog(f6,"Student added");
                                                    System.out.println("inserted successfully");
                                                    con.close();
                                                }
                                                 catch(SQLException er)
                                                {
                                                     JOptionPane.showMessageDialog(f6,er.getMessage());
                                                }
                                                 catch(Exception er)
                                                {
                                                    er.printStackTrace();
                                                }
                                            }
                                    
                                    else{
                                               JOptionPane.showMessageDialog(f6,"   Please fill all detials");
                                               System.out.println("enter detials");
                                        }
                                
                                    }

                                   
                                });
                                JButton b62=new JButton("Back");
                                b62.setBounds(350,625,100,30);
                                b62.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        f6.setVisible(false);
                                    }
                                });
                                f6.add(l61);f6.add(t61);
                                f6.add(l62);f6.add(t62);f6.add(b61);
                                f6.add(l63);f6.add(t63);f6.add(b62);
                                f6.add(l64);f6.add(t64);f6.add(t612);
                                f6.add(l65);f6.add(t65);
                                f6.add(l66);f6.add(t66);
                                f6.add(l67);f6.add(t67);
                                f6.add(l68);f6.add(t68);
                                f6.add(l69);f6.add(t69);
                                f6.add(l610);f6.add(t610);
                                f6.add(l611);f6.add(t611);
                                f6.add(l612);
                                f6.setLayout(null);
                                f6.setSize(500,720);
                                f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f6.setVisible(true);
                    }
                });
                JButton b52=new JButton("View Student");
                b52.setBounds(250,75,150,30);
                b52.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                            JFrame f8=new JFrame("Students List");
                            JScrollPane sp;
                            JTable t2;
                            int k,j;k=0;j=0;
                            String cols[]={"Roll_No","Name","Course","Fee","Paid","Due","Address","City","State","Country","Contact_No","Email"};
                            String y[][]=new String[12][12];
                            try{
                                String url= "jdbc:mysql://localhost:3306/fee";
                                String user="system";
                                String pw="root";
                                Class.forName("com.mysql.cj.jdbc.Driver"); 
                                System.out.println("entered");
                                Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password                                      System.out.println("connected");
                                String qq="select * from student";
                                Statement st=con.createStatement();
                                ResultSet rt=st.executeQuery(qq);
                                while(rt.next())
                                    {
                                        
                                        y[k][j++]=rt.getString("Roll_No");
                                        y[k][j++]=rt.getString("name");
                                        y[k][j++]=rt.getString("course");
                                        y[k][j++]=rt.getString("fee");
                                        y[k][j++]=rt.getString("paid");
                                        y[k][j++]=rt.getString("due");
                                        y[k][j++]=rt.getString("address");
                                        y[k][j++]=rt.getString("city");
                                        y[k][j++]=rt.getString("state");
                                        y[k][j++]=rt.getString("country");
                                        y[k][j++]=rt.getString("Contact_No");
                                        y[k][j++]=rt.getString("email");    
                                        j=0;
                                        k=k+1;}
                                      
                                    System.out.println("successfully");
                                    rt.close();
                                    st.close();
                                    con.close();
                                }  
                                catch(Exception er)
                                    {
                                        er.printStackTrace();
                                    }
                                    t2=new JTable(y,cols);
                                    t2.setRowHeight(20);
                                    t2.setBounds(30,40,200,300);
                                    sp=new JScrollPane(t2);
                                    f8.add(sp);
                                    f8.setSize(500,400);
                                    f8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    f8.setVisible(true);
                               
                    }
                });
                JButton b53=new JButton("Edit Student");
                b53.setBounds(75,150,150,30);
                
                                JLabel l72=new JLabel("Name :");
                                l72.setBounds(50,75,100,30);
                                JLabel l73=new JLabel("Email :");
                                l73.setBounds(50,125,100,30);
                                JLabel l74=new JLabel("Course :");
                                l74.setBounds(50,175,100,30);
                                JLabel l75=new JLabel("Fee :");
                                l75.setBounds(50,225,100,30);
                                JLabel l76=new JLabel("Paid :");
                                l76.setBounds(50,275,100,30);
                                JLabel l77=new JLabel("Due:");
                                l77.setBounds(50,325,200,30);
                                JLabel l78=new JLabel("Address :");
                                l78.setBounds(50,375,100,30);
                                JLabel l79=new JLabel("City :");
                                l79.setBounds(50,425,100,30);
                                JLabel l710=new JLabel("State :");
                                l710.setBounds(50,475,100,30);
                                JLabel l711=new JLabel("Country :");
                                l711.setBounds(50,525,100,30);
                                JLabel l712=new JLabel("Contact No :");
                                l712.setBounds(50,575,100,30);
                                //Text fields
                                
                                JTextField t72=new JTextField();
                                t72.setBounds(150,75,150,30);
                                JTextField t73=new JTextField();
                                t73.setBounds(150,125,150,30);         
                                JTextField t74=new JTextField();
                                t74.setBounds(150,175,150,30);
                                JTextField t75=new JTextField();
                                t75.setBounds(150,225,150,30);
                                JTextField t76=new JTextField();
                                t76.setBounds(150,275,150,30);
                                JTextField t77=new JTextField();
                                t77.setBounds(150,325,150,30);
                                JTextField t78=new JTextField();
                                t78.setBounds(150,375,150,30);         
                                JTextField t79=new JTextField();
                                t79.setBounds(150,425,150,30);
                                JTextField t710=new JTextField();
                                t710.setBounds(150,475,150,30);
                                JTextField t711=new JTextField();
                                t711.setBounds(150,525,150,30);
                                JTextField t712=new JTextField();
                                t712.setBounds(150,575,150,30);
                                JButton b72=new JButton("Back");
                                b72.setBounds(350,625,100,30);
                                b53.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                                JFrame f7=new JFrame("Edit Student");         
                                JLabel l71=new JLabel(" Select Roll No");
                                l71.setBounds(50,25,100,30);
                                JTextField t71=new JTextField();
                                t71.setBounds(150,25,100,30);
                                //add students
                                JButton b71=new JButton("Load");
                                b71.setBounds(300,25,100,30);
                                JButton b73=new JButton("Update Student");
                                b73.setBounds(150,625,150,30);
                                b71.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        try{
                                    String url= "jdbc:mysql://localhost:3306/fee";
                                String user="system";
                                String pw="root";
                                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                                    System.out.println("entered");
                                    Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password  
                                    System.out.println("connected");
                                    String ss=(t71.getText());
                                    System.out.println(ss);
                                    String qq="select * from student where Roll_No=?";
                                    System.out.println("lets watch");
                                    PreparedStatement st=con.prepareStatement(qq);
                                    st.setString(1,ss);
                                    ResultSet rt=st.executeQuery();
                                     while(rt.next())
                                    {
                                        System.out.println("in");
                                        t72.setText(rt.getString("name"));
                                        t74.setText(rt.getString("course"));
                                        t75.setText(rt.getString("fee"));
                                        t76.setText(rt.getString("paid"));
                                        t77.setText(rt.getString("due"));
                                        t78.setText(rt.getString("address"));
                                        t79.setText(rt.getString("city"));
                                        t710.setText(rt.getString("state"));
                                        t711.setText(rt.getString("country"));
                                        t712.setText(rt.getString("Contact_No"));
                                        t73.setText(rt.getString("email"));    
                                    
                                     System.out.println("successfully");
                                }
                                        }
                                         catch(SQLException er)
                                                {
                                                     JOptionPane.showMessageDialog(f7,er.getMessage());
                                                }
                                        catch(Exception er)
                                    {
                                        er.printStackTrace();
                                    }
                                    
                                
                                
                                b73.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        if(  t72.getText().trim().length()>0 && t73.getText().trim().length()>0 && t74.getText().trim().length()>0 && t75.getText().trim().length()>0
                                        && t76.getText().trim().length()>0 && t77.getText().trim().length()>0  && t78.getText().trim().length()>0  && t711.getText().trim().length()>0 && t712.getText().trim().length()>0)
                                            {
                                            String url= "jdbc:mysql://localhost:3306/fee";
                                            String user="system";
                                            String pw="root";
                                            try{
                                                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                                                    System.out.println("entered");
                                                
                                                    Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password  
                                                    System.out.println("connected");
                                                
                                                    String Qry="Update student set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contact_no=? where Roll_No=?";
                                                    PreparedStatement pstmt=con.prepareStatement(Qry);
                                                    
                                                    pstmt.setString(12,t71.getText() );
                                                    pstmt.setString(1,t72.getText() );
                                                    pstmt.setString(2,t73.getText());          
                                                    pstmt.setString(3,t74.getText());
                                                    pstmt.setString(4,t75.getText());
                                                    pstmt.setString(5,t76.getText());
                                                    pstmt.setString(6,t77.getText());
                                                    pstmt.setString(7,t78.getText());
                                                    pstmt.setString(8,t79.getText());
                                                    pstmt.setString(9,t710.getText());
                                                    pstmt.setString(10,t710.getText());
                                                    pstmt.setString(11,t711.getText());
                                                    pstmt.execute();
                                                    JOptionPane.showMessageDialog(f7,"Student updated");
                                                    System.out.println("updated successfully");
                                                    con.close();
                                                }
                                                 catch(SQLException er)
                                                {
                                                     JOptionPane.showMessageDialog(f7,er.getMessage());
                                                }
                                                 catch(Exception er)
                                                {
                                                    er.printStackTrace();
                                                }
                                            }
                                    
                                    else{
                                               JOptionPane.showMessageDialog(f7,"   Please fill all detials");
                                               System.out.println("enter detials");
                                        }
                                
                                    }

                                   
                                });
                     } });
                                 b72.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        f7.setVisible(false);
                                    }
                                });
                                f7.add(l71);f7.add(l76);f7.add(b73);
                                f7.add(l72);f7.add(l78);
                                f7.add(l73);f7.add(l79);
                                f7.add(l74);f7.add(l710);
                                f7.add(l75);f7.add(l711);
                                f7.add(l712);f7.add(b71);
                                f7.add(l77);f7.add(t71);
                                f7.add(b72);
                                f7.add(t71);f7.add(t76);
                                f7.add(t72);f7.add(t78);
                                f7.add(t73);f7.add(t79);
                                f7.add(t74);f7.add(t710);
                                f7.add(t75);f7.add(t711);
                                f7.add(t712);f7.add(t77);
                                f7.setLayout(null);
                                f7.setSize(500,720);
                                f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                f7.setVisible(true);
                    }
                });
                JButton b54=new JButton("Due Fee");
                b54.setBounds(250,150,150,30);
                b54.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                            JFrame f9=new JFrame("Due fee");
                            JLabel l91=new JLabel("Enter Roll No :");
                            l91.setBounds(75,100,100,30);
                            JTextField t91=new JTextField();
                            t91.setBounds(200,100,100,30);
                            JLabel l92=new JLabel();
                            l92.setBounds(150,200,200,30);
                            JButton b91=new JButton("Click");
                            b91.setBounds(150,150,100,30);
                            b91.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        try{      
                                String url= "jdbc:mysql://localhost:3306/fee";
                                String user="system";
                                String pw="root";
                                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                                    System.out.println("entered");
                                    Connection con=DriverManager.getConnection(url,user,pw);  //here sonoo is database name, root is username and password  
                                    System.out.println("connected");
                                    String ss=(t91.getText());
                                    String qq="select due from student where Roll_No=?";
                                    System.out.println("lets watch");
                                    PreparedStatement st=con.prepareStatement(qq);
                                    st.setString(1,ss);
                                    ResultSet rt=st.executeQuery();    
                                    while(rt.next())
                                    {
                                        String res=" Due fee "+ rt.getString("due");
                                        l92.setText(res);
                                        System.out.println(res);
                                    }
                                }
                                catch(SQLException er)
                                    {
                                        er.printStackTrace();
                                    }
                             catch(Exception er)
                                    {
                                        er.printStackTrace();
                                    }
                     } });
                            f9.add(l92);
                            f9.add(b91);
                            f9.add(l91);
                            f9.add(t91);
                            f9.setLayout(null);
                            f9.setSize(500,400);
                            f9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            f9.setVisible(true);
                    }
                });
                JButton b55=new JButton("Logout");
                b55.setBounds(170,220,150,30);
                b55.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(e.getSource()==b55)
                        {
                            f5.setVisible(false);
                        }
                    }
                });
                f5.add(l51);
                f5.add(b51);
                f5.add(b52);
                f5.add(b53);
                f5.add(b54);
                f5.add(b55);
                f5.setLayout(null);
                f5.setSize(500,400);
                f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f5.setVisible(true);
            }
        });
        f1.add(l1);
        f1.add(b11);
        f1.add(b12);
        f1.setLayout(null);
        f1.setSize(500,400);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }

                 @Override
                public void actionPerformed(ActionEvent e) {
                   throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
                }

                


}