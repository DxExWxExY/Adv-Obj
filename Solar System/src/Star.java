import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;

public class Star extends Applet implements CelestialBody {
    /** Delay in milliseconds between two consecutive frames. */
    private int delay = 100;
    private int radius = 60;
    private int x, y;
    private Planet earth;

    /** Dimension of the screen for this applet. */
    Dimension dim;

    /** Refresh display once per <code>delay</code> milliseconds. */
    private Timer timer;

    /** Overridden here to initialize the animation. */
    @Override
    public void init() {
        dim = getSize();
        x = dim.width/2;
        y = dim.height/2;
        earth = new Planet(x,y);
        timer = new Timer(delay, e -> repaint());
    }

    private orbitingBody createPlanet() {
        return new orbitingBody(dim);
    }

    public int calX(){
        int center = dim.width/2;
        return (int) (center + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(){
        int center = dim.height/2;
        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, dim.width, dim.height);
        g.setColor(Color.YELLOW);
        g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
    }
}