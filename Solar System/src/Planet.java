import java.awt.*;

public class Planet extends Star implements CelestialBody {
    private int centerX, centerY;


    Planet(int x, int y) {
        this.centerX = x;
        this.centerY = y;
    }

    private int calX(){
        int center =dim.width/2;
        return (int) (center + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(){
        int center =dim.height/2;
        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
    }

    @Override
    public void draw(Graphics g) {

    }
}