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

public class Dashboard extends JFrame implements ActionListener {
    JLabel heading;
    JButton addPersonaldetails, updatePersonaldetails, viewPersonaldetails, deletePersonaldetails, checkpackage,
            bookpackage, viewpackage, viewhotels, Bookhotel, ViewBookedhotel, Destination, Payments, Calculators, Exit;

    String username;

    Dashboard(String username) {
        this.username = username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 66, 255));
        p1.setBounds(0, 0, 1600, 63);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(new Color(0xFFDC00));
        heading.setFont(new Font("Tahuma", Font.BOLD, 30));
        p1.add(heading);

        Exit = new JButton("Exit");
        Exit.setLayout(null);
        Exit.setBackground(new Color(0, 66, 255));
        Exit.setBounds(1250, 10, 100, 40);
        Exit.setForeground(new Color(0xFFDC00));
        Exit.setFont(new Font("Tahuma", Font.PLAIN, 20));
        Exit.addActionListener(this);
        //Exit.setMargin(new Insets(0,0,0,0));
        p1.add(Exit);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 66, 255));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addPersonaldetails = new JButton("Add Personal Details");
        addPersonaldetails.setLayout(null);
        addPersonaldetails.setBackground(new Color(0, 66, 255));
        addPersonaldetails.setBounds(0, 0, 300, 50);
        addPersonaldetails.setForeground(new Color(0xFFDC00));
        addPersonaldetails.setFont(new Font("Tahuma", Font.PLAIN, 20));
        addPersonaldetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonaldetails.addActionListener(this);
        p2.add(addPersonaldetails);

        updatePersonaldetails = new JButton("Update Personal Details");
        updatePersonaldetails.setLayout(null);
        updatePersonaldetails.setBackground(new Color(0, 66, 255));
        updatePersonaldetails.setBounds(0, 50, 300, 50);
        updatePersonaldetails.setForeground(new Color(0xFFDC00));
        updatePersonaldetails.setFont(new Font("Tahuma", Font.PLAIN, 20));
        updatePersonaldetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonaldetails.addActionListener(this);
        p2.add(updatePersonaldetails);

        viewPersonaldetails = new JButton("View Details");
        viewPersonaldetails.setLayout(null);
        viewPersonaldetails.setBackground(new Color(0, 66, 255));
        viewPersonaldetails.setBounds(0, 100, 300, 50);
        viewPersonaldetails.setForeground(new Color(0xFFDC00));
        viewPersonaldetails.setFont(new Font("Tahuma", Font.PLAIN, 20));
        viewPersonaldetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonaldetails.addActionListener(this);
        p2.add(viewPersonaldetails);

        deletePersonaldetails = new JButton("Delete Personal Details");
        deletePersonaldetails.setLayout(null);
        deletePersonaldetails.setBackground(new Color(0, 66, 255));
        deletePersonaldetails.setBounds(0, 150, 300, 50);
        deletePersonaldetails.setForeground(new Color(0xFFDC00));
        deletePersonaldetails.setFont(new Font("Tahuma", Font.PLAIN, 20));
        deletePersonaldetails.setMargin(new Insets(0, 0, 0, 35));
        p2.add(deletePersonaldetails);

        checkpackage = new JButton("Check Packages");
        checkpackage.setLayout(null);
        checkpackage.setBackground(new Color(0, 66, 255));
        checkpackage.setBounds(0, 200, 300, 50);
        checkpackage.setForeground(new Color(0xFFDC00));
        checkpackage.setFont(new Font("Tahuma", Font.PLAIN, 20));
        checkpackage.setMargin(new Insets(0, 0, 0, 100));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);

        bookpackage = new JButton("Book Package");
        bookpackage.setLayout(null);
        bookpackage.setBackground(new Color(0, 66, 255));
        bookpackage.setBounds(0, 250, 300, 50);
        bookpackage.setForeground(new Color(0xFFDC00));
        bookpackage.setFont(new Font("Tahuma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 110));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton("View Package");
        viewpackage.setLayout(null);
        viewpackage.setBackground(new Color(0, 66, 255));
        viewpackage.setBounds(0, 300, 300, 50);
        viewpackage.setForeground(new Color(0xFFDC00));
        viewpackage.setFont(new Font("Tahuma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 110));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        viewhotels = new JButton("View Hotels");
        viewhotels.setLayout(null);
        viewhotels.setBackground(new Color(0, 66, 255));
        viewhotels.setBounds(0, 350, 300, 50);
        viewhotels.setForeground(new Color(0xFFDC00));
        viewhotels.setFont(new Font("Tahuma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        Bookhotel = new JButton("Book Hotel");
        Bookhotel.setLayout(null);
        Bookhotel.setBackground(new Color(0, 66, 255));
        Bookhotel.setBounds(0, 400, 300, 50);
        Bookhotel.setForeground(new Color(0xFFDC00));
        Bookhotel.setFont(new Font("Tahuma", Font.PLAIN, 20));
        Bookhotel.setMargin(new Insets(0, 0, 0, 140));
        Bookhotel.addActionListener(this);
        p2.add(Bookhotel);

        ViewBookedhotel = new JButton("View Booked Hotel");
        ViewBookedhotel.setLayout(null);
        ViewBookedhotel.setBackground(new Color(0, 66, 255));
        ViewBookedhotel.setBounds(0, 450, 300, 50);
        ViewBookedhotel.setForeground(new Color(0xFFDC00));
        ViewBookedhotel.setFont(new Font("Tahuma", Font.PLAIN, 20));
        ViewBookedhotel.setMargin(new Insets(0, 0, 0, 70));
        ViewBookedhotel.addActionListener(this);
        p2.add(ViewBookedhotel);

        Destination = new JButton("Destinations");
        Destination.setLayout(null);
        Destination.setBackground(new Color(0, 66, 255));
        Destination.setBounds(0, 500, 300, 50);
        Destination.setForeground(new Color(0xFFDC00));
        Destination.setFont(new Font("Tahuma", Font.PLAIN, 20));
        Destination.setMargin(new Insets(0, 0, 0, 135));
        Destination.addActionListener(this);
        p2.add(Destination);

        Payments = new JButton("Payments");
        Payments.setLayout(null);
        Payments.setBackground(new Color(0, 66, 255));
        Payments.setBounds(0, 550, 300, 50);
        Payments.setForeground(new Color(0xFFDC00));
        Payments.setFont(new Font("Tahuma", Font.PLAIN, 20));
        Payments.setMargin(new Insets(0, 0, 0, 155));
        p2.add(Payments);

        Calculators = new JButton("Calculators");
        Calculators.setLayout(null);
        Calculators.setBackground(new Color(0, 66, 255));
        Calculators.setBounds(0, 600, 300, 50);
        Calculators.setForeground(new Color(0xFFDC00));
        Calculators.setFont(new Font("Tahuma", Font.PLAIN, 20));
        Calculators.setMargin(new Insets(0, 0, 0, 145));
        p2.add(Calculators);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/home2.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1000, 70);
        text.setForeground(new Color(0xFFDD01));
        text.setFont(new Font("Tahuma", Font.PLAIN, 50));
        image.add(text);


        setVisible(true);

    }

    public static void main(String[] args) {
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonaldetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonaldetails) {
            new Viewcustomer("shahzan");
        } else if (ae.getSource() == updatePersonaldetails) {
            new updatecustomer("shahzan");
        } else if (ae.getSource() == checkpackage) {
            new checkpackage();
        } else if (ae.getSource() == bookpackage) {
            new Bookpackage("shahzan");
        }else if (ae.getSource() == viewpackage) {
            new viewpackage("shahzan");
        }else if (ae.getSource() == viewhotels) {
            new checkhotels();
        }else if (ae.getSource() == Destination) {
            new destination();
        }else if (ae.getSource() == Bookhotel) {
            new Bookhotel("shahzan");
        }else if (ae.getSource() == ViewBookedhotel) {
            new viewbookedhotel("shahzan");
        }


        else if(ae.getSource() == Exit) {
            setVisible(false);
            new Login();

        }
    }
}

