public class Human extends Monkey {
	
	Human() {
		setSpeach(true);
	}
	
	public String[] skills() {
		if (lvlBrain <= 10) {
			beginnerSkills();
			skills[3] = "cooking";
			skills[4] = "working";
		} else {
			upperSkills();
			skills[5] = "driving a car";
			skills[6] = "fly by plane";
			skills[7] = "invent";
		} 
		return skills;
	}
}