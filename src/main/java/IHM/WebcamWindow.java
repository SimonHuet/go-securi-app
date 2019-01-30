package IHM;

import Controlleur.Affichage;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import webcam.WebcamStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WebcamWindow extends JPanel implements ActionListener {
    public WebcamWindow (){
            Webcam webcam = WebcamStream.getWebcam();

            WebcamPanel webcamPanel = new WebcamPanel(webcam);
            webcamPanel.setImageSizeDisplayed(true);
            webcamPanel.setMirrored(true);

            JButton logButton = new JButton("S'identfier");
            logButton.setVerticalTextPosition(AbstractButton.TOP);
            logButton.setHorizontalTextPosition(AbstractButton.CENTER);

            logButton.setActionCommand("disable");
            logButton.addActionListener(this);


            JPanel panel = new JPanel();
            panel.setSize(new Dimension(1000,2000));
            panel.add(webcamPanel);
            panel.add(logButton);

            add(BorderLayout.SOUTH, panel);


    }
    public void actionPerformed (ActionEvent e){

        if(e.paramString().contains("Button1")){
            System.out.println("IT WORKS");
            BufferedImage image = WebcamStream.getWebcamImage();
            System.out.println(image);
            try{
                ImageIO.write(image, "JPG", new File("webcaminput.jpg"));

            }catch (IOException exception){
                exception.printStackTrace();
            }

            // Traitement réponse
            //TODO : Call API : destruire les instances
            if(false){
                Affichage.changeWindow(new SelectionWindow());
            }else{
                System.out.println(" User isn't in database ");

                Affichage.changeWindow(new ErrorWindow());
            }
        }
    }
}
