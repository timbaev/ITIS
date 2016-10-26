public class Republic extends State {
	
	protected String republic;
	protected String presidentOfRepublic;
	protected String republicLanguages;
	
	public void setRepublic(String republic) {
		this.republic = republic;
	}
	
	public void setPresidentOfRepublic(String presidentOfRepublic) {
		this.presidentOfRepublic = presidentOfRepublic;
	}
	
	public String getRepublic() {
		return republic;
	}
	
	public String getPresidentOfRepublic() {
		return presidentOfRepublic;
	}
	
	public void setRepublicLanguage(String language) {
		String stateLanguage = getLanguage();
		republicLanguages = stateLanguage + " and " + language;
	}
	
	public String getRepublicLanguages() {
		return republicLanguages;
	}
}