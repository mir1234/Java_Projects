import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.TimerTask;
import java.util.Timer;


public class q10 implements ActionListener
{
    JFrame jfm1;
    JPanel jp1,jp2,jp3,jp4,jp5,tp;
    JLabel jl1,jl2,jlt;
    JButton b1;
    int delay,interval,period,k;
    Timer timer;
    String s,name1;
    int score1;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup bg;
    ArrayList arr=new ArrayList();
    q10(String name2,int score2,ArrayList rarr)
    {
        arr=rarr;
        name1=name2;
        score1=score2;
        //Frame
        jfm1=new JFrame("Quiz Contest");
        jfm1.setSize(450,550);
        jfm1.setResizable(false);
        jfm1.setDefaultCloseOperation(jfm1.EXIT_ON_CLOSE);
        jfm1.setLocationRelativeTo(null);
        jfm1.setLayout(new GridLayout(4,1));
        
        //Title
        jp1=new JPanel();
        jl1=new JLabel("<html><font face=\"Monotype Corsiva\"><p style=\"font-size:35px;margin-right:150px;margin-top:20px;color:black;text-align:left;\" >Hi! </p></br><p style=\"font-size:25px;color:blue;\">"+name1+"</p></font></html>");
        jp1.add(jl1);
        
        /****Timer and question at the same panel****/
        //Timer
        jp2=new JPanel();
        jp2.setLayout(new GridLayout(2,1));
        jlt=new JLabel();
        jp2.add(jlt);
        delay = 1000;
        period = 1000;
        timer = new Timer();
        interval = 45;
        s=""+45;
        jlt.setText("<html><h2 style=\"margin-top:40px;margin-left:180px;\">Time left: <font color=\"red\">"+s+"</font> seconds</h2></html>");
        timer.scheduleAtFixedRate(new TimerTask() 
        {
            public void run() 
            {
                k=setInterval();
                s=""+k;
                jlt.setText("<html><h2 style=\"margin-top:40px;margin-left:180px;\">Time left: <font color=\"red\">"+s+"</font> seconds</h2></html>");
                if(k==0)
                {
                    JOptionPane.showMessageDialog(jfm1, "Times up "+name1+" !!!","Notice", JOptionPane.INFORMATION_MESSAGE);
                    home ob1=new home(arr);
                    jfm1.setVisible(false);
                }
            }
        }, delay, period);
    
        
        //Question
        jl2=new JLabel("<html><h2 style=\"margin-left:20px;\"><font color=\"blue\">Q10</font>) Which one is not a uncheck exception?</h2></html>");
        jp2.add(jl2);
       
        //Options
        jp3=new JPanel();
        jp3.setLayout(new GridLayout(2,1));
        jp5=new JPanel();
        jp5.setLayout(new GridLayout(4,1));
        //Adding option
        op1=new JRadioButton("AWTError");
        op1.addActionListener(this);
        jp4=new JPanel();
        jp4.setLayout(new GridLayout(1,4));
        jl2=new JLabel();
        jp4.add(jl2);
        jp4.add(op1);
        jl2=new JLabel();
        jp4.add(jl2);
        jl2=new JLabel();
        jp4.add(jl2);
        jp5.add(jp4);
        op2=new JRadioButton("AWTException");
        op2.addActionListener(this);
        jp4=new JPanel();
        jp4.setLayout(new GridLayout(1,4));
        jl2=new JLabel();
        jp4.add(jl2);
        jp4.add(op2);
        jl2=new JLabel();
        jp4.add(jl2);
        jl2=new JLabel();
        jp4.add(jl2);
        jp5.add(jp4);
        op3=new JRadioButton("LinkageError");
        op3.addActionListener(this);
        jp4=new JPanel();
        jp4.setLayout(new GridLayout(1,4));
        jl2=new JLabel();
        jp4.add(jl2);
        jp4.add(op3);
        jl2=new JLabel();
        jp4.add(jl2);
        jl2=new JLabel();
        jp4.add(jl2);
        jp5.add(jp4);
        op4=new JRadioButton("VirtualError");
        op4.addActionListener(this);
        jp4=new JPanel();
        jp4.setLayout(new GridLayout(1,4));
        jl2=new JLabel();
        jp4.add(jl2);
        jp4.add(op4);
        jl2=new JLabel();
        jp4.add(jl2);
        jl2=new JLabel();
        jp4.add(jl2);
        jp4.add(jl2);
        jp5.add(jp4);
        jp3.add(jp5);
        //Button Group
        bg=new ButtonGroup();
        bg.add(op1);
        bg.add(op2);
        bg.add(op3);
        bg.add(op4);
        
        //Next Button
        jp4=new JPanel();
        jp4.setLayout(new GridLayout(4,1));
        b1=new JButton("Next>>");
        b1.addActionListener(this);
        jl2=new JLabel();
        jp4.add(jl2);
        jl2=new JLabel();
        jp4.add(jl2);
        jl2=new JLabel();
        jp4.add(jl2);
        jp5=new JPanel();
        jp5.setLayout(new GridLayout(1,5));
        jl2=new JLabel();
        jp5.add(jl2);
        jl2=new JLabel();
        jp5.add(jl2);
        jl2=new JLabel();
        jp5.add(jl2);
        jp5.add(b1);
        jl2=new JLabel();
        jp5.add(jl2);
        jp4.add(jp5);
        jp3.add(jp4);
        
        jfm1.add(jp1);
        jfm1.add(jp2);
        jfm1.add(jp3);
        jfm1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1 && op1.isSelected()==false && op2.isSelected()==false && op3.isSelected()==false && op4.isSelected()==false)
        {
            
            JOptionPane.showMessageDialog(jfm1, "Please select an option!!!","Notice", JOptionPane.INFORMATION_MESSAGE);
        }
        if(ae.getSource()==b1 && (op1.isSelected()==true || op2.isSelected()==true || op3.isSelected()==true || op4.isSelected()==true))
        {
            jfm1.setVisible(false);
            if(op2.isSelected()==true)
                score1=score1+10;
            else
                score1=score1+0;
            timer.cancel();
            
            result ob=new result(name1,score1,arr);
            
        }
    }
    private final int setInterval()  
    {
        if (interval == 1)
        timer.cancel();
        return --interval;
    }
}
