import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DesktopSubliminalDisplay {
  private JFrame frame;
  private JTextArea textArea;
  private boolean displayMessages;

  public DesktopSubliminalDisplay() {
    frame = new JFrame();
    frame.setUndecorated(true);
    frame.setBackground(new Color(0, 0, 0, 0));
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    frame.setLocationRelativeTo(null);
    frame.setAlwaysOnTop(true);
    frame.setLayout(new BorderLayout());

    textArea = new JTextArea();
    textArea.setBackground(new Color(0, 0, 0, 0));
    textArea.setForeground(Color.WHITE);
    textArea.setFont(new Font("Arial", Font.BOLD, 40));
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);

    frame.add(textArea);
  }

  public void addMessage(String message) {
    textArea.append(message + "\n");
  }

  public void startDisplay() {
    displayMessages = true;
    frame.setVisible(true);
    new Thread(new DisplayMessages()).start();
  }

  public void stopDisplay() {
    displayMessages = false;
    frame.setVisible(false);
  }

  private class DisplayMessages implements Runnable {
    public void run() {
      Random random = new Random();
      String[] messages = textArea.getText().split("\n");
      while (displayMessages) {
        int index = random.nextInt(messages.length);
        String message = messages[index];
        int x = random.nextInt(frame.getWidth());
        int y = random.nextInt(frame.getHeight());
        textArea.setText(message);
        textArea.setSize(textArea.getPreferredSize());
        textArea.setLocation(x, y);
        try {
          Thread.sleep(100);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    DesktopSubliminalDisplay display = new DesktopSubliminalDisplay();
    display.addMessage("I give thanks for all the money I have");
    display.addMessage("I make more and more money each year");
    display.addMessage("Money comes to me easily and effortlessly");
    display.addMessage("I give and recieve money with joy");
    display.addMessage("I start great conversations effortlessly");
    display.addMessage("I believe in myself");
    display.addMessage("You look people in the eyes");
    display.addMessage("I can accomplish anything I set my mind to");
    display.addMessage("I have positive outlook on life");
    display.addMessage("I am self-confident");
    display.addMessage("I can do anything I set my mind to");
    display.addMessage("I will get a job at big tech company");
    display.addMessage("I am a winner");
    display.addMessage("I am smart");
    display.addMessage("I remmember what I study");
    display.addMessage("I get excellent grades in school");
    display.addMessage("I will have my own business");
    display.addMessage("I am totally confident");
    display.addMessage("I am good looking");
    display.addMessage("I have strong mind");
    display.addMessage("I have fun");
    display.addMessage("I achieve my goals");
    display.addMessage("I am a miracle");
    display.addMessage("I am in control");
    display.addMessage("I am healthy");
    display.addMessage("My mind is focused");
    display.addMessage("I make wise decisions");
    display.addMessage("I am ready to attract my soul-mate");
    display.addMessage("I believe in the law of attraction");
    display.addMessage("I am a great soul mate");
    display.addMessage("My dreams are coming true");
    display.addMessage("I now attract my soul-mate");
    display.addMessage("I love being with my soul mate");
    display.startDisplay();
  }
}
