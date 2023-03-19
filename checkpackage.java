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

public class checkpackage extends JFrame{

    String[] package1 = {"GOLD PACKAGE",
            "6 Days and 7 Nights",
            "Airport Assistance",
            "Half day City Tour",
            "Daily Buffet",
            "Soft drinks free",
            "Full day 3 Island cruise",
            "English Speaking Guide",
            "Book Package",
            "Summer Special",
            "Rs 12,000/-",
            "package1.jpg"};
    String[] package2 = {"SILVER PACKAGE",
            "5 Days and 6 Nights",
            "Toll free",
            "Entrance Free tickets",
            "Meet and greet at airport",
            "Welcome drinks on arrival",
            "Night Safari",
            "Cruise with dinner",
            "Book Now",
            "Winter Special",
            "Rs 24,000/-",
            "package2.jpg"};
    String[] package3 = {"BRONZE PACKAGE",
            "4 Days and 5 Nights",
            "Return Air fare",
            "Free clubing Horse Riding and others games ",
            "River Rafting",
            "Hard drinks free",
            "Daiy Buffet",
            "BBQ Dinner" ,
            "Book now",
            "Winter Special",
            "Rs 32,000/-",
            "package3.jpg"};


    checkpackage(){
        setBounds(100,120,900,600);

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createpackage(package1);
        tab.addTab("package 1",null,p1);

        JPanel p2 = createpackage(package2);
        tab.addTab("package 2",null,p2);
        JPanel p3 = createpackage(package3);
        tab.addTab("package 3",null,p3);
        add(tab);




        setVisible(true);

    }

    public JPanel createpackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);

        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(new Color(231, 211, 0, 255));
        l1.setFont(new Font("Fancy",Font.BOLD,30));
        p1.add(l1);

        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(new Color(252, 1, 1, 255));
        l2.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l2);

        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(new Color(1, 139, 252, 255));
        l3.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l3);

        JLabel l4 =new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(new Color(252, 1, 1, 255));
        l4.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l4);

        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(new Color(1, 139, 252, 255));
        l5.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l5);

        JLabel l6 =new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(new Color(252, 1, 1, 255));
        l6.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l6);

        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(new Color(1, 139, 252, 255));
        l7.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l7);

        JLabel l8 =new JLabel(pack[7]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(new Color(252, 1, 1, 255));
        l8.setFont(new Font("Fancy",Font.BOLD,20));
        p1.add(l8);

        JLabel l9=new JLabel(pack[8]);
        l9.setBounds(60,430,300,30);
        l9.setForeground(new Color(0, 1, 2, 255));
        l9.setFont(new Font("Fancy",Font.BOLD,25));
        p1.add(l9);

        JLabel l10=new JLabel(pack[9]);
        l10.setBounds(80,480,300,30);
        l10.setForeground(new Color(255, 0, 219, 255));
        l10.setFont(new Font("Fancy",Font.BOLD,25));
        p1.add(l10);

        JLabel l11=new JLabel(pack[10]);
        l11.setBounds(500,480,300,30);
        l11.setForeground(new Color(40, 76, 255, 255));
        l11.setFont(new Font("Fancy",Font.BOLD,25));
        p1.add(l11);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12= new JLabel(i3);
        l12.setBounds(350, 20, 500, 300);
        p1.add(l12);

        return p1;
    }

    public static void main(String[] args) {
        new checkpackage();
    }
}
