package Control;


import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.en.us.CMUDiphoneVoice;



public class FreeTTSAdapter implements TextToSpeechAPI{
	private int volume = 70;
	private int pitch;
	private int rate;
	
	private Voice voice;
	public void play(String line, int volume, int pitch, int rate) {
		System.out.println(volume);
		
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    voice = VoiceManager.getInstance().getVoice("kevin16");
	    if (voice != null) {
	        voice.allocate(); // Allocating Voice
	        try {
	            voice.setRate(rate); // Setting the rate of the voice
	            this.voice.setPitch(pitch); // Setting the Pitch of the voice
	            this.voice.setVolume(volume); // Setting the volume of the voice
	            this.voice.speak(line); // Calling speak() method

	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }

	    } else {
	        throw new IllegalStateException("Cannot find voice: kevin16");
	    }
	}
	
	/*
	 *  		GETTERS AND SETTERS
	 */
	public int getVolume() {
		return (int)voice.getVolume();
	}
	
	public int getPitch() {
		return (int)voice.getPitch();
	}
	
	public int getRate() {
		return (int)voice.getRate();
	}
	
	public void setVolume(int vol) {
		this.voice.setVolume((float)vol);
	}
	
	public void setPitch(int pitch) {
		this.voice.setPitch((float)pitch);
	}
	
	public void setRate(int rate) {
		this.voice.setRate((float)rate);
	}
}
