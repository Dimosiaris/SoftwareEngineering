package Control;

public interface TextToSpeechAPI {
	public void play(String line, int volume, int pitch, int rate);
	public int getVolume();
	public void setVolume(int vol);
	public int getPitch();
	public void setPitch(int pitch);
	public int getRate();
	public void setRate(int rate);
}
