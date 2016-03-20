import javax.swing.JFrame;  
import javax.swing.UIManager;  
 
public class CalendarMainClass   
{   
        public static void main(String args[])   
        {   
             try {  
                 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
              }catch (Exception e) {  
                e.printStackTrace();  
              }  
              CalendarFrame frame=new CalendarFrame();   
              frame.setBounds(100,100,360,300);   
              frame.setTitle("calendar");  
              frame.setLocationRelativeTo(null);
              frame.setVisible(true);   
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
              
        }   
}  