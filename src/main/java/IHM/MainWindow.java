package IHM;

import Controlleur.Affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainWindow extends JPanel implements ActionListener {
    protected JButton b1;

    public MainWindow() {

        setLayout(null);
        JPanel imgPanel = new JPanel();
        JPanel labelPanel = new JPanel();

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\logo.PNG";
        imgPanel.setSize(new Dimension(1000,2000));
        labelPanel.setSize(new Dimension(1000,20));

        JLabel image=new JLabel(new ImageIcon(path));
        JLabel title= new JLabel("Bienvenue sur l'application Go-securi !");

        labelPanel.add(title);
        imgPanel.add(image);

        JPanel btnPanel = new JPanel();
        b1 = new JButton("S'identifier");

        b1.setBackground(new Color(55, 158, 193));
        b1.addActionListener(this);

        btnPanel.setSize(new Dimension(1000,2000));

        btnPanel.add(b1);

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Roboto-Medium.ttf"));
            Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, is);
            Font font = mediumFont.deriveFont(15f);
            title.setFont(font);
            b1.setFont(font);
        }catch(FontFormatException ffe){
            ffe.printStackTrace();
        }
        catch( IOException e){
            e.printStackTrace();
        }

        add(labelPanel);
        add(imgPanel);
        add(btnPanel);
        labelPanel.setLocation(200,0);
        imgPanel.setLocation(200,40);
        btnPanel.setLocation(200,250);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.paramString().contains("Button1")){
            Affichage.changeWindow(new WebcamWindow());
        }
    }
}