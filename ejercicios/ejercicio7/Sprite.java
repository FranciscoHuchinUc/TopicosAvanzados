
import java.awt.*;
import java.util.Random;

public class Sprite extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int x;
    private int y;
    private int rnd;
    Random random;

    public Sprite() {
        x = 30;
        y = 30;
        random = new Random();
        rnd = random.nextInt(400);
    }

    public void paint(Graphics g) {
        g.drawRect(x, y, 30, 30);
        g.fillOval(x + 2, y + 2, 10, 10);
        g.fillOval(rnd, rnd, 10, 10);
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
