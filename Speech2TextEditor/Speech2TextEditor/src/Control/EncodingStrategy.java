package Control;
// Choosing the encoding strategy
public interface EncodingStrategy {
	public  String encode(String str, String option); // 1 for Rot13, 2 for AtBash
}