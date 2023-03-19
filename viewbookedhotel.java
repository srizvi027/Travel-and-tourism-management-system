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

public class viewbookedhotel extends JFrame implements ActionListener{

    JLabel lblusername,labelusername,lblid,labelid,labelno,lblno
            ,labelname,lblname,lblgender,labelgender,labelcountry,lblcountry
            ,labelfood,lblfood,lblac,labelac,labeldays,lbldays,labelprice ,lblpackage,lblpersons,labelpersons,labelpackage,text,lblemail,labelemail,lbladdress,labeladdress,labelphone,lblphone;

    JButton back;
    viewbookedhotel(String username){
        setBounds(420,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        text = new JLabel("VIEW BOOKED HOTEL DETAILS ");
        text.setFont(new Font("Sans Serif",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        lblpackage = new JLabel("Hotel Name");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);

        labelpackage = new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);

        lblpersons = new JLabel("Total Person");
        lblpersons.setBounds(30,130,150,25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);

        lbldays = new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);

        labeldays = new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);

        lblac = new JLabel("AC/Non-Ac");
        lblac.setBounds(30,210,150,25);
        add(lblac);

        labelac = new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);

        lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);

        lblname = new JLabel("Id");
        lblname.setBounds(30,290,150,25);
        add(lblname);

        labelid = new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);

        lblno = new JLabel("Number");
        lblno.setBounds(30,330,150,25);
        add(lblno);

        labelno = new JLabel();
        labelno.setBounds(220,330,150,25);
        add(labelno);

        lblcountry = new JLabel("Phone");
        lblcountry .setBounds(30,370,150,25);
        add(lblcountry );

        labelphone  = new JLabel();
        labelphone.setBounds(220,370,150,25);
        add( labelphone);

        lbladdress = new JLabel("Total Cost");
        lbladdress .setBounds(30,410,150,25);
        add(lbladdress);

        labelprice  = new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);


        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(130,460,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/bookeddetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(450,20,500,400);
        add(Image);


        try{
            Conn conn = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("name"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labeldays.setText(rs.getString("days"));
                labelpersons.setText(rs.getString("person"));

            }

        } catch (Exception e){
            e.printStackTrace();
        }





        setVisible(true);
    }


    public static void main(String[] args) {
        new viewbookedhotel("shahzan");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

    }
}



