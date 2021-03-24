import java.awt.*;

public class SpritePlayer extends Canvas {
    
    private static final long serialVersionUID = 1L;
    /**
     * @FranciscoHuchinUc
     */

    private int x, y;
    private boolean isClicked;
    private Image imagen;

    public SpritePlayer() {
        x = 30;
        y = 30;
        isClicked = false;
        String pathImage = "ejercicios/ejercicio8/recursos/walk1.png";
        imagen = Toolkit.getDefaultToolkit().getImage(pathImage);
    }

    public void paint(Graphics g) {
        g.drawImage(imagen, x, y, this);
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