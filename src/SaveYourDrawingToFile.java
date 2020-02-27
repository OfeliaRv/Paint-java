import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public abstract class SaveYourDrawingToFile extends JFrame implements MouseListener, ActionListener {
    private DrawArea drawArea;
    private DrawShapes drawShape;

    public static void saveToFile(String outputFile, Object object) {
        try {
            FileOutputStream fout = new FileOutputStream(outputFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a directory to save your file: ");
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            saveToFile(file.getPath() + ".paint", drawShape.getDrawShapesList());
        }
    }
}