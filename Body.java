
import java.awt.Image;
import javax.swing.ImageIcon;

public class Body implements Sprite{
    private int x;
    private int y;
    private ImageIcon bodySerpiente;

    public Body(int x, int y) {
        this.x = x;
        this.y = y;
        bodySerpiente = new ImageIcon(getClass().getResource("body.png"));
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
    
    public Image getImagen(){
        return bodySerpiente.getImage();
    }
}
