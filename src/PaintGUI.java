import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PaintGUI {
    private ColorChooserButton colorChooser;
    private DrawArea drawArea;
    private Shapes drawShapes;
    private JButton blackBtn, redBtn, greenBtn, magentaBtn, yellowBtn, blueBtn, clearBtn;
    private JSlider brushWidth;
    private Color current;
    private JButton drawButton;
    private JButton drawButton2;
    private JButton saveBtn;

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
                colorChooser.setSelectedColor(current);
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
                current = Color.blue;
                colorChooser.setSelectedColor(current);
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
                current = Color.green;
                colorChooser.setSelectedColor(current);
            } else if (e.getSource() == redBtn) {
                drawArea.red();
                current = Color.red;
                colorChooser.setSelectedColor(current);
            } else if (e.getSource() == magentaBtn) {
                drawArea.magenta();
                current = Color.magenta;
                colorChooser.setSelectedColor(current);
            } else if (e.getSource() == yellowBtn) {
                drawArea.yellow();
                current = Color.yellow;
                colorChooser.setSelectedColor(current);
            } else if (e.getSource() == colorChooser) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
                drawArea.custom(newColor);
                colorChooser.setSelectedColor(newColor);
                current = newColor;
            } else if (e.getSource() == drawButton) {
                drawArea.toggleDrawFigure();
            } else if (e.getSource() == drawButton2) {
                drawArea.toggleCircle();
            } else if (e.getSource() == saveBtn) {
                //to test this, please enter your own path
                SaveYourDrawingToFile.saveToFile("C:/Users/ofarx/Desktop/myfile1.paint", drawShapes.drawShapesList);
            }
        }
    };

    public void showApp() {
        JFrame frame = new JFrame("My Paint App");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        drawArea = new DrawArea();
        drawShapes = new Shapes();

        //adding main drawArea area to the frame
        container.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();

        //creating all the elements and assigning methods to them
        saveBtn = new JButton("Save");
        saveBtn.addActionListener(actionListener);

        drawButton = new JButton("Rectangle");
        drawButton.addActionListener(actionListener);

        drawButton2 = new JButton("Circle");
        drawButton2.addActionListener(actionListener);

        colorChooser = new ColorChooserButton(Color.black);
        colorChooser.addActionListener(actionListener);

        brushWidth = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
        brushWidth.addChangeListener(changeListener);

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);

        blackBtn = new JButton();
        blackBtn.setBackground(Color.black);
        blackBtn.setPreferredSize(new Dimension(20, 20));
        blackBtn.addActionListener(actionListener);

        redBtn = new JButton();
        redBtn.setBackground(Color.red);
        redBtn.setPreferredSize(new Dimension(20, 20));
        redBtn.addActionListener(actionListener);

        greenBtn = new JButton();
        greenBtn.setBackground(Color.green);
        greenBtn.setPreferredSize(new Dimension(20, 20));
        greenBtn.addActionListener(actionListener);

        blueBtn = new JButton();
        blueBtn.setBackground(Color.blue);
        blueBtn.setPreferredSize(new Dimension(20, 20));
        blueBtn.addActionListener(actionListener);

        magentaBtn = new JButton();
        magentaBtn.setBackground(Color.magenta);
        magentaBtn.setPreferredSize(new Dimension(20, 20));
        magentaBtn.addActionListener(actionListener);

        yellowBtn = new JButton();
        yellowBtn.setBackground(Color.yellow);
        yellowBtn.setPreferredSize(new Dimension(20, 20));
        yellowBtn.addActionListener(actionListener);

        //adding components to the controls
        controls.add(saveBtn);
        controls.add(drawButton);
        controls.add(drawButton2);
        controls.add(colorChooser);
        controls.add(clearBtn);
        controls.add(redBtn);
        controls.add(blueBtn);
        controls.add(magentaBtn);
        controls.add(greenBtn);
        controls.add(yellowBtn);
        controls.add(blackBtn);
        controls.add(brushWidth);

        //adding control panel to the main container
        container.add(controls, BorderLayout.NORTH); //north - means placing on top

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
};








