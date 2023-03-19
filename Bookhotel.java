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

public class  Bookhotel extends JFrame implements ActionListener{
    JLabel lblusername,labelusername,lblid,labelid,labelno,lblno
    ,lblfood,lblac,lbldays,labelprice,lbltotal,labelphone,lblphone,lblpersons,lblpackage,text;

    JButton checkprice,bookpackage,back;
    Choice chotel,cac,cfood;

    JTextField tfpersons,tfdays;
    String username;
    Bookhotel(String username){
        this.username=username;
        setBounds(100,120,1200,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        text = new JLabel("BOOK HOTEL");
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

        lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,25);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        lblpersons = new JLabel("Total Person");
        lblpersons.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblpersons.setBounds(40,150,150,25);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

        lbldays = new JLabel("Number of Days");
        lbldays.setFont(new Font("Handwriting",Font.PLAIN,16));
        lbldays.setBounds(40,190,150,25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);

        lblac = new JLabel("AC/NON AC");
        lblac.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblac.setBounds(40,230,150,25);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("NonAC");
        cac.setBounds(250,230,200,20);
        add(cac);

        lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblfood.setBounds(40,270,150,25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250,270,200,20);
        add(cfood);



        lblid = new JLabel("Id");
        lblid.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblid.setBounds(40,310,150,20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);

        lblno = new JLabel("Number");
        lblno.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblno.setBounds(40,350,150,25);
        add(lblno);

        labelno = new JLabel();
        labelno.setFont(new Font("Handwriting",Font.PLAIN,16));
        labelno.setBounds(250,350,150,25);
        add(labelno);

        lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Handwriting",Font.PLAIN,16));
        lblphone.setBounds(40,390,150,20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);

        lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Handwriting",Font.PLAIN,16));
        lbltotal.setBounds(40,430,150,25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setFont(new Font("Handwriting",Font.PLAIN,16));
        labelprice.setBounds(250,430,150,25);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,490,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(340,490,120,25);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12= new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);








        setVisible(true);

    }


    public static void main(String[] args) {
        new Bookhotel("shahzan");

    }
    public void actionPerformed(ActionEvent ae){

            if (ae.getSource() == checkprice) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotel where name='" + chotel.getSelectedItem() + "'");
                    while (rs.next()) {
                        int cost = Integer.parseInt(rs.getString("costperperson"));
                        int food = Integer.parseInt(rs.getString("food"));
                        int ac = Integer.parseInt(rs.getString("acroom"));

                        int person = Integer.parseInt(tfpersons.getText());
                        int days = Integer.parseInt(tfdays.getText());

                        String acselected = cac.getSelectedItem();
                        String foodselected = cfood.getSelectedItem();

                        if (person * days > 0) {
                            int total = 0;
                            total += acselected.equals("AC") ? ac : 0;
                            total += foodselected.equals("YES") ? food : 0;
                            total += cost;
                            total = total * person * days;
                            labelprice.setText("RS" + total);
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                        }
                    }
                }
                    catch (Exception e){
                    e.printStackTrace();
                }



        }else if(ae.getSource()==bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelno.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
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
