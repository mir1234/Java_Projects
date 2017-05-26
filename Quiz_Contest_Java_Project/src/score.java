import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
public class score implements MenuListener
{
    ArrayList arr=new ArrayList();
    JFrame sf;
    JMenuBar mb;
    JMenu m;
    JLabel jl;
    score(ArrayList rarr)
    {
        arr=rarr;
        sf=new JFrame("Quiz Contest");
        sf.setSize(450,550);
        sf.setResizable(false);
        sf.setDefaultCloseOperation(sf.EXIT_ON_CLOSE);
        sf.setLocationRelativeTo(null);
        sf.setLayout(new FlowLayout(200));
        mb=new JMenuBar();
        m=new JMenu("Home");
        m.addMenuListener(this);
        mb.add(m);
        sf.setJMenuBar(mb);
        jl=new JLabel("<html><h1 style=\"margin-left:100px;padding-right:200px;color:blue;\">Highscorer List</h1></html>");
        sf.add(jl);
        if(arr.size()==0)
        {
            jl=new JLabel("<html><h1 style=\"margin-left:80px;padding-right:200px;color:red;\">\"Not performed good yet.\"</h1></html>");
        sf.add(jl);
        }
        for (int i = 0; i < arr.size(); i++) 
        {
            String str=(String) arr.get(i);
            jl=new JLabel();
            jl.setText((i+1)+") "+str+".      ");
            sf.add(jl);
        }
        
        sf.setVisible(true);
    }

    @Override
    public void menuSelected(MenuEvent e) 
    {
        sf.setVisible(false);
        home ob=new home(arr);
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        
    }
}
