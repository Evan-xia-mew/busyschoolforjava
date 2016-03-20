import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class profsserButtonListener implements ActionListener
{
    private sopPanel a;
    public profsserButtonListener(sopPanel a)
    {
        this.a=a;
    }
   
    public void actionPerformed(ActionEvent event)
    {
        JOptionPane.showMessageDialog(null, "open a new window！");
        Plogon.main(new String[]{});

    }
}