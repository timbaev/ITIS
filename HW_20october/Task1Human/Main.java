public class Main {
	
	static String[] skills;
	static Human human = new Human();
	
	public static void main(String[] args) {
		human.setBrainLVL(15);
		human.setResidence("City");
		skills = human.skills();
		printInfo();
	}
	
	public static void printInfo() {
		int lvlBrain = human.getBrainLVL();
		String residence = human.getResidence();
		System.out.println("Human: ");
		System.out.println("level Brain: " + lvlBrain);
		System.out.println("Residence is: " + residence);
		System.out.print("Skills: ");
		for (int i = 0; i < skills.length; i++) {
			String skill = skills[i];
			System.out.print(skill + ", ");
		}
	}
}