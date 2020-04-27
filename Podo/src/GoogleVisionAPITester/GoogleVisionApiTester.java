package GoogleVisionAPITester;

import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.protobuf.ByteString;

import model.BookDAO;
import model.BookDTO;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class GoogleVisionApiTester {

	public static void main(String[] args) {
		String title = "�밨��������";
		
		BookDTO dto = new BookDTO(title);
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> path = dao.bookselect(dto);
		System.out.println(path.size());
		System.out.println(path.get(0).getPic());
		
		String text = "";
//		String a = "./WebContent/img2/";
//		path.add();
//		path.add(a + "a2.jpg");
//		path.add(a + "a3.jpg");
//		path.add(a + "a4.jpg");
//		path.add(a + "a5.jpg");
//		path.add(a + "a6.jpg");
//		path.add(a + "a7.jpg");
//		path.add(a + "a8.jpg");
//		path.add(a + "a9.jpg");

		for (int i = 0; i < path.size(); i++) {
			try {
				String imageFilePath = path.get(i).getPic(); // ���� �����������(test�̹��� ���)

				List<AnnotateImageRequest> requests = new ArrayList<>();

				ByteString imgBytes = ByteString.readFrom(new FileInputStream(imageFilePath));

				Image img = Image.newBuilder().setContent(imgBytes).build();
				Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
				AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img)
						.build();
				requests.add(request);

				try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
					BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
					List<AnnotateImageResponse> responses = response.getResponsesList();

					for (AnnotateImageResponse res : responses) {
						if (res.hasError()) {
							System.out.printf("Error: %s\n", res.getError().getMessage());
							return;
						}

						System.out.println("Text : ");
						System.out.println(res.getTextAnnotationsList().get(0).getDescription());
						text = res.getTextAnnotationsList().get(0).getDescription();
						dao.bookupdate(path.get(i).getTitleNum(), text);
						
					
						// For full list of available annotations, see http://g.co/cloud/vision/docs
						/*
						 * for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
						 * 
						 * //System.out.printf("Text: %s\n", annotation.getDescription());
						 * //System.out.printf("Position : %s\n", annotation.getBoundingPoly()); }
						 */
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(text);
		
		
		

	}

}
