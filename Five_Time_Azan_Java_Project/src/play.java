import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class play 
{
    JFrame jfm2;
    JPanel jp;
    JButton jb;
    JLabel jl;
    JTextField jt;
    ImageIcon img;
    String prayername2;
    play(String prayername1)
    {
        prayername2=prayername1;
        /******** Image ************/
        jfm2=new JFrame("Automic Azan");
        jfm2.setSize(500,400);
        jfm2.setResizable(false);
        jfm2.setLocationRelativeTo(null);
        jfm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm2.setLayout(new FlowLayout());
        if(prayername2=="Fazar")
            img=new ImageIcon("images/fazar.jpg");
        if(prayername2=="Duhur")
            img=new ImageIcon("images/duhur.jpg");
        if(prayername2=="Asar")
            img=new ImageIcon("images/asar.jpg");
        if(prayername2=="Maghrib")
            img=new ImageIcon("images/maghrib.jpg");
        if(prayername2=="Isha")
            img=new ImageIcon("images/isha.jpg");
        jl=new JLabel();
        jl.setIcon(img);
        jp=new JPanel();
        jp.add(jl);
        //add with frame
        jfm2.add(jl);
        jp=new JPanel();
        if(prayername2=="Fazar")
            jl=new JLabel("<html><h1 color=\"red\">This is Fazar prayer time.</h1></html>",JLabel.CENTER);
        if(prayername2=="Duhur")
            jl=new JLabel("<html><h1 color=\"red\">This is Duhur prayer time.</h1></html>",JLabel.CENTER);
        if(prayername2=="Asar")
            jl=new JLabel("<html><h1 color=\"red\">This is Asar prayer time.</h1></html>",JLabel.CENTER);
        if(prayername2=="Maghrib")
            jl=new JLabel("<html><h1 color=\"red\">This is Maghrib prayer time.</h1></html>",JLabel.CENTER);
        if(prayername2=="Isha")
            jl=new JLabel("<html><h1 color=\"red\">This is Isha prayer time.</h1></html>",JLabel.CENTER);
        
        jp.add(jl);
        jfm2.add(jl);
        jfm2.setVisible(true);
        
        try
            {
                File file=new File("mp3\\p.mp3");
                FileInputStream fls=new FileInputStream(file);
                BufferedInputStream bls= new BufferedInputStream(fls);


                try
                {
                    Player pl=new Player(bls);
                    pl.play();
                    jfm2.setVisible(false);
                    home ob=new home();
                }catch(JavaLayerException le)
                {

                }

            }catch(IOException ae)
            {
                   JOptionPane.showMessageDialog(jfm2, "Error Loading Azan mp3 source!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing datas
                   System.exit(1);
            }
        
        
    }
}
