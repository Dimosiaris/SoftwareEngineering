package Control;
// creating strategies
public class StrategiesFactory {
	public EncodingStrategy createStrategy(String strategy) {
		if(strategy.equals("Rot13")){
			return new Rot13Encoding();
		}else if(strategy.equals("AtBash")){
			return new AtBashEncoding();
		}else {
			return new Rot13Encoding();
		}
	}
}
