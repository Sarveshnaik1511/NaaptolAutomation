package pom;

public class BasePage {
	public String removeCommaFromString(String s) {
		String p = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				continue;
			} else {
				p = p + s.charAt(i);
			}
		}
		return p;

	}

}
