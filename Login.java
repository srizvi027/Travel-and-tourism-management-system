package travel.and.tourism.management.system;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signup, forgetpassword, login;
    JTextField jt,jp;
    JLabel  username,rtext,password;

    Login() {
        setSize(900, 350);
        setLocation(400, 200);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(101, 173, 255));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 50, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        username = new JLabel("Username");
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        p2.add(username);

        jt = new JTextField();
        jt.setBounds(60, 60, 300, 30);
        jt.setBorder(BorderFactory.createEmptyBorder());
        p2.add(jt);

        password = new JLabel("Password");
        password.setBounds(60, 110, 100, 25);
        password.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        p2.add(password);

        jp = new JTextField();
        jp.setBounds(60, 150, 300, 30);
        jp.setBorder(BorderFactory.createEmptyBorder());
        p2.add(jp);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(121, 174, 255));
        login.setBorder(new LineBorder(new Color(0, 101, 255)));
        login.setForeground(Color.white);
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign up");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(121, 174, 255));
        signup.setBorder(new LineBorder(new Color(0, 101, 255)));
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        p2.add(signup);

        forgetpassword = new JButton("Forget Password");
        forgetpassword.setBounds(132, 240, 130, 30);
        forgetpassword.setBackground(new Color(121, 174, 255));
        forgetpassword.setBorder(new LineBorder(new Color(0, 101, 255)));
        forgetpassword.setForeground(Color.white);
        forgetpassword.addActionListener(this);
        p2.add(forgetpassword);

        rtext = new JLabel("Trouble in Login");
        rtext.setBounds(300, 245, 150, 20);
        rtext.setForeground(Color.red);
        p2.add(rtext);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            try{
                String username = jt.getText();
                String password = jp.getText();
                String query = "Select * from account where username = '"+username+"'AND password ='"+password+"'";
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Email or Password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }


        else if(ae.getSource() == signup)
        {

            setVisible(false);
            new Signup();

        }
        else if(ae.getSource() == forgetpassword)
        {
            setVisible(false);
            new ForgetPassword();
        }

    }
    public static void main (String[]args)
    {
        new Login();


    }

}