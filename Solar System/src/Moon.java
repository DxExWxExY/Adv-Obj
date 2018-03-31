import java.awt.*;

public class Moon extends OrbitingBody {

    Moon(int x, int y, Color color) {
        super.x = x;
        super.y = y;
        super.color = color;
        super.radius = (x+y)/70;
    }
}
