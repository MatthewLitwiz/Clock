import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    Calendar Calender;
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel timeLabel, dayLabel, dateLabel;
    String time, day, date;

    MyFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Clock");
        setLayout(new FlowLayout());
        setSize(350, 200);
        // setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a"); // time format
        dayFormat = new SimpleDateFormat("EEEE"); // day format
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy"); // date format

        timeLabel = new JLabel(); // time label
        timeLabel.setFont(new Font("Dialog", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true); // display background

        dayLabel = new JLabel(); // day label
        dayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setBackground(Color.black);

        dateLabel = new JLabel(); // date label
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setBackground(Color.black);

        add(timeLabel); // add label to frame
        add(dayLabel);
        add(dateLabel); // add label to frame
        setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime()); // get current time
            timeLabel.setText(time); // set time on label

            day = dayFormat.format(Calendar.getInstance().getTime()); // get current day
            dayLabel.setText(day); // set day on label

            date = dateFormat.format(Calendar.getInstance().getTime()); // get current date
            dateLabel.setText(date); // set date on label

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
