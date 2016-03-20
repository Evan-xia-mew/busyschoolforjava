import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PhomepagePanel extends JPanel
{
;
    private JButton list;
    private JButton showcalendar;
    public PhomepagePanel()
    {
       list = new JButton("list"); 
       listButtonListener listener4 = new listButtonListener(this);
       list.addActionListener(listener4);
       add(list,BorderLayout.WEST);
       showcalendar = new JButton("showcalendar"); 
       showcalendarButtonListener listener5 = new showcalendarButtonListener(this);
       showcalendar.addActionListener(listener5);
       add(showcalendar,BorderLayout.EAST);

    }

}
