package Controlleur;

import IHM.*;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    private static JFrame frame;
    public Affichage(){
        frame = new JFrame("Application : Go securi");
        frame.setMinimumSize(new Dimension(1400 ,1000));
        frame.setSize(new Dimension(1400, 1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();

        MainWindow newContentPane = new MainWindow();
        WebcamWindow webcamContentPane = new WebcamWindow();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(webcamContentPane);

        frame.setVisible(true);
    }
    public static void changeWindow(JPanel jp) {

        frame.setContentPane(jp);

    }
}
