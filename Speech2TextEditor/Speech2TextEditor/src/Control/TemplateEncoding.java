package Control;

public abstract class TemplateEncoding implements EncodingStrategy{
	public abstract String encodeString(String str);
	
	public  String encode(String str, String option) {
		str=str.replaceAll(" ", "");
		str=str.toUpperCase();
		if(option.equalsIgnoreCase("Rot13")) {
			TemplateEncoding encoder = new Rot13Encoding();
			return encoder.encodeString(str);
		}else {
			TemplateEncoding encoder = new AtBashEncoding();
			return encoder.encodeString(str);
		}
	}
}
	
