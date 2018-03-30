import java.awt.*;

@SuppressWarnings("serial")
public class Sun implements Orbit {
    private Dimension dim;
    private OrbitingBody p1,p2;
    private int x, y;
    private int radius = 100;
    private int p1D = 170;
    private int p1A = 170;
    private int p2D = 280;
    private int p2A = 280;

    public void init(Dimension dim) {
        this.dim = dim;
        this.y = dim.height/2;
        this.x = dim.width/2;
        p1 = new Planet(calX(p1D, p1A), calY(p1D, p1A), Color.BLUE);
        p2 = new Planet(calX(p2D,p2A), calY(p2D,p2A), Color.RED);
    }

    public void setPlanetPosition() {
        p1.setPosition(calX(p1D,p1A), calY(p1D,p1A));
        p2.setPosition(calX(p2D,p2A), calY(p2D,p2A));
        p1A+=2;
        p2A++;
    }

    public int calX(int distance, int angle){
        return (int) (x + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(int distance, int angle){
        return (int) (y + distance * Math.sin(Math.toRadians(angle)));
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        setPlanetPosition();
        p1.draw(g);
        p2.draw(g);
    }
}
