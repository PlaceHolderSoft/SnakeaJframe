 
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Snake {
    private ImageIcon bodySerpiente;
    private Body[] cuerpo;
    private int size = 0;
    private int tam = 12;

    public Snake(int x, int y) {
        cuerpo = new Body[tam +1];
        add(new Body(x,y));
        add(new Body(x-30,y));
        
    }

    public void add (Body body){
        if(size<= tam){
            cuerpo[size] = body;
            size++;
            
        }
    }
    
    public void comer(int x, int y){
        addFirst(new Body(x,y));
    }
    
    public void mover(int x, int y){
        comer(x,y);
        removeLast();
    }
    //
    public void addFirst(Body body){
        for (int i = size; i > 0; i--) {
            cuerpo[i]=cuerpo[i-1];
            
        }
        cuerpo[0]=body;
        size++;
        
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.red);
        for (int i = 0; i < size; i++) {
            Body cuerpo = get(i);
//            g.fillRect(cuerpo.getX(), cuerpo.getY(), 30, 30);
            g.drawImage(cuerpo.getImagen(), cuerpo.getX(), cuerpo.getY(), 30, 30, null);
        }
    }
    
    public void removeLast(){
        size--;
    }
    
    public Body get(int i){
        return cuerpo[i];
    }
    
    public int size(){
        return size;
    }
    
    
}
