package Controlleur;

import IHM.*;

import javax.swing.*;

public class Affichage extends JPanel {
    private static JFrame frame;
    public Affichage(){
        frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainWindow newContentPane = new MainWindow();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
    public static void changeWindow(JPanel jp) {
        frame.setContentPane(jp);
        frame.pack();
    }
}
