public class State {
	
	protected String state;
	protected String language;
	protected String president;
	
	State(String state, String language, String president) {
		this.state = state;
		this.language = language;
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