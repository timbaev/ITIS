import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	static Timer timer = new Timer();
	
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone();
		Tablet tablet = new Tablet("Samsung", true);
		Scanner scanner = new Scanner(System.in);
		System.out.print("Pick the device: ");
		String device = scanner.nextLine();
		//Просто проверка всех методов, и ничего более
		if (device.equals("Smartphone")) {
			System.out.print("Enter the command: ");
			while (true) {
				String command = scanner.nextLine();
				switch (command) {
					case "start call":
						phone.startCall();
						printNewCommandTimer();
						break;
					case "end call":
						phone.endCall();
						System.out.print("Enter the command: ");
						break;
					case "emergency call":
						phone.emergencyCall();
						printNewCommandTimer();
						break;
					case "pay":
						System.out.print("Enter shop: ");
						String shop = scanner.nextLine();
						System.out.print("Enter price: ");
						int price = scanner.nextInt(); //FIXME исправить ввод int
						phone.pay(shop, price);
						System.out.print("Enter the command: ");
						break;
					case "history of purchases":
						phone.priceHistory();
						System.out.print("Enter the command: ");
						break;
					case "clear history of purchases":
						phone.clearHistoryPurchase();
						System.out.print("Enter the command: ");
						break;
					case "delete from hostory of purchases":
						System.out.print("Enter number of item for delete: ");
						int item = scanner.nextInt(); //FIXME исправить ввод int
						phone.deleteFromHistoryPurchase(item);
						System.out.print("Enter the command: ");
						break;
					case "take photo":
						System.out.print("Enter text in photo: ");
						String text = scanner.nextLine();
						phone.takePhoto(text);
						System.out.print("Enter the command: ");
						break;
					case "delete photo":
						System.out.print("Enter number image: ");
						int number = scanner.nextInt();
						phone.deletePhoto(number);
						System.out.print("Enter the command: ");
						break;
					default:
						System.out.println("Error, command not found");
						System.out.print("Enter the command: ");
						break;
				}
			}
		} else if (device.equals("Tablet")) {
			while (true) {
				System.out.print("Enter the command: ");
				String command = scanner.nextLine();
				switch (command) {
					case "start call":
						tablet.startCall();
						break;
					case "end call":
						tablet.endCall();
						break;
					case "emergency call":
						tablet.emergencyCall();
						break;
					case "pay":
						tablet.pay(null, 0);
						break;
					case "history of purchases":
						tablet.priceHistory();
						break;
					case "take photo":
						System.out.print("Enter text in photo: ");
						String text = scanner.nextLine();
						tablet.takePhoto(text);
						break;
					case "delete photo":
						System.out.print("Enter number image: ");
						int number = scanner.nextInt();
						tablet.deletePhoto(number);
						break;
					default:
						System.out.println("Error, command not found");
						break;
				}
			}
		} else {
			System.out.println("Error..device not found");
		}
	}
	
	public static void printNewCommandTimer() {
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.print("Enter the command: ");
			}
		};
		timer.schedule(task, 3500);
	}
}