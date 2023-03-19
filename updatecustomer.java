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

public class updatecustomer extends JFrame implements ActionListener{

    JLabel lblusername,labelusername,lblid,lblnumber,labelname,
            text,lblname,lblgender,lblcountry,lbladdress,lblemail,lblphoneno;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphoneno,tfid,tfgender;

    JRadioButton Jmale,Jfemale;
    JButton add,back;
    updatecustomer(String username){
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        text = new JLabel("Update Customer Details");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahuma",Font.PLAIN,20));
        add(text);

        lblusername= new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername= new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        lblid= new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        tfid= new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);



        lblnumber= new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfnumber= new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);


        lblname= new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        labelname= new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        lblgender= new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);

        tfgender= new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);



        lblcountry= new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        tfcountry= new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        lbladdress= new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress= new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        lblemail= new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);

        tfemail= new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);

        lblphoneno= new JLabel("Phone Number");
        lblphoneno.setBounds(30,370,150,25);
        add(lblphoneno);

        tfphoneno= new JTextField();
        tfphoneno.setBounds(220,370,150,25);
        add(tfphoneno);

        add =new JButton("Update");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back =new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i2= i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username= '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphoneno.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }


    public static void main(String[] args) {
        new updatecustomer("shahzan");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==add){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number=tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphoneno.getText();
            String email=tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id ='"+id+"', number ='"+number+"', name='"+name+"', gender='"+gender+"', country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer details updated successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else{
            setVisible(false);
        }

    }
}


