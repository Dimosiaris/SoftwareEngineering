package Control;

import java.util.Locale; 
import javax.speech.Central; 
import javax.speech.synthesis.Synthesizer; 
import javax.speech.synthesis.SynthesizerModeDesc;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.JavaClipAudioPlayer;
import com.sun.speech.freetts.en.us.CMUDiphoneVoice;
import com.sun.speech.freetts.en.us.CMULexicon; 



public class FreeTTSAdapter implements TextToSpeechAPI{
	
	public void play(String line, int volume, int pitch, int rate) {
		System.out.println(volume);
		Voice voice;
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    voice = VoiceManager.getInstance().getVoice("kevin16");
	    if (voice != null) {
	        voice.allocate();// Allocating Voice
	        try {
	            voice.setRate(rate);// Setting the rate of the voice
	            voice.setPitch(pitch);// Setting the Pitch of the voice
	            voice.setVolume(volume);// Setting the volume of the voice
	            voice.speak(line);// Calling speak() method

	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }

	    } else {
	        throw new IllegalStateException("Cannot find voice: kevin16");
	    }
	}
	
	public int getVolume() {
		Voice voice = new CMUDiphoneVoice();
		return (int)voice.getVolume();
	}
	
	public int getPitch() {
		Voice voice = new CMUDiphoneVoice();
		return (int)voice.getPitch();
	}
	
	public int getRate() {
		Voice voice = new CMUDiphoneVoice();
		return (int)voice.getRate();
	}
	
	public void setVolume(int vol) {
		Voice voice = new CMUDiphoneVoice();
		voice.setVolume((float)vol);
	}
	
	public void setPitch(int pitch) {
		Voice voice = new CMUDiphoneVoice();
		voice.setPitch((float)pitch);
	}
	
	public void setRate(int rate) {
		Voice voice = new CMUDiphoneVoice();
		voice.setRate((float)rate);
	}
}