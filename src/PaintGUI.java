import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class PaintGUI {
    private ColorChooserButton colorChooser;
    private SaveYourDrawingToFile save;
    private DrawArea drawArea;
    private JButton blackBtn, redBtn, greenBtn, magentaBtn, yellowBtn, blueBtn, clearBtn;
    private JSlider brushWidth;
    private Color current;
    private Cursor cursor;
    private JButton drawButton;
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
            } else if (e.getSource() == saveBtn) {
                save.saveImage();
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

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(actionListener);

        drawButton = new JButton("Rectangle/Circle");
        drawButton.addActionListener(actionListener);

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

        controls.add(saveBtn);
        controls.add(drawButton);
        controls.add(colorChooser);
        controls.add(clearBtn);
        controls.add(redBtn);
        controls.add(blueBtn);
        controls.add(magentaBtn);
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

};








