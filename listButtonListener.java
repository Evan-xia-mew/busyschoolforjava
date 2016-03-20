import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class listButtonListener implements ActionListener
{
    private PhomepagePanel a;
    //private sopPanel b;
    public listButtonListener(PhomepagePanel a)
    {
        this.a=a;
    }
   
    public void actionPerformed(ActionEvent event)
    {
            ReadText.main(new String[]{});

    }
}
