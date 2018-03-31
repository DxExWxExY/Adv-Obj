import java.awt.*;
import java.util.Random;

@SuppressWarnings("serial")
public class Sun implements Orbit {
    private OrbitingBody p1,p2;
    Random rand = new Random();
    private int x, y;
    private int radius = 80;
    private int p1D = 200;
    private int p1A = rand.nextInt(360);
    private int p2D = 400;
    private int p2A = rand.nextInt(360);

    public void init(Dimension dim) {
        this.y = dim.height/2;
        this.x = dim.width/2;
        p1 = new Planet(calX(p1D, p1A), calY(p1D, p1A), randomColor());
        p2 = new Planet(calX(p2D,p2A), calY(p2D,p2A), randomColor());
    }

    private void setPlanetPosition() {
        p1.setPosition(calX(p1D,p1A), calY(p1D,p1A));
        p2.setPosition(calX(p2D,p2A), calY(p2D,p2A));
        p1A+=2;
        p2A++;
    }

    @Override
    public Color randomColor() {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r,g,b);
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
