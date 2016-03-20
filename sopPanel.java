import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class sopPanel extends JPanel
{
    private JButton student;
    private JButton profsser;
    private JButton Creat; 
    public ArrayList<Integer> listS=new ArrayList<>();
    public ArrayList<Integer> listP;
    public sopPanel()
    {
       student = new JButton("student"); 
       studentButtonListener listener1 = new studentButtonListener(this);
       student.addActionListener(listener1);
       add(student,BorderLayout.EAST);
       profsser = new JButton("profsser"); 
       profsserButtonListener listener2 = new profsserButtonListener(this);
       profsser.addActionListener(listener2);
       add(profsser,BorderLayout.WEST);

    }

 
}