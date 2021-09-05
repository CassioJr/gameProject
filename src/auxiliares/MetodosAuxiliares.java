package auxiliares;

import java.nio.file.Paths;

import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MetodosAuxiliares{
    private MediaPlayer mp;
    private Media musica;

	public void MSG(String msg){
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setTitle("Aten��o");
		alerta.setHeaderText(null);
		alerta.setContentText(msg);
		alerta.showAndWait();
	}

	
	public void MusicBackground(String name) {
			String nomeMusica = "./Musicas/"+name+".mp3";
			musica = new Media(Paths.get(nomeMusica).toUri().toString());
			mp = new MediaPlayer(musica);
			mp.play();
}
	
}
