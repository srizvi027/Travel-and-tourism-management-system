package travel.and.tourism.management.system;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

public class Viewcustomer extends JFrame implements ActionListener{

    JLabel lblusername,labelusername,lblid,labelid,labelno,lblno
            ,labelname,lblname,lblgender,labelgender,labelcountry,lblcountry
            ,lblemail,labelemail,lbladdress,labeladdress,labelphone,lblphone;

    JButton back;
    Viewcustomer(String username){
        setBounds(480,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        lblid = new JLabel("Id");
        lblid.setBounds(30,110,150,25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);

        lblno = new JLabel("Number");
        lblno.setBounds(30,170,150,25);
        add(lblno);

        labelno = new JLabel();
        labelno.setBounds(220,170,150,25);
        add(labelno);

        lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);

        lblcountry = new JLabel("Country");
        lblcountry .setBounds(500,50,150,25);
        add(lblcountry );

        labelcountry  = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);

        lbladdress = new JLabel("Address");
        lbladdress .setBounds(500,110,150,25);
        add(lbladdress);

        labeladdress  = new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);

        lblphone = new JLabel("Phone");
        lblphone .setBounds(500,170,150,25);
        add(lblphone);

        labelphone  = new JLabel();
        labelphone.setBounds(690,170,150,25);
        add(labelphone);

        lblemail = new JLabel("Email");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);

        labelemail  = new JLabel();
        labelemail .setBounds(690,230,150,25);
        add(labelemail);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(20,400,600,200);
        add(Image);

        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icon/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200, java.awt.Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        JLabel Image2 = new JLabel(i6);
        Image2.setBounds(600,400,600,200);
        add(Image2);

        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }

        } catch (Exception e){
            e.printStackTrace();
        }





        setVisible(true);
    }


    public static void main(String[] args) {
        new Viewcustomer("shahzan");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

    }
}
