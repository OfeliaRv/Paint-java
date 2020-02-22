import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PaintGUI extends JFrame {
    private JSlider brushWidth = new JSlider();


    public PaintGUI() {
        super("My Paint App");
        this.setBounds(100,100,100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(brushWidth);
    }
}