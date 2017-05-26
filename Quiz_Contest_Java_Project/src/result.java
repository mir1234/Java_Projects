import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class result implements ActionListener 
{
    int score1;
    String name1;
    JFrame jfm1;
    JPanel jp1,jp2;
    JLabel jl1;
    JButton b1,b2;
    ArrayList arr=new ArrayList();
    result(String name2,int score2,ArrayList rarr)
    {
        arr=rarr;
        score1=score2;
        name1=name2;
        //Frame
        jfm1=new JFrame("Quiz Result");
        jfm1.setSize(440,190);
        jfm1.setResizable(false);
        jfm1.setDefaultCloseOperation(jfm1.EXIT_ON_CLOSE);
        jfm1.setLocationRelativeTo(null);
        jfm1.setLayout(new GridLayout(3,1));
        
        jp1=new JPanel();
        if(score1>=80)
            jl1=new JLabel("<html><h2>Wow!! <font color=\"blue\">"+name1+"</font></h2></html>");
        if(score1<80)
            jl1=new JLabel("<html><h2>Oh!! <font color=\"blue\">"+name1+"</font></h2></html>");
        jp1.add(jl1);
        jfm1.add(jp1);
        
        jp1=new JPanel();
        if(score1>=80)
        {
            jl1=new JLabel("<html><h2>Your Performance is <font color=\"blue\">"+score1+"% </font>(<font color=\"red\">\"Excellent\"</font>)</h2></html>");
            arr.add(name1);
        }
        if(score1<80 && score1>=60)
        {
            jl1=new JLabel("<html><h2>Your Performance is <font color=\"blue\">"+score1+"% </font>(<font color=\"red\">\"Good\"</font>)</h2></html>");
            arr.add(name1);
        }
        if(score1<60 && score1>=40)
        {
            jl1=new JLabel("<html><h2>Your Performance is <font color=\"blue\">"+score1+"% </font>(<font color=\"red\">\"Poor\"</font>)</h2></html>");
            arr.add(name1);
        }
        if(score1<40 && score1>=20)
            jl1=new JLabel("<html><h2>Your Performance is <font color=\"blue\">"+score1+"% </font>(<font color=\"red\">\"Very Poor\"</font>)</h2></html>");
        if(score1<20 && score1>=0)
            jl1=new JLabel("<html><h2>Your Performance is <font color=\"blue\">"+score1+"% </font>(<font color=\"red\">\"Uncomplete\"</font>)</h2></html>");
        
        
        
        jp1.add(jl1);
        jfm1.add(jp1);
        jp1=new JPanel();
        jp1.setLayout(new GridLayout(2,1));
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,5));
        jl1=new JLabel("");
        jp2.add(jl1);
        b1=new JButton("Improve");
        b1.addActionListener(this);
        jp2.add(b1);
        jl1=new JLabel("");
        jp2.add(jl1);
        b2=new JButton("Exit");
        b2.addActionListener(this);
        jp2.add(b2);
        jl1=new JLabel("");
        jp2.add(jl1);
        jp1.add(jp2);
        jfm1.add(jp1);
        
        jfm1.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            jfm1.setVisible(false);
            home ob=new home(arr);
            
        }
        if(ae.getSource()==b2)
        {
            System.exit(0);
        }
    }
}
