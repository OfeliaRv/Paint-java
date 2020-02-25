import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;


public class PaintGUI {
    private ColorChooserButton colorChooser;
    private DrawArea drawArea;
    private JButton blackBtn, redBtn, greenBtn, magentaBtn, yellowBtn, blueBtn, clearBtn;
    private JSlider brushWidth;
    private Color current;
    private Cursor cursor;

    ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            JSlider source = (JSlider) changeEvent.getSource();
            drawArea.getGraphics2D().setStroke(new BasicStroke(source.getValue()));

        }
    };
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {

                drawArea.clearArea();
                drawArea.custom(current);
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
                current = Color.black;
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
                current = Color.blue;
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
                current = Color.green;
            } else if (e.getSource() == redBtn) {
                drawArea.red();
                current = Color.red;
            } else if (e.getSource() == magentaBtn) {
                drawArea.magenta();
                current = Color.magenta;
            } else if (e.getSource() == yellowBtn) {
                drawArea.yellow();
                current = Color.yellow;
            } else if (e.getSource() == colorChooser) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
                drawArea.custom(newColor);
                colorChooser.setSelectedColor(newColor);
                current = newColor;
        }
        }
    };

        public void showApp() {
            JFrame frame = new JFrame("My Paint App");

            Container container = frame.getContentPane();
            container.setLayout(new BorderLayout());
              drawArea = new DrawArea();
            container.add(drawArea, BorderLayout.CENTER);

            JPanel controls = new JPanel();

            colorChooser = new ColorChooserButton(Color.black);
            colorChooser.addActionListener(actionListener);

            brushWidth = new JSlider(JSlider.HORIZONTAL,0,50,0);
            brushWidth.addChangeListener(changeListener);


            clearBtn = new JButton("Clear");
            clearBtn.addActionListener(actionListener);

            blackBtn = new JButton("Black");
            blackBtn.addActionListener(actionListener);

            redBtn = new JButton("Red");
            redBtn.addActionListener(actionListener);

            greenBtn = new JButton("Green");
            greenBtn.addActionListener(actionListener);

            blueBtn = new JButton("Blue");
            blueBtn.addActionListener(actionListener);

            magentaBtn = new JButton("Magenta");
            magentaBtn.addActionListener(actionListener);

            yellowBtn = new JButton("Yellow");
            yellowBtn.addActionListener(actionListener);

            controls.add(colorChooser);
            controls.add(clearBtn);
            controls.add(redBtn);
            controls.add(blueBtn);
            controls.add(greenBtn);
            controls.add(yellowBtn);
            controls.add(blackBtn);

            //for brush width
            controls.add(brushWidth);

            container.add(controls, BorderLayout.NORTH);

            frame.setSize(1000, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }

    public DrawArea getDrawArea() {
        return drawArea;
    }



}

