public class Republic extends State {
	
	protected String republic;
	protected String presidentOfRepublic;
	protected String republicLanguages;
	
	Republic(String state, String language, String president, String republic, String presidentOfRepublic, String republicLanguages) {
		super(state, language, president);
		this.republic = republic;
		this.presidentOfRepublic = presidentOfRepublic;
		setRepublicLanguage(republicLanguages);
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