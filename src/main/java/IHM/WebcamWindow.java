package IHM;

import Controlleur.Affichage;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.sun.xml.internal.messaging.saaj.util.Base64;
import webcam.WebcamStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class WebcamWindow extends JPanel implements ActionListener {
    public WebcamWindow() {
        Webcam webcam = WebcamStream.getWebcam();

        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(true);

        JButton logButton = new JButton("S'identifier");

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Roboto-Medium.ttf"));
            Font mediumFont = Font.createFont(Font.TRUETYPE_FONT, is);
            Font font = mediumFont.deriveFont(15f);
            logButton.setFont(font);
        } catch (FontFormatException ffe) {
            ffe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logButton.setBackground(new Color(55, 158, 193));
        logButton.setVerticalTextPosition(AbstractButton.TOP);
        logButton.setHorizontalTextPosition(AbstractButton.CENTER);

        logButton.setActionCommand("disable");
        logButton.addActionListener(this);


        JPanel panel = new JPanel();
        panel.setSize(new Dimension(1000, 2000));
        panel.add(webcamPanel);
        panel.add(logButton);

        add(BorderLayout.SOUTH, panel);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.paramString().contains("Button1")) {
            BufferedImage image = WebcamStream.getWebcamImage();

            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(image, "JPG", outputStream);
                byte[] bytes = outputStream.toByteArray();
                
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            // Traitement réponse
            //TODO : Call API :
            if(false){
                Affichage.changeWindow(new SelectionWindow());
            }else{
                System.out.println(" User isn't in database ");

                Affichage.changeWindow(new ErrorWindow());
            }
        }
    }
}
