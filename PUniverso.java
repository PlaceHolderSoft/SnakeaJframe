
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalBorders;

public class PUniverso extends javax.swing.JPanel implements Runnable {

    private int direccion;
    private Snake culebrita;
    private Comida comida;
    private Thread hilo;
    private int puntos=0;
    private String repetir = "SI";
    
    
    JLabel puntuacion = new JLabel("Puntos: "+puntos);

    /**
     * Creates new form PUniverso
     */
    public PUniverso() {
        initComponents();

        culebrita = new Snake(60, 60);
        comida = new Comida(90, 180);
        direccion = KeyEvent.VK_RIGHT;
        hilo = new Thread(this);
        hilo.start();
//        DA ERROR, PERO EL PROGRAMA FUNCIONA
//        hilo.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
//        dibujarCuadricula(g);
        comida.dibujar(g);
        culebrita.dibujar(g);
        g.setColor(Color.yellow);
//        g.drawString("PUNTOS: 0", 10, 20);
//        ES MEJOR OPCION UTILIZAR UN JLABEL
    }
//    public void Puntos(int puntos){
//        JLabel puntuacion = new JLabel("Puntos: "+puntos);
//        puntuacion.setBounds(10, 20, 60, 30);
//        puntuacion.setBackground(Color.white);
//        puntuacion.setBorder(new MetalBorders.TextFieldBorder());
//        add(this);
//    }
    public boolean verificarComer(int xSnake, int ySnake){
        return (xSnake== comida.getX() && ySnake==comida.getY());
    }

    public void moverSerpiente(int direccion) {
        int posX, posY;
        posX = culebrita.get(0).getX();
        posY = culebrita.get(0).getY();

        switch (direccion) {
            case KeyEvent.VK_LEFT:
                posX = posX - 30;
                break;
            case KeyEvent.VK_RIGHT:
                posX = posX + 30;
                break;
            case KeyEvent.VK_UP:
                posY = posY - 30;
                break;
            case KeyEvent.VK_DOWN:
                posY = posY + 30;
                break;
        }
        if(verificarComer(posX, posY)){
            culebrita.comer(posX, posY);
            System.out.println("comer");
            moverComida();
        }else{
            culebrita.mover(posX, posY);
        }
        repaint();
        

    }
    private void moverComida(){
        int comidaX,comidaY;
        comidaX = (int)(Math.random()*(getWidth()/30));
        comidaY = (int)(Math.random()*(getHeight()/30));
        
        comida.setX(comidaX * 30);
        comida.setY(comidaY * 30);
        
        puntos++;
        
        puntuacion.setBounds(10, 20, 100, 30);
        puntuacion.setBorder(new LineBorder(Color.RED));
        puntuacion.setBackground(Color.WHITE);
        puntuacion.setOpaque(true);
        puntuacion.setText("Puntos: "+puntos);
        add(puntuacion);
        puntuacion.repaint();
    }
    private void dibujarCuadricula(Graphics g) {
        g.setColor(Color.blue);
        for (int x = 0; x < getWidth(); x+=30) {
            g.drawLine(x, 0, x, getHeight());
        }
        
        for (int y = 0; y < getHeight(); y+=30) {
            g.drawLine(0, y, getWidth(), y);
        }
    }
    private void repetirSI(){
        initComponents();
        culebrita = new Snake(60, 60);
        comida = new Comida(90, 180);
        direccion = KeyEvent.VK_RIGHT;
        hilo = new Thread(this);
        hilo.start();
    }

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void run(){
        pausa(500);
        try {
            while (repetir.equalsIgnoreCase("SI")) {                
                while (true){
                moverSerpiente(direccion);
                System.out.println("mover: "+direccion);
                pausa(200);
        }
            }
        } catch (Exception e) {
            repetir = JOptionPane.showInputDialog("GANASTE: Desea continuar? SI/NO");
            repetirSI();
        }
    }
    
    public void pausa(int tiempo){
        try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
              
            }
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
