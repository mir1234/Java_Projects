import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class home implements ActionListener,MenuListener
{
    JFrame jfm;
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jl1;
    JTextField jtf1;
    JButton b1;
    ImageIcon img;
    int score=0;
    JMenuBar mb;
    JMenu m;
    JMenuItem it;
    static ArrayList arr;
    home(ArrayList rarr)
    {
        arr=rarr;
        //Frame
        jfm=new JFrame("Quiz Contest");
        jfm.setSize(450,620);
        jfm.setResizable(false);
        jfm.setDefaultCloseOperation(jfm.EXIT_ON_CLOSE);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(3,1));
        
        mb=new JMenuBar();
        m=new JMenu("Highscorer");
        m.addMenuListener(this);
        mb.add(m);
        jfm.setJMenuBar(mb);
        
        //Title
        jp1=new JPanel();   
        jl1=new JLabel("<html><font face=\"Monotype Corsiva\"><p style=\"font-size:40px;margin-left:0px;margin-top:25px;color:blue;text-align:left;\" >Welcome To </p></br> </br> <p style=\"color:blue;font-size:25px;margin-left:80px;\" >The Java Quiz Contest</p></font> </br> <p align=\"center\" style=\"margin-top:25px;\">(\"Test your skill here\")</p></html>");
        jp1.add(jl1);
        
        //Image
        jp2=new JPanel();
        img= new ImageIcon("image/logo.png");
        jl1=new JLabel();
        jl1.setIcon(img);
        jp2.add(jl1);
        
        //Setting Jlabel for get name at first
        jp3=new JPanel();
        jp3.setLayout(new GridLayout(4,1));
        jl1=new JLabel("<html><h2 style=\"margin-left:10px;margin-top:25px;\">Enter Your Name: </h2></html>");
        jp3.add(jl1);
        
        //setting textfield 
        jtf1=new JTextField();
        jp4= new JPanel();
        jp4.setLayout(new FlowLayout());
        jtf1.setColumns(25);
        jp4.add(jtf1);
        jp3.add(jp4);
        
        //setting button horizontally
        jp4=new JPanel();
        jp4.setLayout(new GridLayout(1,5));
        jl1=new JLabel("");
        jp4.add(jl1);
        jl1=new JLabel("");
        jp4.add(jl1);
        jl1=new JLabel("");
        jp4.add(jl1);
        b1=new JButton("Start");
        b1.addActionListener(this);
        jp4.add(b1);
        jl1=new JLabel("");
        jp4.add(jl1);
        
        //setting button vertically
        jp5=new JPanel();
        jp5.setLayout(new GridLayout(3,1));
        jp5.add(jp4);
        jl1=new JLabel("");
        jp5.add(jl1);
        jl1=new JLabel("");
        jp5.add(jl1);
        jp3.add(jp5);
        
        
        jl1=new JLabel("");
        jp3.add(jl1);

        
        jfm.add(jp1);
        jfm.add(jp2);
        jfm.add(jp3);
        jfm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String name=jtf1.getText().trim();
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(jfm, "Please enter your name!!!","Notice", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            jfm.setVisible(false);
            q1 ob1=new q1(name,score,arr);
        }
    }
    public static void main(String args[])
    {
        arr=new ArrayList();
        home ob=new home(arr);
    }

    @Override
    public void menuSelected(MenuEvent e) 
    {
        jfm.setVisible(false);
        score ob=new score(arr);
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        
    }
}
