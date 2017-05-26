import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.io.FileReader;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;
public class home implements ActionListener
{
    JFrame jfm;
    JPanel jp,jp2;
    JButton jb1,jb2,jb3,jb4,jb5;
    JLabel jl;
    JTextField jt1,jtm1,jt2,jtm2,jt3,jtm3,jt4,jtm4,jt5,jtm5;
    ImageIcon img;
    FileReader fr;
    FileWriter fw;
    BufferedReader br;
    BufferedWriter bw;
    int fh=0,fm=0,dh=0,dm=0,ah=0,am=0,mh=0,mm=0,ih=0,im=0;
    home()
    {
        /******** Image ************/
        jfm=new JFrame("Automic Azan");
        jfm.setSize(520,600);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setLayout(new GridLayout(2,1));
        img=new ImageIcon("images/home.jpg");
        jl=new JLabel();
        jl.setIcon(img);
        jp=new JPanel();
        jp.add(jl);
        //add with frame
        jfm.add(jp);
        
        
        //Getting Prayer time from time.txt
        String fn="time/time.txt";
        try
        {
            fr=new FileReader(fn);
            br=new BufferedReader(fr);
            fh=Integer.parseInt(br.readLine().trim());
            fm=Integer.parseInt(br.readLine().trim());
            dh=Integer.parseInt(br.readLine().trim());
            dm=Integer.parseInt(br.readLine().trim());
            ah=Integer.parseInt(br.readLine().trim());
            am=Integer.parseInt(br.readLine().trim());
            mh=Integer.parseInt(br.readLine().trim());
            mm=Integer.parseInt(br.readLine().trim());
            ih=Integer.parseInt(br.readLine().trim());
            im=Integer.parseInt(br.readLine().trim());
            br.close();
        }catch(FileNotFoundException f)
        {
            JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing
            System.exit(1);
        }
        catch(IOException io)
        {
             JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing datas
            System.exit(1);
        }
        
        jp=new JPanel(); //************************************************Adding field with buttons
        jp.setLayout(new GridLayout(7,1));
        jl=new JLabel("<html><h1 color=\"orange\">Set Prayer Time</h1></html>",jl.CENTER);
        jp.add(jl);
        
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,4));
        jl=new JLabel("<html>"+fh+":"+fm+" am &nbsp&nbsp&nbsp&nbsp&nbsp <font color=\"red\">Fazar: </font></html>",jl.RIGHT);
        jp2.add(jl);
        jt1=new JTextField();
        jp2.add(jt1);
        jtm1=new JTextField();
        jp2.add(jtm1);
        jb1=new JButton("SET");
        jb1.addActionListener(this);
        jp2.add(jb1);
        jp.add(jp2);
        
        
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,4));
        if(dh>=13)
            jl=new JLabel("<html>"+(dh-12)+":"+dm+" pm &nbsp&nbsp&nbsp&nbsp <font color=\"red\">Duhur: </font></html>",jl.RIGHT);
        else
            jl=new JLabel("<html>"+dh+":"+dm+" pm &nbsp&nbsp&nbsp&nbsp <font color=\"red\">Duhur: </font></html>",jl.RIGHT);
        jp2.add(jl);
        jt2=new JTextField();
        jp2.add(jt2);
        jtm2=new JTextField();
        jp2.add(jtm2);
        jb2=new JButton("SET");
        jb2.addActionListener(this);
        jp2.add(jb2);
        jp.add(jp2);
        
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,4));
        jl=new JLabel("<html>"+(ah-12)+":"+am+" pm &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <font color=\"red\">Asar: </font> </html>",jl.RIGHT);
        jp2.add(jl);
        jt3=new JTextField();
        jp2.add(jt3);
        jtm3=new JTextField();
        jp2.add(jtm3);
        jb3=new JButton("SET");
        jb3.addActionListener(this);
        jp2.add(jb3);
        jp.add(jp2);
        
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,4));
        jl=new JLabel("<html>"+(mh-12)+":"+mm+" pm &nbsp <font color=\"red\">Maghrib: </font></html>",jl.RIGHT);
        jp2.add(jl);
        jt4=new JTextField();
        jp2.add(jt4);
        jtm4=new JTextField();
        jp2.add(jtm4);
        jb4=new JButton("SET");
        jb4.addActionListener(this);
        jp2.add(jb4);
        jp.add(jp2);
        
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,4));
        jl=new JLabel("<html>"+(ih-12)+":"+im+" pm &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <font color=\"red\">Isha: </font></html>",jl.RIGHT);
        jp2.add(jl);
        jt5=new JTextField();
        jp2.add(jt5);
        jtm5=new JTextField();
        jp2.add(jtm5);
        jb5=new JButton("SET");
        jb5.addActionListener(this);
        jp2.add(jb5);
        jp.add(jp2);
        
        jl=new JLabel("<html><p stye=\"font-ize:15px;\"> Insert in (24 Hour Format) like HH : MM </p></html>",jl.CENTER);
        jp.add(jl);
        jfm.add(jp);
 
        jfm.setVisible(true);
        
        try
        {
            while(true) 
            {
                Thread.sleep(20 * 1000);               //***********Delay for 20 seconds
                Calendar now= Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute=now.get(Calendar.MINUTE);
                if(hour==fh && minute==fm)//Time checking 
                {
                    jfm.setVisible(false);
                    play ob=new play("Fazar");
                    
                }
                if(hour==dh && minute==dm)//Time
                {
                    jfm.setVisible(false);
                    play ob=new play("Duhur");
                    
                }
                if(hour==ah && minute==am)//Time
                {
                    jfm.setVisible(false);
                    play ob=new play("Asar");
                    
                }
                if(hour==mh && minute==mm)//Time
                {
                    jfm.setVisible(false);
                    play ob=new play("Maghrib");
                    
                }
                if(hour==ih && minute==im)//Time
                {
                    jfm.setVisible(false);
                    play ob=new play("Isha");
                    
                }
            }
        }catch(InterruptedException ae)
        {
            JOptionPane.showMessageDialog(jfm, "Unknown error occurd!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//Error for system time
            System.exit(1);
        }
        
        
    }
    
    //******************************************************************************Main class
    public static void main(String args[])
    {
        home ob=new home();
    }

    //*****************************************************************************Action 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==jb1)//****************************************************Fazar
        {
            String fn="time/time.txt";
            String th=jt1.getText().trim();
            String tm=jtm1.getText().trim();
            try
            {
                fh=Integer.parseInt(th);///***************Converting
                fm=Integer.parseInt(tm);
                if((fh>=3 && fh<=8) && (fm>=0 && fm<=60))
                {
                    try 
                    {
                        fw=new FileWriter(fn);//******************Writing
                        bw=new BufferedWriter(fw);
                        bw.write(fh+" \n");
                        bw.write(fm+" \n");
                        bw.write(dh+" \n");
                        bw.write(dm+" \n");
                        bw.write(ah+" \n");
                        bw.write(am+" \n");
                        bw.write(mh+" \n");
                        bw.write(mm+" \n");
                        bw.write(ih+" \n");
                        bw.write(im+" \n");
                        bw.close();
                        JOptionPane.showMessageDialog(jfm, "Fazar Time Successfully set.", "Notice",JOptionPane.INFORMATION_MESSAGE);//*Successful
                        System.exit(1);
                    }catch (IOException ex) 
                    {
                         JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing
                         System.exit(1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//******Time Invalid
                }
            }
            catch(NumberFormatException ne)
            {
                JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE); ////////****Number required
            }
        }
        
        
        if(e.getSource()==jb2)//****************************************************Fazar
        {
            String fn="time/time.txt";
            String th=jt2.getText().trim();
            String tm=jtm2.getText().trim();
            try
            {
                dh=Integer.parseInt(th);///***************Converting
                dm=Integer.parseInt(tm);
                if((dh>=11 && dh<=14) && (dm>=0 && dm<=60))
                {
                    try 
                    {
                        fw=new FileWriter(fn);//******************Writing
                        bw=new BufferedWriter(fw);
                        bw.write(fh+" \n");
                        bw.write(fm+" \n");
                        bw.write(dh+" \n");
                        bw.write(dm+" \n");
                        bw.write(ah+" \n");
                        bw.write(am+" \n");
                        bw.write(mh+" \n");
                        bw.write(mm+" \n");
                        bw.write(ih+" \n");
                        bw.write(im+" \n");
                        bw.close();
                        JOptionPane.showMessageDialog(jfm, "Duhur Time Successfully set.", "Notice",JOptionPane.INFORMATION_MESSAGE);//*Successful
                        System.exit(1);
                    }catch (IOException ex) 
                    {
                         JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing
                         System.exit(1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//******Time Invalid
                }
            }
            catch(NumberFormatException ne)
            {
                JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE); ////////****Number required
            }
        }
        if(e.getSource()==jb3)//****************************************************Fazar
        {
            String fn="time/time.txt";
            String th=jt3.getText().trim();
            String tm=jtm3.getText().trim();
            try
            {
                ah=Integer.parseInt(th);///***************Converting
                am=Integer.parseInt(tm);
                if((ah>=15 && ah<=17) && (am>=0 && am<=60))
                {
                    try 
                    {
                        fw=new FileWriter(fn);//******************Writing
                        bw=new BufferedWriter(fw);
                        bw.write(fh+" \n");
                        bw.write(fm+" \n");
                        bw.write(dh+" \n");
                        bw.write(dm+" \n");
                        bw.write(ah+" \n");
                        bw.write(am+" \n");
                        bw.write(mh+" \n");
                        bw.write(mm+" \n");
                        bw.write(ih+" \n");
                        bw.write(im+" \n");
                        bw.close();
                        JOptionPane.showMessageDialog(jfm, "Asar Time Successfully set.", "Notice",JOptionPane.INFORMATION_MESSAGE);//*Successful
                        System.exit(1);
                    }catch (IOException ex) 
                    {
                         JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing
                         System.exit(1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//******Time Invalid
                }
            }
            catch(NumberFormatException ne)
            {
                JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE); ////////****Number required
            }
        }
        if(e.getSource()==jb4)//****************************************************Fazar
        {
            String fn="time/time.txt";
            String th=jt4.getText().trim();
            String tm=jtm4.getText().trim();
            try
            {
                mh=Integer.parseInt(th);///***************Converting
                mm=Integer.parseInt(tm);
                if((mh>=16 && mh<=20) && (mm>=0 && mm<=60))
                {
                    try 
                    {
                        fw=new FileWriter(fn);//******************Writing
                        bw=new BufferedWriter(fw);
                        bw.write(fh+" \n");
                        bw.write(fm+" \n");
                        bw.write(dh+" \n");
                        bw.write(dm+" \n");
                        bw.write(ah+" \n");
                        bw.write(am+" \n");
                        bw.write(mh+" \n");
                        bw.write(mm+" \n");
                        bw.write(ih+" \n");
                        bw.write(im+" \n");
                        bw.close();
                        JOptionPane.showMessageDialog(jfm, "Maghrib Time Successfully set.", "Notice",JOptionPane.INFORMATION_MESSAGE);//*Successful
                        System.exit(1);
                    }catch (IOException ex) 
                    {
                         JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing
                         System.exit(1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//******Time Invalid
                }
            }
            catch(NumberFormatException ne)
            {
                JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE); ////////****Number required
            }
        }
        if(e.getSource()==jb5)//****************************************************Fazar
        {
            String fn="time/time.txt";
            String th=jt5.getText().trim();
            String tm=jtm5.getText().trim();
            try
            {
                ih=Integer.parseInt(th);///***************Converting
                im=Integer.parseInt(tm);
                if((ih>=18 && ih<=21) && (im>=0 && im<=60))
                {
                    try 
                    {
                        fw=new FileWriter(fn);//******************Writing
                        bw=new BufferedWriter(fw);
                        bw.write(fh+" \n");
                        bw.write(fm+" \n");
                        bw.write(dh+" \n");
                        bw.write(dm+" \n");
                        bw.write(ah+" \n");
                        bw.write(am+" \n");
                        bw.write(mh+" \n");
                        bw.write(mm+" \n");
                        bw.write(ih+" \n");
                        bw.write(im+" \n");
                        bw.close();
                        JOptionPane.showMessageDialog(jfm, "Isha Time Successfully set.", "Notice",JOptionPane.INFORMATION_MESSAGE);//*Successful
                        System.exit(1);
                    }catch (IOException ex) 
                    {
                         JOptionPane.showMessageDialog(jfm, "Error Loading Time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//**Missing
                         System.exit(1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE);//******Time Invalid
                }
            }
            catch(NumberFormatException ne)
            {
                JOptionPane.showMessageDialog(jfm, "Please enter valid time!!!", "Notice",JOptionPane.INFORMATION_MESSAGE); ////////****Number required
            }
        }
        
    }
}
