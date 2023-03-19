package travel.and.tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener{

    JLabel username;
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;

    JButton Search,Retrieve,Back;

    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/forgotpassword.jpg"));
        Image i2= i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1= new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,25);
        username.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        p1.add(username);

        tfusername =new JTextField();
        tfusername.setBounds(220,20,140,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        Search = new JButton("search");
        Search.setBackground(new Color(147, 147, 147));
        Search.setForeground(new Color(255, 255, 255));
        Search.setBounds(380,20,100,25);
        Search.addActionListener(this);
        p1.add(Search);

        JLabel name = new JLabel("Name");
        name.setBounds(40,60,100,25);
        name.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        p1.add(name);

        tfname =new JTextField();
        tfname.setBounds(220,60,140,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel question = new JLabel("Security Question");
        question.setBounds(40,100,150,25);
        question.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        p1.add(question);

        tfquestion =new JTextField();
        tfquestion.setBounds(220,100,140,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel answer = new JLabel("Answer");
        answer.setBounds(40,140,150,25);
        answer.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        p1.add(answer);

        tfanswer =new JTextField();
        tfanswer.setBounds(220,140,140,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        Retrieve = new JButton("Retrieve");
        Retrieve.setBackground(new Color(147, 147, 147));
        Retrieve.setForeground(new Color(255, 255, 255));
        Retrieve.setBounds(380,140,100,25);
        Retrieve.addActionListener(this);
        p1.add(Retrieve);

        JLabel password = new JLabel("Password");
        password.setBounds(40,180,150,25);
        password.setFont(new Font("Baskerville Old Face",Font.PLAIN,20));
        p1.add(password);

        tfpassword =new JTextField();
        tfpassword.setBounds(220,180,140,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        Back = new JButton("Back");
        Back.setBackground(new Color(147, 147, 147));
        Back.setForeground(new Color(255, 255, 255));
        Back.setBounds(150,230,100,25);
        Back.addActionListener(this);
        p1.add(Back);


        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Search){
            System.out.println(tfusername.getText());
            try{
                String query = "Select * from account where username = '"+tfusername.getText()+"'";
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfpassword.setText(rs.getString("password"));
                    System.out.println(rs.getString("name"));
                    rs.getString("security");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==Retrieve){

        }else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new ForgetPassword();
    }
}
