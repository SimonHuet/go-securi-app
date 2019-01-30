package webcam;

import java.awt.Dimension;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class WebcamStream {

    /**
     * Get Webcam bind
     * @return webcam
     */
    public static Webcam getWebcam(){
        Dimension[] nonStandardResolutions = new Dimension[] {
                WebcamResolution.PAL.getSize(),
                WebcamResolution.HD.getSize(),
                new Dimension(1000, 500),
                new Dimension(500, 250),
        };

        Webcam webcam = Webcam.getDefault();

        webcam.setCustomViewSizes(nonStandardResolutions);
        webcam.setViewSize(WebcamResolution.HD.getSize());
        webcam.open();

        return webcam;
    }

    /**
     * Get image from webcam;
     * @return ImageInputStream
     */
    public static BufferedImage getWebcamImage() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();

        BufferedImage image = webcam.getImage();
        webcam.close();

        return image;
    }
}
