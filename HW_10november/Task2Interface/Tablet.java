import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Tablet implements CallInterface, PayInterface, PhotoInterface {
	
	private String name;
	private boolean camera;
	private int count;
	
	public Tablet(String name, boolean camera) {
		this.name = name;
		this.camera = camera;
	}
	
	public boolean startCall() {
		System.out.println("No, you shouldn't call from the tablet :c");
		return false;
	}
	
	public boolean endCall() {
		System.out.println("YOU. SHOULD`T. CALL. FROM. THE. TABLET.");
		return false;
	}
	
	public void emergencyCall() {
		System.out.println("ohh..gods..");
	}

	public void pay(String shope, int price) {
		System.out.println("Error..it is a tablet, have not a NFC");
	}
	
	public void priceHistory() {
		System.out.println("null");
	}
	
	//новых идей не появилось, поэтому пришось дублировать код :(
	public void takePhoto(String text) {
		if (camera) {
			BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.drawString(text, 10, 20);
			try {
				ImageIO.write(image, "jpg", new File("C://Work/ImageTablet" + count + ".jpg"));
				count++;
			} catch (IOException e) {
				System.out.println("Error, could not create img");
			}
		} else {
			System.out.println("Error..you have not a camera");
		}
	}
	
	public void deletePhoto(int number) {
		File file = new File("C://Work/ImageTablet" + number + ".jpg");
		if (file.delete()) {
			System.out.println("Image was deleted");
		} else {
			System.out.println("Error..file not found");
		}
	}
}