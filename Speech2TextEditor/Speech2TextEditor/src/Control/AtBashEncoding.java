package Control;

public class AtBashEncoding extends TemplateEncoding {
	public String encode(String str) {
		String allchar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    
	    str=str.replaceAll(" ", "");
	    str=str.toUpperCase();
	    int len= str.length();
	    int len1 = allchar.length();
	    String encodedStr="";
	   
	    for(int i = 0; i < len; i++){
	        char b = str.charAt(i);
	        for(int j = 0; j < len1; j++){
	            char c = allchar.charAt(j);
	            if(c == b){
	                int index = allchar.indexOf(c);
	                int position=(len1-1)-index;
		       		encodedStr+= allchar.charAt(position);
	                break;  
	            }
	        }
	    }
	    return(encodedStr);
	}
}
