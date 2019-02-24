package DAL;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.FaceMatch;
import com.amazonaws.services.rekognition.model.SearchFacesByImageRequest;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.SearchFacesByImageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ContactAPI {
    public static boolean Auth(){
        return true;
    }
    public static AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

    public String getFaceId (Image image) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SearchFacesByImageResult searchFacesByImageResult =
                rekognitionClient.searchFacesByImage(createSearchFace(image));
        FaceMatch faceImageMatche = searchFacesByImageResult.getFaceMatches().get(0);
        if(!similarity(faceImageMatche)){
            throw  new Error("Pas de ressemblance");
        }
        return faceImageMatche.getFace().getFaceId();
    }

    private SearchFacesByImageRequest createSearchFace(Image image) {
        return new SearchFacesByImageRequest().withCollectionId("").withImage(image).withMaxFaces(1);
    }

    private boolean similarity (FaceMatch face ){
        boolean response = false;
        if(face.getSimilarity() >= 80){
            response = true;
        }
        return response;
    }
}
