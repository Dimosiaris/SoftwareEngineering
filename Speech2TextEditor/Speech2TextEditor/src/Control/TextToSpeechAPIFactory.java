package Control;

public class TextToSpeechAPIFactory {
	
	public TextToSpeechAPI createAPI(String API) {
		if(API.equals("FreeTTS")) {
			return new FreeTTSAdapter();
		}
		else if(API.equals("FakeAPI")){
			return new FakeTextToSpeechAPI();
		}else {
			return new FreeTTSAdapter();
		}
	}
}
