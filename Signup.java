package travel.and.tourism.management.system;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Choice;
import java.awt.event.ActionListener;


public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfasnwer;
   //Choice security;

    JComboBox c1;

    Signup() {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JPanel p1 = new JPanel();
        p1.setBackground(new Color(174, 199, 255));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);

        tfusername = new JTextField() ;
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);

        tfname = new JTextField() ;
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);

        tfpassword = new JTextField() ;
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblsecurityQ = new JLabel("Security Question");
        lblsecurityQ.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurityQ.setBounds(50,140,125,25);
        p1.add(lblsecurityQ);

        /*security = new Choice();
        security.add("What is your Father name?");
        security.add("Favorite charachter from Mismatched?");
        security.add("Your Lucky number");
        security.setBounds(190,140,180,25);
        p1.add(security);*/

        String security[] = {"Who is your favorite charachter in mismatched?","What is your lucky number?","What is your father name?"};
        c1 = new JComboBox(security);
        c1.setBounds(190,140,180,22);
        p1.add(c1);
        System.out.println(c1);




        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);

        tfasnwer = new JTextField() ;
        tfasnwer.setBounds(190,180,180,25);
        tfasnwer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfasnwer);

        create = new JButton("Create");
        create.setBackground(new Color(0x0000C4));
        create.setForeground(Color.white);
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(new Color(0x0000C4));
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signup2.png"));
        Image i2 = i1.getImage().getScaledInstance(300,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);



        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String Question = c1.getActionCommand();
            String Answer = tfasnwer.getText();

            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+c1+"','"+Answer+"')";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account created Successfully");
                setVisible(false);
                new Login();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }

    }


    public static void main(String[] args) {
        new Signup();
    }
}