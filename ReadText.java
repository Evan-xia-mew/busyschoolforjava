import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
 
public class ReadText {
 
    public static void main(String[] args)
    {
        readTextContent();
    }
 
    public static void readTextContent()
    {
 
        try
        {
            File file = new File("D:\\reg2.txt");
            FileInputStream fis = new FileInputStream(file);
            String str = "";
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = fis.read(bytes)) != -1)
            {
                str += new String(bytes, 0, length);
            }
 
            System.out.println(str);
 
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}