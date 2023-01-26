package chapter6.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @version 1.02 2017-12-14
 * @author Cay Horstmann
 */
public class TimerTest {
  public static void main(String[] args) {
    var listener = new TimePrinter();

    // Construct a timer that calls the listener
    // once every second
    var timer = new Timer(1000, listener);
    timer.start();

    // Keep program running until the user select "OK"
    JOptionPane.showMessageDialog(null, "Quit Programs?");
    timer.stop();
//    System.exit(0);
  }
}

class TimePrinter implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
    Toolkit.getDefaultToolkit().beep();
  }
}