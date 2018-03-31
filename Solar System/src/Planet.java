import java.awt.*;
import java.util.Random;

@SuppressWarnings("serial")
public class Planet extends OrbitingBody implements Orbit {
    private OrbitingBody m1,m2;
    Random rand = new Random();
    private int m1D = 70;
    private int m1A = rand.nextInt(360);
    private int m2D = 90;
    private int m2A = rand.nextInt(360);

    Planet(int x, int y, Color color) {
        super.x = x;
        super.y = y;
        super.color = color;
        super.radius = (x+y)/30;
        m1 = new Moon(calX(m1D, m1A), calY(m1D, m1A), randomColor());
        m2 = new Moon(calX(m2D,m2A), calY(m2D,m2A), randomColor());
    }

    public int calX(int distance, int angle){
        return (int) (x + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(int distance, int angle){
        return (int) (y + distance * Math.sin(Math.toRadians(angle)));
    }

    public Color randomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r,g,b);
    }

    @Override
    public void setOrbitPosition() {
        m1.setPosition(calX(m1D,m1A), calY(m1D,m1A));
        m2.setPosition(calX(m2D,m2A), calY(m2D,m2A));
        m1A-=2;
        m2A+=3;
    }

    @Override
    public void draw(Graphics g) {
        setOrbitPosition();
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
        m1.draw(g);
        m2.draw(g);
    }
}
