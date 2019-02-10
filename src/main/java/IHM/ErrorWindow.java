package IHM;

import Controlleur.Affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ErrorWindow extends JPanel implements ActionListener {

    public ErrorWindow(){

        JLabel errorMessage = new JLabel("Echec de l'identification");
        errorMessage.setHorizontalTextPosition(AbstractButton.CENTER);
        errorMessage.setVerticalTextPosition(AbstractButton.CENTER);

        JButton retryButton = new JButton("S'identifier");
        retryButton.setBackground(new Color(55, 158, 193));
        retryButton.setVerticalTextPosition(AbstractButton.TOP);
        retryButton.setHorizontalTextPosition(AbstractButton.CENTER);
        retryButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setSize(new Dimension(1000,2000));
        JPanel btnPanel = new JPanel();

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Roboto-Medium.ttf"));
            Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, is);
            Font font = mediumFont.deriveFont(15f);
            errorMessage.setFont(font);
            errorMessage.setForeground(Color.red);
            retryButton.setFont(font);
        }catch(FontFormatException ffe){
            ffe.printStackTrace();
        }
        catch( IOException e){
            e.printStackTrace();
        }

        panel.add(errorMessage);
        btnPanel.add(retryButton);

        add(panel);
        add(btnPanel);
        panel.setLocation(200,0);
        btnPanel.setLocation(200,30);

    }
    public void actionPerformed (ActionEvent e){
        if(e.paramString().contains("Button1")){
            Affichage.changeWindow(new WebcamWindow());
        }
    }
}
