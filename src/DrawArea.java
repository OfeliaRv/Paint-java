import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawArea extends JComponent {
    private Image image;
    private Graphics2D graphics2D;
    private int currentX, currentY, oldX, oldY;

    public DrawArea(){
       setDoubleBuffered(false);
       addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               oldX = e.getX();
               oldY = e.getY();
           }
       });

       addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               currentX = e.getX();
               currentY = e.getY();

               if (graphics2D != null) {
                    graphics2D.drawLine(oldX, oldY, currentX, currentY);
                    repaint(); //refresh draw area
                    oldX = currentX;
                    oldY = currentY;
               }
           }
       });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null){
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clearArea();
        }

        g.drawImage(image, 0,0,null);
    }

    public void clearArea(){
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0,0,getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void red(){
        graphics2D.setPaint(Color.red);
    }

    public void black(){
        graphics2D.setPaint(Color.black);
    }

    public void magenta(){
        graphics2D.setPaint(Color.magenta);
    }

    public void blue(){
        graphics2D.setPaint(Color.blue);
    }

    public void green(){
        graphics2D.setPaint(Color.green);
    }

    public void yellow(){
        graphics2D.setPaint(Color.yellow);
    }
}
