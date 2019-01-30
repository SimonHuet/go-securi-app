package IHM;

import Controlleur.Affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorWindow extends JPanel implements ActionListener {

    public ErrorWindow(){

        JLabel errorMessage = new JLabel("Echec de l'identification");
        errorMessage.setHorizontalTextPosition(AbstractButton.CENTER);
        errorMessage.setVerticalTextPosition(AbstractButton.CENTER);
        errorMessage.setText("Blyat");
        JButton retryButton = new JButton("S'identifier");

        JPanel panel = new JPanel();
        panel.setSize(new Dimension(1000,2000));
        panel.add(errorMessage);
        panel.add(retryButton);

        add(panel);

    }
    public void actionPerformed (ActionEvent e){
        if(e.paramString().contains("Button1")){

            Affichage.changeWindow(new WebcamWindow());
        }
    }
}
