package DAL;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;


public class ContactAPI {

    public String getFaceId (Image image) throws JsonProcessingException {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJFEDG6WLUU5FJOHA", "OTkqjS4Gr1jKCMyX1rdcluTkVtATzQctg2Ncibcu");
        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.EU_WEST_1).build();

        SearchFacesByImageResult searchFacesByImageResult =
                rekognitionClient.searchFacesByImage(createSearchFace(image));
        FaceMatch faceImageMatch = searchFacesByImageResult.getFaceMatches().get(0);

        if(!similarity(faceImageMatch)){
            throw  new Error("Pas de ressemblance");
        }

        return faceImageMatch.getFace().getFaceId();

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
