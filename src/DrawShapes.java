import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

public class DrawShapes extends JComponent {

    private int currentX, currentY, oldX, oldY, drawFigures;
    private Graphics2D g2;
    private static final long serialVersionUID = 1L;
    private DrawShapes drawShape;
    Stack<DrawShapes> drawShapesList;

    public DrawShapes() {
        //drawShape = new DrawShapes();
        drawShapesList = new Stack();

        setSize(new Dimension(320, 320));
        setVisible(true);

        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D mainGraphics = (Graphics2D) g;

                mainGraphics.setStroke(new BasicStroke(2));
                mainGraphics.setColor(Color.red);

                mainGraphics.drawRect(50, 70, 200, 20);
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        oldX = e.getX();
                        oldY = e.getY();
                    }
                });

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        currentX = e.getX();
                        currentY = e.getY();
                        drawShapesList.add(drawShape);
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        currentX = e.getX();
                        currentY = e.getY();

                        if (g2 != null) {
                            Graphics2D g2 = (Graphics2D) g;
                            Shape line = new Line2D.Double(3, 3, 303, 303);
                            Shape rect = new Rectangle(3, 3, 303, 303);
                            Shape circle = new Ellipse2D.Double(100, 100, 100, 100);
                            Shape roundRect = new RoundRectangle2D.Double(20, 20, 250, 250, 5, 25);
                            g2.draw(line);
                            g2.draw(rect);
                            g2.draw(circle);
                            g2.draw(roundRect);
                            oldX = currentX;
                            oldY = currentY;
                        }
                    }
                });
            }
        };
    }
    public Stack<DrawShapes> getDrawShapesList() {
        return drawShapesList;
    }
}