package DAL;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ContactAPI {
    public static boolean Auth(){
        return true;
    }

    public String getFaceId (Image image) throws JsonProcessingException {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJFEDG6WLUU5FJOHA", "OTkqjS4Gr1jKCMyX1rdcluTkVtATzQctg2Ncibcu");
        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.EU_WEST_1).build();

        SearchFacesByImageResult searchFacesByImageResult =
                rekognitionClient.searchFacesByImage(createSearchFace(image));
        FaceMatch faceImageMatche = searchFacesByImageResult.getFaceMatches().get(0);

        if(!similarity(faceImageMatche)){
            throw  new Error("Pas de ressemblance");
        }
        System.out.println(faceImageMatche.getFace().getFaceId());
        return faceImageMatche.getFace().getFaceId();

    }

    private SearchFacesByImageRequest createSearchFace(Image image) {
        return new SearchFacesByImageRequest().withCollectionId("test").withImage(image).withMaxFaces(1);
    }

    private boolean similarity (FaceMatch face ){
        boolean response = false;
        if(face.getSimilarity() >= 80){
            response = true;
        }
        return response;
    }
}
