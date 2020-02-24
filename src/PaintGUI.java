import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PaintGUI {
    private ColorChooserButton colorChooser;
    private DrawArea drawArea;
    private JButton blackBtn, redBtn, greenBtn, magentaBtn, yellowBtn, blueBtn, clearBtn;
    private JSlider brushWidth;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clearArea();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
            } else if (e.getSource() == redBtn) {
                drawArea.red();
            } else if (e.getSource() == magentaBtn) {
                drawArea.magenta();
            } else if (e.getSource() == yellowBtn) {
                drawArea.yellow();
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

            brushWidth = new JSlider();

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

            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }
}

