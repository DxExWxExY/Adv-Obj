package cs3331.noapplet;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.Timer;

import cs3331.noapplet.NoApplet;

/**
 *  Sample NoApplet to display the current time continuously.
 *  See Section 4.7 on pages 149-154.
 */
@SuppressWarnings("serial")
public class DigitalClock extends NoApplet {

    AudioClip sound;
    /** Refresh display once per second. */
    private Timer timer = new Timer(1000, e -> repaint());

    /** Font to display the time. */
    private Font font = new Font("Monospaced", Font.BOLD, 60);

    /** Color to display the time. */
    private Color color = Color.BLUE;

    public DigitalClock(String[] args) {
        super(args);
    }

    /** Start the timer. */
    @Override
    public void start() {
        timer.start();
    }

    /** Stop the timer to prevent from wasting CPU time. */
    @Override
    public void stop() {
        timer.stop();
    }

    /** Display the current time. */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Calendar calendar = Calendar.getInstance();
        Calendar alarm = Calendar.getInstance();
        alarm.setTimeInMillis(Calendar.HOUR);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        if (calendar.getInstance().equals(calendar.getInstance())) {
            System.out.print("YEEEET");
        }
        g.setFont(font);
        g.setColor(color);
        g.drawString("Pon atencion we"/*String.format("%d:%02d:%02d", hours, minutes, seconds)*/, 10, 60);
    }

    /*public static void main(String[] args) {
        new DigitalClock(new String[] {"width=1024", "height=512"}).run();
    }*/
}