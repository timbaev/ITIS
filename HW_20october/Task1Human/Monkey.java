public class Monkey {
	
	protected int lvlBrain; //от 0 до 10
	private String residence; //Место жительства
	protected boolean speach = false;
	protected String[] skills = new String[8];
	
	
	public void setBrainLVL(int lvlBrain) {
		this.lvlBrain = lvlBrain;
	}
	
	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	public void setSpeach(boolean speach) {
		this.speach = speach;
	}
	
	public int getBrainLVL() {
		return lvlBrain;
	}
	
	public String getResidence() {
		return residence;
	}
	
	public boolean getSpeach() {
		return speach;
	}
	
	public void beginnerSkills() {
		skills[0] = "receive a fire";
		skills[1] = "climb trees";
		skills[2] = "speach is " + speach;
	}
	
	public void upperSkills() {
		beginnerSkills();
		skills[3] = "hunting";
		skills[4] = "null"; //Придумать позже
	}
	
	public String[] skills() {
		if (lvlBrain <= 5) {
			beginnerSkills();
		} else {
			upperSkills();
		} 
		return skills;
	}
	
	
}