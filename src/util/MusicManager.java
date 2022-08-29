package util;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public final class MusicManager {
	private MediaPlayer mp;
	private Media musica;
	private static MusicManager instancia;

	public static MusicManager getInstance() {
		if (instancia == null) {
			instancia = new MusicManager();
		}
		return instancia;
	}

	private MusicManager() {}

	public void MusicBackground(String name) {
		String nomeMusica = "./resources/songs/" + name + ".mp3";
		musica = new Media(Paths.get(nomeMusica).toUri().toString());
		mp = new MediaPlayer(musica);
		mp.play();
	}

}
