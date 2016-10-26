public class State {
	
	protected String state;
	protected String language;
	protected String president;
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void setPresident(String president) {
		this.president = president;
	}
	
	public String getState() {
		return state;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getPresident() {
		return president;
	}
}