package utils;

import java.io.File;
import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MetodosAuxiliares {
	
	private MediaPlayer mp;
	private Media musica;

	/*Metodo que faz com que uma musica seja tocada ao fundo, 
	 * ela recebe como parametro o nome do arquivo de musica dentro de (resources/songs) */
	public void MusicBackground(String name) {
		String nomeMusica = "./resources/songs/" + name + ".mp3";
		musica = new Media(Paths.get(nomeMusica).toUri().toString());
		mp = new MediaPlayer(musica);
		mp.play();
	}


}
