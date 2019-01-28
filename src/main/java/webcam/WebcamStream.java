package webcam;

import java.awt.Dimension;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class WebcamStream {
    public static void main (String[] args) throws IOException{

        Dimension[] nonStandardResolutions = new Dimension[] {
                WebcamResolution.PAL.getSize(),
                WebcamResolution.HD.getSize(),
                new Dimension(2000, 1000),
                new Dimension(1000, 500),
        };

        Webcam webcam = Webcam.getDefault();

        webcam.setCustomViewSizes(nonStandardResolutions);
        webcam.setViewSize(WebcamResolution.HD.getSize());
        webcam.open();
        ImageIO.createImageInputStream(webcam.getImage());

        ImageIO.write(webcam.getImage(), "JPG", new File("webcaminput.jpg"));
        webcam.close();
    }
}
