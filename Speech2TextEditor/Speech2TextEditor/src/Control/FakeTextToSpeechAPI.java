package Control;
// creating a fake api similar to TexttoSpeech api for testing
public class FakeTextToSpeechAPI implements TextToSpeechAPI {
	
	private int volume;
	private int pitch;
	private int rate;
	private String textToBePlayed;
	
	public void play(String line, int volume, int pitch, int rate) {
		this.textToBePlayed = line;
		System.out.println(line);
	}
	public int getVolume() {
		return this.volume;
	}
	public void setVolume(int vol){
		this.volume = vol;
	}
	public int getPitch() {
		return this.pitch;
	}
	public void setPitch(int pitch) {
		this.pitch = pitch;
	}
	public int getRate() {
		return this.rate;
	}
	public void setRate(int rate){
		this.rate = rate;
	}
	public String getTextToBePlayed() {
		return this.textToBePlayed;
	}
}
