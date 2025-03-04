interface MusicPlayer {
	void play(String audioType, String fileName);
}

interface AdvanceMusicPlayer {
	void playMp4(String fileName);
	void playVlc(String fileName);
}

class Mp4MusicPlayer implements AdvanceMusicPlayer{
	public void playMp4(String fileName) {
		System.out.println("MP4 Player playing file " + fileName);
	}
	public void playVlc(String fileName) {
		
	}
}

class VlcMusicPlayer implements AdvanceMusicPlayer{
	public void playVlc(String fileName) {
		System.out.println("vlc Player playing file " + fileName);
	}

	public void playMp4(String fileName) {
	}
}

class AudioPlayer implements MusicPlayer {
	MusicPlayerAdapter musicPlayerAdapter;
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("mp3 Player playing file " + fileName);
		} else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			musicPlayerAdapter = new MusicPlayerAdapter(audioType);
			musicPlayerAdapter.play(audioType, fileName);
		}
	}
}

class MusicPlayerAdapter implements MusicPlayer {
	AdvanceMusicPlayer advanceMusicPlayer;

	public MusicPlayerAdapter(String audioType) { 
		if(audioType.equalsIgnoreCase("vlc")) {
			advanceMusicPlayer = new VlcMusicPlayer();
		} else {
			advanceMusicPlayer = new Mp4MusicPlayer();
		}
	}

	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("vlc")){
			advanceMusicPlayer.playVlc(fileName);
		} else {
			advanceMusicPlayer.playMp4(fileName);
		}
	}
}


public class AdapterPattern {
	public static void main(String[] args) {
		AudioPlayer AudioPlayer = new AudioPlayer();

		AudioPlayer.play("mp3", "ABC0");
		AudioPlayer.play("mp4", "ABC1");
		AudioPlayer.play("vlc", "ABC2");
	}
}