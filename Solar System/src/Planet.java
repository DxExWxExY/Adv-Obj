import java.awt.*;

@SuppressWarnings("serial")
public class Planet extends OrbitingBody implements Orbit {


    Planet(int x, int y, Color color) {
        super.x = x;
        super.y = y;
        super.color = color;
        super.radius = (x+y)/15;
    }

    public int calX(int distance, int angle){
        return (int) (x + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(int distance, int angle){
        return (int) (y + distance * Math.sin(Math.toRadians(angle)));
    }

    public void setPlanetPosition() {

    }
}
