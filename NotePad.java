import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class NotePad extends JPanel implements ActionListener {

    JTextArea text;
    JTextField showMessage;
    JPopupMenu menu;
    JMenuItem itemCopy, itemCut, itemPaste, itemClear;

    public NotePad() {
        showMessage = new JTextField();
        showMessage.setHorizontalAlignment(JTextField.CENTER);
        showMessage.setFont(new Font("TimsRoman", Font.BOLD, 16));
        showMessage.setForeground(Color.blue);
        showMessage.setBackground(Color.pink);
        showMessage.setBorder(BorderFactory.createRaisedBevelBorder());
        showMessage.setEditable(false);
        menu = new JPopupMenu();
        itemCopy = new JMenuItem("copy");
        itemCut = new JMenuItem("cut");
        itemPaste = new JMenuItem("paste");
        itemClear = new JMenuItem("clear");
        itemCopy.addActionListener(this);
        itemCut.addActionListener(this);
        itemClear.addActionListener(this);
        itemPaste.addActionListener(this);
        menu.add(itemCopy);
        menu.add(itemCut);
        menu.add(itemPaste);
        menu.add(itemClear);
        text = new JTextArea(10, 10);
        text.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                    menu.show(text, e.getX(), e.getY());
                }
            }
        });
        setLayout(new BorderLayout());
        add(showMessage, BorderLayout.NORTH);
        add(new JScrollPane(text), BorderLayout.CENTER);
    }

    public void setShowMessage(int year, int month, int day) {
        showMessage.setText("" + year + "year" + month + "month" + day + "day");
    }

    public void save(File dir, int year, int month, int day) {
        String dailyContent = text.getText();
        String fileName = "" + year + "" + month + "" + day + ".txt";
        String key = "" + year + "" + month + "" + day;
        String[] dayFile = dir.list();
        boolean boo = false;
        for (int k = 0; k < dayFile.length; k++) {
            if (dayFile[k].startsWith(key)) {
                boo = true;
                break;
            }
        }
        if (boo) {
            String m = "" + year + "year" + month + "month" + day + "have data,still want add new data?";
            int ok = JOptionPane.showConfirmDialog(this, m, "asking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ok == JOptionPane.YES_OPTION) {
                try {
                    File f = new File(dir, fileName);
                    RandomAccessFile out = new RandomAccessFile(f, "rw");
                    long fileEnd = out.length();
                    byte[] bb = dailyContent.getBytes();
                    out.seek(fileEnd);
                    out.write(bb);
                    out.close();
                } catch (IOException exp) {
                }
            }

        } else {
            String m = "" + year + "year"+ month + "month" + day + "there is no data, want save data？";
            int ok = JOptionPane.showConfirmDialog(this,m,"asking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (ok == JOptionPane.YES_OPTION) {
                try {
                    File f = new File(dir, fileName);
                    RandomAccessFile out = new RandomAccessFile(f, "rw");
                    long fileEnd = out.length();
                    byte[] bb = dailyContent.getBytes();
                    out.write(bb);
                    out.close();
                } catch (IOException exp) {
                }
            }

        }
    }

    public void delete(File dir, int year, int month, int day) {
        String key = "" + year + "" + month + "" + day;
        String[] dayFile = dir.list();
        boolean boo = false;
        for (int k = 0; k < dayFile.length; k++) {
            if (dayFile[k].startsWith(key)) {
                boo = true;
                break;
            }
        }
        if (boo) {
            String m = "delete" + year + "year" + month + "month" + day + "day' data？";
            int ok = JOptionPane.showConfirmDialog(this, m, "asking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ok == JOptionPane.YES_OPTION) {
                String fileName = "" + year + "" + month + "" + day + ".txt";
                File deleteFile = new File(dir, fileName);
                deleteFile.delete();
            }
        } else {
            String m = "" + year + "year" + month + "month" + day + " have no data";
            JOptionPane.showMessageDialog(this, m, "tip", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void read(File dir, int year, int month, int day) {
        String fileName = "" + year + "" + month + "" + day + ".txt";
        String key = "" + year + "" + month + "" + day;
        String[] dayFile = dir.list();
        boolean boo = false;
        for (int k = 0; k < dayFile.length; k++) {
            if (dayFile[k].startsWith(key)) {
                boo = true;
                break;
            }
        }
        if (boo) {
            String m = "" + year + "year" + month + "month" + day + "have data, need show?";
            int ok = JOptionPane.showConfirmDialog(this, m, "asking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (ok == JOptionPane.YES_OPTION) {
                text.setText(null);
                try {
                    File f = new File(dir, fileName);
                    FileReader inOne = new FileReader(f);
                    BufferedReader inTwo = new BufferedReader(inOne);
                    String s = null;
                    while ((s = inTwo.readLine()) != null){
                        text.append(s + "\n");
                    }
                    inOne.close();
                    inTwo.close();
                } catch (IOException exp) {
                }
            }
        } else {
            String m = "" + year + "year" + month + "month" + day + "no data";
            JOptionPane.showMessageDialog(this, m, "tip", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itemCopy) {
            text.copy();
        } else if (e.getSource() == itemCut) {
            text.cut();
        } else if (e.getSource() == itemPaste) {
            text.paste();
        } else if (e.getSource() == itemClear) {
            text.setText(null);
        }
    }
}
