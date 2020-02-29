import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.*;

public class Shapes extends JComponent {

    private int currentX, currentY, oldX, oldY, drawFigures;
    private Graphics2D g2;
    private static final long serialVersionUID = 1L;
    private Shapes drawShape;
    Stack<Shapes> drawShapesList;

    public Shapes() {
        drawShapesList = new Stack();

        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

               Graphics2D mainGraphics = (Graphics2D) g;

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
            }
        };
    }
    public Stack<Shapes> getDrawShapesList() {
        return drawShapesList;
    }
}