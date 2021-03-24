import java.awt.*;

public class SpritePlayer extends Canvas {

    private static final long serialVersionUID = 1L;
    /**
     * @FranciscoHuchinUc
     */

    private int x, y;
    private boolean isClicked;
    private Image imagen;
    private Image buffer;
    private Image[] images;
    private int t;

    public SpritePlayer() {
        x = 30;
        y = 30;
        isClicked = false;
        buffer = createImage(1024, 500);
        images = new Image[3];
        String pathImage = "ejercicios/ejercicio8/recursos/1.png";
        imagen = Toolkit.getDefaultToolkit().getImage(pathImage);
        this.t = 0;
        for (int i = 0; i < 3; i++) {
            images[i+1] = Toolkit.getDefaultToolkit().getImage("ejercicios/ejercicio8/recursos/" + i + ".png");
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        Graphics miG = buffer.getGraphics();
        miG.setColor(Color.BLACK);
        miG.fillRect(0,0,1024,500);
        miG.drawImage(images[this.t], x, y, this);
        g2d.drawImage(buffer, 0, 0, this);
    }

    public void tick() {
        this.t++;
        if (t > images.length) this.t = 1;
    }

    public int setX(int x) {
        return this.x = x;
    }

    public int setY(int y) {
        return this.y = y;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = !this.isClicked;
    }

}