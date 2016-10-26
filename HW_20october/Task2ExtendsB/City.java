public class City extends Republic {
	
	private String city, mayor, state, language, president, republic, presidentOfRepublic, republicLanguage, republicLanguageNoneState;
	private int year;
	
	City(String state, String language, String president, String republic, String presidentOfRepublic, 
		String republicLanguage, String city, String mayor, int year) {
		setState(state);
		setLanguage(language);
		setPresident(president);
		setRepublic(republic);
		setPresidentOfRepublic(presidentOfRepublic);
		setRepublicLanguage(republicLanguage);
		republicLanguageNoneState = republicLanguage;
		this.city = city;
		this.mayor = mayor;
		this.year = year;
		initialization();
	}
	
	public void initialization() {
		state = getState();
		language = getLanguage();
		president = getPresident();
		republic = getRepublic();
		presidentOfRepublic = getPresidentOfRepublic();
		republicLanguage = getRepublicLanguages();
	}
	
	public String getCity() {
		return city;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMayor() {
		return mayor;
	}
	
	public boolean equals(City newCity) {
		String _state = newCity.getState();
		String _language = newCity.getLanguage();
		String _president = newCity.getPresident();
		String _republic = newCity.getRepublic();
		String _presidentOfRepublic = newCity.getPresidentOfRepublic();
		String _republicLanguages = newCity.getRepublicLanguages();
		String _city = newCity.getCity();
		String _mayor = newCity.getMayor();
		int _year = newCity.getYear();
		if (state.equals(_state) && language.equals(_language) && president.equals(_president) && republic.equals(_republic)
			&& presidentOfRepublic.equals(_presidentOfRepublic) && republicLanguage.equals(_republicLanguages)
			&& city.equals(_city) && mayor.equals(_mayor) && year == _year) {
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String result = "State: " + state + "\n" + "State language: " + language + "\n" + "President of the state: " + president
			+ "\n" + "Republic: " + republic + "\n" + "President of the republic: " + presidentOfRepublic 
			+ "\n" + "Republic languages: " + republicLanguage + "\n" + "City: " + city + "\n" + "Mayor of the city: " + mayor
			+ "\n" + "Year foundation of the city: " + year;
		return result;
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		result = result + state.hashCode();
		result = 31 * result + language.hashCode();
		result = 31 * result + president.hashCode();
		result = 31 * result + republic.hashCode();
		result = 31 * result + presidentOfRepublic.hashCode();
		result = 31 * result + republicLanguage.hashCode();
		result = 31 * result + city.hashCode();
		result = 31 * result + mayor.hashCode();
		result = 31 * result + year;
		return result;
	}
	
	public City clone() {
		City newCity = new City(state, language, president, republic, presidentOfRepublic, republicLanguageNoneState, city, mayor, year);
		return newCity;
	}
	
}