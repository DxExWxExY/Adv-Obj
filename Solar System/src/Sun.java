import java.awt.*;

@SuppressWarnings("serial")
public class Sun implements Orbit {
    private Dimension dim;
    private OrbitingBody earth;
    private OrbitingBody mars;
    private int x, y;
    private int earthD = 150;
    private int marsD = 280;
    private int earthA = 150;
    private int marsA = 280;
    private int radius = 80;

    public void init(Dimension dim) {
        this.dim = dim;
        this.y = dim.height/2;
        this.x = dim.width/2;
        earth = new Planet(calX(earthD, earthD), calY(earthD, earthD), Color.BLUE);
        mars = new Planet(calX(marsD,marsD), calY(marsD,marsD), Color.RED);
    }

    public void setPlanetPosition() {
        earth.setPosition(calX(earthD, earthA), calY(earthD, earthA));
        mars.setPosition(calX(marsD, marsA), calY(marsD, marsA));
        marsA++;
        earthA++;
    }

    public int calX(int distance, int angle){
        return (int) (x + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(int distance, int angle){
        return (int) (y + distance * Math.sin(Math.toRadians(angle)));
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
        setPlanetPosition();
        earth.draw(g);
        mars.draw(g);
    }
}
