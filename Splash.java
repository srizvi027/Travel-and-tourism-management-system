package travel.and.tourism.management.system;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Splash extends JFrame implements Runnable
{
    Thread thread;
    Splash()
    {
     //   setSize(1200,600);
       // setLocation(50,50);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/splash1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);


        setVisible(true);
        thread=new Thread(this);
        thread.start();

    }
    public void run(){
        try {
            Thread.sleep(5000);
            setVisible(false);
        }catch(Exception e){

        }

    }

    public static void main(String[] args) {


       Splash Frame = new Splash();
        int x=1;
       for(int i=1; i<=500 ;x+=7,  i+=6){
           Frame.setLocation(750-(x+i)/2,400-(i/2));
           Frame.setSize(x + i,i);
       }
       try {
           Thread.sleep(10);
       }
       catch (Exception e){

        }

    }
}