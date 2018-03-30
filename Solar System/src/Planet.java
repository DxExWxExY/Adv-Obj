import java.awt.*;

@SuppressWarnings("serial")
public class Planet extends OrbitingBody implements Orbit {
//    private Moon moon;
//    private Moon eris;


    Planet(int x, int y, Color color) {
        super.x = x;
        super.y = y;
//        moon = new Moon();
//        eris = new Moon();
        this.color = color;
    }

    public int calX(int distance, int angle){
        return (int) (x + distance * Math.cos(Math.toRadians(angle)));
    }
    public int calY(int distance, int angle){
        return (int) (y + distance * Math.sin(Math.toRadians(angle)));
    }
}
