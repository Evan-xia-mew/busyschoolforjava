import javax.swing.JFrame;
public class MainGUI
{

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("pick account");
      sopPanel panel = new sopPanel();
      frame.getContentPane().add(panel);      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
