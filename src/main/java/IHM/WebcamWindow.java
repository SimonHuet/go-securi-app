package IHM;

import Controlleur.Affichage;
import DAL.ContactAPI;
import DAL.UserDAL;
import Model.user;
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
import java.nio.ByteBuffer;

import com.amazonaws.services.rekognition.model.Image;

public class WebcamWindow extends JPanel implements ActionListener {

    private UserDAL userDAL;

    public WebcamWindow() {
        userDAL = new UserDAL();
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
            String faceId = null;

            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(image, "JPG", outputStream);
                byte[] bytes = outputStream.toByteArray();
                Image photo = new Image();
                photo.setBytes(ByteBuffer.wrap(bytes));
                ContactAPI contactAPI = new ContactAPI();
                faceId = contactAPI.getFaceId(photo);
            } catch (Exception exception) {
                System.out.println(" User isn't in collection amazon ");
                Affichage.changeWindow(new ErrorWindow());
            }

            // Traitement réponse
            try{
                user user = userDAL.selectByFaceId(faceId);
                Affichage.changeWindow(new SelectionWindow(user));
            }
            catch(Exception ex){
                ex.printStackTrace();
                System.out.println(" User isn't in database ");
                Affichage.changeWindow(new ErrorWindow());
            }
        }
    }
}
