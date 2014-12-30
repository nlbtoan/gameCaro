package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.net.URL;

class PlayAudio {
    public static AudioClip  xAudio;

    /**
     * The losing audio clip.
     */
    public static AudioClip oAudio;
    public static AudioClip errAudio;

    /**
     * @param owner
     */
    public PlayAudio() {
    	
       
    }
    /**
     * get music
     */
    public static  AudioClip getMusic(String path) {
//    	System.out.println(Toolkit.getDefaultToolkit().getClass().getResource(path));
		return Applet.newAudioClip(Toolkit.getDefaultToolkit().getClass().getResource(path)); 
	}
    /**
     * load all
     */
    public static void loadAll() {
    	 xAudio =getMusic("/view/o.au");
         oAudio = getMusic("/view/x.au");
         errAudio = getMusic("/view/err.au");
    }
    /**
     * Play the winning sound.
     */
    public void userX() {
    	loadAll();
        xAudio.play();
    }

    /**
     * Play the losing sound.
     */
    public void userO() {
    	loadAll();
    	oAudio.play();
    }
	public void userWarning() {
		loadAll();
		errAudio.play();
		
	}
   
}
