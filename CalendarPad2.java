
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarPad2 extends JPanel {

    int year, month, day;
    CalendarMessage2 calendarMessage2;
    JTextField[] showDay;
    JLabel title[];
    String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    JPanel north, center;

    public  CalendarPad2() {
        setLayout(new BorderLayout());
        north = new JPanel();
        north.setLayout(new GridLayout(1, 7));
        center = new JPanel();
        center.setLayout(new GridLayout(6, 7));
        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        title = new JLabel[7];
        for (int j = 0; j < 7; j++) {
            title[j] = new JLabel();
            title[j].setFont(new Font("TimesRoman", Font.BOLD, 12));
            title[j].setText(week[j]);
            title[j].setHorizontalAlignment(JLabel.CENTER);
            title[j].setBorder(BorderFactory.createRaisedBevelBorder());
            north.add(title[j]);
        }
        title[0].setForeground(Color.red);
        title[6].setForeground(Color.blue);
    }

    public void setShowDayTextField2(JTextField[] text) {
        showDay = text;
        for (int i = 0; i < showDay.length; i++) {
            showDay[i].setFont(new Font("TimesRoman", Font.BOLD, 15));
            showDay[i].setHorizontalAlignment(JTextField.CENTER);
            showDay[i].setEditable(false);
            center.add(showDay[i]);
        }
    }

    public void setCalendarMessage2(CalendarMessage2 calendarMessage2) {
        this.calendarMessage2 = calendarMessage2;
    }

    public void showMonthCalendar2() {
        String[] a = calendarMessage2.getMonthCalendar();
        for (int i = 0; i < 42; i++) {
            showDay[i].setText(a[i]);
        }
        validate();
    }
}
