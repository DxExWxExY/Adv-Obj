import java.awt.*;

public class orbitingBody {
    private Dimension dim;
//    private int calX(){
//        int center =dim.width/2;
//        return (int) (center + distance * Math.cos(Math.toRadians(angle)));
//    }
//    public int calY(){
//        int center =dim.height/2;
//        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
//    }
    orbitingBody(Dimension dim) {
        this.dim = dim;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
    }
}
