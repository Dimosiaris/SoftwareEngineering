package Control;

public class Rot13Encoding extends TemplateEncoding {
	
	public String encode(String str) {
		String encodedStr = "";
		for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            encodedStr += c;
        }
		encodedStr += "\n";
		return encodedStr;
	}
}