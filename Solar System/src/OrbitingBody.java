import java.awt.*;

public abstract class OrbitingBody {
    protected Color color;
    protected int x, y, radius;


    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }
}
