import java.awt.event.*;
import javax.swing.*;

public class showcalendarButtonListener implements ActionListener
{
    private PhomepagePanel a;
    public showcalendarButtonListener(PhomepagePanel a)
    {
        this.a=a;
    }
   
    public void actionPerformed(ActionEvent event)
    {
        CalendarWindow.main(new String[]{});

    }
}
