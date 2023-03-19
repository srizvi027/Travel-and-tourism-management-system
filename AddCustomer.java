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

public class AddCustomer extends JFrame implements ActionListener{

    JLabel lblusername,labelusername,lblid,lblnumber,labelname,
            lblname,lblgender,lblcountry,lbladdress,lblemail,lblphoneno;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphoneno;

    JRadioButton Jmale,Jfemale;
    JButton add,back;
    AddCustomer(String username){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        lblusername= new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername= new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        lblid= new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        comboid =new JComboBox(new String[]{"National Id Card","Passport"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.white);
        add(comboid);



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

        Jmale = new JRadioButton("Male");
        Jmale.setBounds(220,210,70,25);
        Jmale.setBackground(Color.white);
        add(Jmale);

        Jfemale = new JRadioButton("Female");
        Jfemale.setBounds(300,210,70,25);
        Jfemale.setBackground(Color.white);
        add(Jfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Jmale);
        bg.add(Jfemale);

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

        add =new JButton("Add");
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

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.jpg"));
        Image i2= i1.getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,400);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from account where username= 'shahzan' ");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }


    public static void main(String[] args) {
        new AddCustomer("shahzan");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==add){
        String username = labelusername.getText();
        String id = (String)comboid.getSelectedItem();
        String number=tfnumber.getText();
        String name = labelname.getText();
        String gender = null;
        if(Jmale.isSelected()){
            gender = "Male";
        }else {
            gender = "Female";
        }
        String country=tfcountry.getText();
        String address=tfaddress.getText();
        String phone=tfphoneno.getText();
        String email=tfemail.getText();

        try {
            Conn c = new Conn();
            String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+address+"','"+country+"','"+phone+"','"+email+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Customer details added successfully");
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
