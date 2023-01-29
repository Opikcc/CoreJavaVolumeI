package chapter6.inner.classes;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes.
 * @version 1.11 2017-12-14
 * @author Cay Horstmann
 */
public class InnerClassTest {
  public static void main(String[] args) {
    var clock = new TalkingClock(1000, true);
    clock.start();
    
    // Keep program running until the user selects "OK"
    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
  private int interval;
  private boolean beep;
  
  /**
   * Constructs a talking clock
   * @param interval the interval between messages (in milisec)
   * @param beep true if the clock should beep
   */
  public TalkingClock(int interval, boolean beep) {
    this.interval = interval;
    this.beep = beep;
  }
  
  /**
   * Starts the clock
   */
  public void start() {
    var listener = this.new TimePrinter();
    var timer = new Timer(interval, listener);
    timer.start();
  }
  
  // Inner Class
  public class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      System.out.println("At the tone, the time is" + Instant.ofEpochMilli(event.getWhen()));
      if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
    }
  }
}
