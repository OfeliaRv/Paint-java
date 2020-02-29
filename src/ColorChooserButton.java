import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColorChooserButton extends JButton {

    private Color current;
    private DrawArea drawArea;
    private PaintGUI paintGUI;

    public ColorChooserButton(Color c) {
        setSelectedColor(c);

    }

    public Color getSelectedColor() {
        return current;
    }

    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }

    public void setSelectedColor(Color newColor, boolean notify) {

        if (newColor == null) return;
        current = newColor;
        setIcon(createIcon(current, 16, 16));
        repaint();
    }

    public static  ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width-1, height-1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}
