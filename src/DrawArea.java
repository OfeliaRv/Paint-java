import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawArea extends JComponent {
    private Image image;
    private Graphics2D graphics2D;
    private int currentX, currentY, oldX, oldY;
    private int drawFigure = 0;

    public DrawArea(){
       setDoubleBuffered(false);
       addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               oldX = e.getX();
               oldY = e.getY();
           }
           public void mouseReleased(MouseEvent e) {
               currentX = e.getX();
               currentY = e.getY();
               if (drawFigure == 1) {
                   if (graphics2D != null) {
                        if (currentX > oldX && currentY > oldY) {
                            graphics2D.drawRect(oldX, oldY, currentX - oldX, currentY - oldY);
                        }else if(currentX < oldX && currentY < oldY){
                            graphics2D.drawRect(currentX, currentY, oldX - currentX, oldY - currentY);
                        }else if(currentX < oldX && currentY > oldY){
                            graphics2D.drawRect(currentX, oldY, oldX - currentX, currentY - oldY);
                        }else if(currentX > oldX && currentY < oldY) {
                           graphics2D.drawRect(oldX, currentY, currentX - oldX, oldY - currentY);
                       }

                       repaint();

                   }
               }
               if (drawFigure == 2) {
                   if (graphics2D != null) {
                       if (currentX > oldX && currentY > oldY) {
                           graphics2D.drawOval(oldX, oldY, currentX - oldX, currentY - oldY);
                       }else if(currentX < oldX && currentY < oldY){
                           graphics2D.drawOval(currentX, currentY, oldX - currentX, oldY - currentY);
                       }else if(currentX < oldX && currentY > oldY){
                           graphics2D.drawOval(currentX, oldY, oldX - currentX, currentY - oldY);
                       }else if(currentX > oldX && currentY < oldY) {
                           graphics2D.drawOval(oldX, currentY, currentX - oldX, oldY - currentY);
                       }

                       repaint();

                   }
               }

           }
       });

       addMouseMotionListener(new MouseMotionAdapter() {
           @Override
           public void mouseDragged(MouseEvent e) {
               currentX = e.getX();
               currentY = e.getY();
               if (drawFigure == 0) {
                   if (graphics2D != null) {
                       graphics2D.drawLine(oldX, oldY, currentX, currentY);
                       repaint(); //refresh draw area
                       oldX = currentX;
                       oldY = currentY;
                                          }
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

    public void custom(Color newColor){
        graphics2D.setPaint(newColor);
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }
    public void toggleDrawFigure() {
        if (drawFigure == 0) {
            this.drawFigure = 1;
        } else {
            if (drawFigure == 1) {
                this.drawFigure = 2;
            } else {
                if (drawFigure == 2) {
                    this.drawFigure = 0;
                }
            }
        }
    }

}
