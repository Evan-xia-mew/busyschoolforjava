import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class CalendarWindow2 extends JFrame implements ActionListener, MouseListener, FocusListener {
    int year, month, day;
    CalendarMessage2 calendarMessage2;
    CalendarPad2 calendarPad2;
    NotePad2 notePad2;
    JTextField showYear, showMonth;
    JTextField[] showDay;
    CalendarImage2 calendarImage2;
    Clock2 clock2;
    JButton nextYear2, previousYear2, nextMonth2, previousMonth2;
    JButton raedDailyRecord2;
    File dir;
    Color backColor = Color.white;

    public CalendarWindow2() {
        dir = new File("./dailyRecord");
        dir.mkdir();
        showDay = new JTextField[42];
        for (int i = 0; i < showDay.length; i++) {
            showDay[i] = new JTextField();
            showDay[i].setBackground(backColor);
            showDay[i].setLayout(new GridLayout(3, 3));
            showDay[i].addMouseListener(this);
            showDay[i].addFocusListener(this);
        }
        calendarMessage2 = new CalendarMessage2();
        calendarPad2 = new CalendarPad2();
        notePad2 = new NotePad2();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        calendarMessage2.setYear(year);
        calendarMessage2.setMonth(month);
        calendarMessage2.setDay(day);
        calendarPad2.setCalendarMessage2(calendarMessage2);
        calendarPad2.setShowDayTextField2(showDay);
        notePad2.setShowMessage2(year, month, day);
        calendarPad2.showMonthCalendar2();
        doMark();
        calendarImage2 = new CalendarImage2();
        calendarImage2.setImageFile(new File("flower.jpg"));
        clock2 = new Clock2();
        JSplitPane splitV1 =
                new JSplitPane(JSplitPane.VERTICAL_SPLIT, calendarPad2, calendarImage2);
        JSplitPane splitV2 =
                new JSplitPane(JSplitPane.VERTICAL_SPLIT, notePad2, clock2);
        JSplitPane splitH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitV1, splitV2);
        add(splitH, BorderLayout.CENTER);
        showYear = new JTextField("" + year, 6);
        showYear.setFont(new Font("TimesRoman", Font.BOLD, 12));
        showYear.setHorizontalAlignment(JTextField.CENTER);
        showMonth = new JTextField("" + month , 4);
        showMonth.setFont(new Font("TimesRoman", Font.BOLD, 12));
        showMonth.setHorizontalAlignment(JTextField.CENTER);
        nextYear2 = new JButton("next year");
        previousYear2 = new JButton("last year");
        nextMonth2 = new JButton("next month");
        previousMonth2 = new JButton("last month");
        nextYear2.addActionListener(this);
        previousYear2.addActionListener(this);
        nextMonth2.addActionListener(this);
        previousMonth2.addActionListener(this);
        showYear.addActionListener(this);
        JPanel north = new JPanel();
        north.add(previousYear2);
        north.add(showYear);
        north.add(nextYear2);
        north.add(previousMonth2);
        north.add(showMonth);
        north.add(nextMonth2);
        add(north, BorderLayout.NORTH);      
        raedDailyRecord2 = new JButton("read data");
        raedDailyRecord2.addActionListener(this);
        JPanel pSouth = new JPanel();
        pSouth.add(raedDailyRecord2);
        add(pSouth, BorderLayout.SOUTH);
        setVisible(true);
        setBounds(60, 60, 660, 480);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextYear2) {
            year++;
            showYear.setText("" + year);
            calendarMessage2.setYear(year);
            calendarPad2.setCalendarMessage2(calendarMessage2);
            calendarPad2.showMonthCalendar2();
            notePad2.setShowMessage2(year, month, day);
            doMark();
        } else if (e.getSource() == previousYear2) {
            year--;
            showYear.setText("" + year);
            calendarMessage2.setYear(year);
            calendarPad2.setCalendarMessage2(calendarMessage2);
            calendarPad2.showMonthCalendar2();
            notePad2.setShowMessage2(year, month, day);
            doMark();
        } else if (e.getSource() == nextMonth2) {
            month++;
            if (month > 12) {
                month = 1;
            }
            showMonth.setText("" + month);
            calendarMessage2.setMonth(month);
            calendarPad2.setCalendarMessage2(calendarMessage2);
            calendarPad2.showMonthCalendar2();
            notePad2.setShowMessage2(year, month, day);
            doMark();
        } else if (e.getSource() == previousMonth2) {
            month--;
            if (month < 1) {
                month = 12;
            }
            showMonth.setText("" + month);
            calendarMessage2.setMonth(month);
            calendarPad2.setCalendarMessage2(calendarMessage2);
            calendarPad2.showMonthCalendar2();
            notePad2.setShowMessage2(year, month, day);
            doMark();
        } else if (e.getSource() == showYear) {
            String s = showYear.getText().trim();
            char a[] = s.toCharArray();
            boolean boo = false;
            for (int i = 0; i < a.length; i++) {
                if (!(Character.isDigit(a[i]))) {
                    boo = true;
                }
            }
            if (boo == true) {
                JOptionPane.showMessageDialog(this, "you enter an error year", "waring", JOptionPane.WARNING_MESSAGE);
            } else if (boo == false) {
                year = Integer.parseInt(s);
            }
            showYear.setText("" + year);
            calendarMessage2.setYear(year);
            calendarPad2.setCalendarMessage2(calendarMessage2);
            calendarPad2.showMonthCalendar2();
            notePad2.setShowMessage2(year, month, day);
            doMark();

        } else if (e.getSource() == raedDailyRecord2) {
            notePad2.read(dir, year, month, day);
        }
    }

    public void mousePressed(MouseEvent e) {
        JTextField text = (JTextField) e.getSource();
        String str = text.getText().trim();
        try {
            day = Integer.parseInt(str);
        } catch (NumberFormatException exp) {
        }
        calendarMessage2.setDay(day);
        notePad2.setShowMessage2(year, month, day);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void focusGained(FocusEvent e) {
        Component com = (Component) e.getSource();
        com.setBackground(Color.pink);
    }

    public void focusLost(FocusEvent e) {
        Component com = (Component) e.getSource();
        com.setBackground(backColor);
    }

    public void doMark() {
        for (int i = 0; i < showDay.length; i++) {
            showDay[i].removeAll();
            String str = showDay[i].getText().trim();
            try {
                int n = Integer.parseInt(str);
                if (isHaveDailyRecord(n) == true) {
                    JLabel mess = new JLabel("*WORK*");
                    mess.setFont(new Font("TimesRoman", Font.PLAIN, 11));
                    mess.setForeground(Color.blue);
                    showDay[i].add(mess);
                }
            } catch (Exception exp) {
            }
        }
        calendarPad2.repaint();
        calendarPad2.validate();
    }

    public boolean isHaveDailyRecord(int n) {
        String key = "" + year + "" + month + "" + n;
        String[] dayFile = dir.list();
        boolean boo = false;
        for (int k = 0; k < dayFile.length; k++) {
            if (dayFile[k].equals(key + ".txt")) {
                boo = true;
                break;
            }
        }
        return boo;
    }

    public static void main(String args[]) {
        new CalendarWindow2();
    }
}
