package cs3331.noapplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Timer;
import cs3331.noapplet.NoApplet;

/**
 * Sample NoApplet showing a ball moving inside a rectangular box.
 * See Section 5.5.3 on pages 195-197.
 */
@SuppressWarnings("serial")
public class BouncingBall extends NoApplet {

    private int r,gc,b;
    private Color color = Color.CYAN;
    private int radius = 20;
    private int x, y;
    private boolean reduce = false;

    private Image image;
    private Graphics offScreen;
    private Dimension dim;

    private Timer timer;
    private int delay = 3;

    @Override
    public void init() {
        String param = getParameter("delay");
        if (param != null) {
            delay = Integer.parseInt(param);
        }
        dim = getSize();
        x = dim.width/2;
        y = dim.height/2;
        timer = new Timer(delay, e -> repaint());
    }

    @Override
    public void update(Graphics g) {
        // create an off-screen image and its grapchics
        if (image == null) {
            image = createImage(dim.width, dim.height);
            offScreen = image.getGraphics();
        }

        // fill the background
        offScreen.setColor(Color.white);
        offScreen.fillRect(0, 0, dim.width, dim.height);

        // adjust the position of the ball
        if (radius == dim.height/2) {
            reduce = true;
            r = (int) (Math.random() * 255);
            gc = (int) (Math.random() * 255);
            b = (int) (Math.random() * 255);
            color = new Color(r, gc, b);
        }
        if (radius == 0) {
            reduce = false;
            r = (int) (Math.random() * 255);
            gc = (int) (Math.random() * 255);
            b = (int) (Math.random() * 255);
            color = new Color(r, gc, b);
        }
        if (!reduce) {
            radius++;
        }
        if (reduce) {
            radius--;
        }
        // draw the ball and dump the off-screen image
        offScreen.setColor(color);
        offScreen.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        g.drawImage(image,  0,  0,  this);
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    /** Start the animation. */
    @Override
    public void start() {
        timer.start();
    }

    /** Stop the animation. */
    @Override
    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {
        new BouncingBall().run();
    }
}