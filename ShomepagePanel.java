import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ShomepagePanel extends JPanel
{
    private JButton showcaler;
    public ShomepagePanel()
    {
      showcaler = new JButton("showcaler"); 
      showcalerButtonListener listener1 = new showcalerButtonListener(this);
      showcaler.addActionListener(listener1);
      add(showcaler,BorderLayout.CENTER);
    }

}
