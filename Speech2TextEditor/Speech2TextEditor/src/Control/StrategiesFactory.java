package Control;

public class StrategiesFactory {
	public EncodingStrategy createStrategy(String strategy) {
		if(strategy.equals("Rot13")){
			return new Rot13Encoding();
		}else if(strategy.equals("AtBash")){
			return new AtBashEncoding(); 	// TODO: FIX, add atBash encoding and switch else
		}else {
			return new Rot13Encoding();
		}
	}
}
