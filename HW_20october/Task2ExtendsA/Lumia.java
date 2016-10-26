public class Lumia extends Microsoft {
	
	private String model;
	private String OS;
	private int year;
	private int memory;
	private int weight;
	
	Lumia(String model, String OS, int year, int memory, int weight) {
		this.model = model;
		this.OS = OS;
		this.year = year;
		this.memory = memory;
		this.weight = weight;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getOS() {
		return OS;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMemory() {
		return memory;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public boolean equals(Lumia lumia) {
		//Для красоты занесём всё в переменные
		String newModel = lumia.getModel();
		String newOS = lumia.getOS();
		int newYear = lumia.getYear();
		int newMemory = lumia.getMemory();
		int newWeight = lumia.getWeight();
		if (model.equals(newModel) && OS.equals(newOS) && year == newYear && memory == newMemory && weight == newWeight) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Model: " + model + "\n" + "OS: " + OS + "\n" + "Year: " + year + "\n" + "Memory: " + memory + "\n" + "Weight: " + weight;
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		result = result + model.hashCode();
		result = 31 * result + OS.hashCode();
		result = 31 * result + year;
		result = 31 * result + memory;
		result = 31 * result + weight;
		return result;
	}
	
	public Lumia clone() {
		Lumia lumiaClone = new Lumia(model, OS, year, memory, weight);
		return lumiaClone;
	}
	
}