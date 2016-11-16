import java.util.Timer;
import java.util.ArrayList;
import java.util.TimerTask;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SmartPhone implements CallInterface, PhotoInterface, PayInterfaceExtend {
	
	private boolean callState;
	private int count;
	private ArrayList<Purchase> purchase = new ArrayList<Purchase>();
	private Timer timer = new Timer();
	
	public boolean startCall() {
		if (!callState) {
			System.out.println("OK, start the call...wait...");
			
			TimerTask task = new TimerTask() {
				public void run() {
					System.out.println("Call has been start");
				}
			};
			
			timer.schedule(task, 3000);
			callState = true;
		} else {
			System.out.println("Error..call is not finished");
		}
		return callState;
	}
	
	public boolean endCall() {
		if (callState) {
			callState = false;
			System.out.println("OK..call has been finish");
		} else {
			System.out.println("Error..call already finished");
		}
		return callState;
	}
	
	public void emergencyCall() {
		System.out.println("Oh no..I call to 112..wait..");
		
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("It is 112..what happened?");
			}
		};
		
		timer.schedule(task, 3000);
	}
	
	public void pay(String shop, int price) {
		purchase.add(new Purchase(shop, price));
	}
	
	public void priceHistory() {
		System.out.println("You history of purchases");
		for (int i = 0; i < purchase.size(); i++) {
			System.out.println(purchase.get(i).toString());
			System.out.println("_______________________");
		}
	}
	
	public void clearHistoryPurchase() {
		purchase.clear();
	}
	
	public void deleteFromHistoryPurchase(int item) {
		purchase.remove(item);
	}
	
	public void takePhoto(String text) {
		BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.drawString(text, 10, 20);
		try {
			ImageIO.write(image, "jpg", new File("C://Work/Image" + count + ".jpg"));
			count++;
		} catch (IOException e) {
			System.out.println("Error, could not create img");
		}
	}
	
	public void deletePhoto(int number) {
		File file = new File("C://Work/Image" + number + ".jpg");
		if (file.delete()) {
			System.out.println("Image was deleted");
		} else {
			System.out.println("Error..file not found");
		}
	}
}