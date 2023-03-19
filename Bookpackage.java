package travel.and.tourism.management.system;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Bookpackage extends JFrame implements ActionListener{
    JLabel lblusername,labelusername,lblid,labelid,labelno,lblno
    ,labelprice,lbltotal,labelphone,lblphone,lblpersons,lblpackage,text;

    JButton checkprice,bookpackage,back;
    Choice cpackage;

    JTextField tfpersons;
    String username;
    Bookpackage(String username){
        this.username=username;
        setBounds(100,120,1200,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,250,32);
        text.setFont(new Font("Handwriting",Font.BOLD,25));
        add(text);

        lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Handwriting",Font.PLAIN,16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Handwriting",Font.PLAIN,16));
        labelusername.setBounds(250,70,100,20);
        add(labelusername);

        lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,25);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);

        lblpersons = new JLabel("Total Person");
        lblpersons.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblpersons.setBounds(40,150,150,25);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

        lblid = new JLabel("Id");
        lblid.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblid.setBounds(40,190,150,20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        lblno = new JLabel("Number");
        lblno.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblno.setBounds(40,230,150,25);
        add(lblno);

        labelno = new JLabel();
        labelno.setFont(new Font("Handwriting",Font.PLAIN,16));
        labelno.setBounds(250,230,150,25);
        add(labelno);

        lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblphone.setBounds(40,270,150,20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

        lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Handwriting",Font.PLAIN,16));
        lbltotal.setBounds(40,310,150,25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setFont(new Font("Handwriting",Font.PLAIN,16));
        labelprice.setBounds(250,310,150,25);
        add(labelprice);

        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));


            }

        } catch (Exception e){
            e.printStackTrace();
        }
        checkprice = new JButton(" check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(340,380,120,25);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12= new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);








        setVisible(true);

    }


    public static void main(String[] args) {
        new Bookpackage("shahzan");

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
            }else if (pack.equals("Silver Package")){
                cost += 25000;
            }else {
                cost += 32000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs" +cost);
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelno.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }


}
