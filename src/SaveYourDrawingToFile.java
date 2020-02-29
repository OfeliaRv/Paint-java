import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public abstract class SaveYourDrawingToFile extends JFrame implements MouseListener, ActionListener {
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
}