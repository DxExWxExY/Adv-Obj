import java.awt.*;

public interface Orbit {
    int calX(int distance, int angle);
    int calY(int distance, int angle);
    void draw(Graphics g);
    Color randomColor();
}
