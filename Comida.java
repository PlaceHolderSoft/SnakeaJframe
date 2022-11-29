
import java.awt.Color;
import java.awt.Graphics;

public class Comida implements Sprite {

    private int x;
    private int y;

    public Comida(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getX(), getY(), 30, 30);
    }
}
