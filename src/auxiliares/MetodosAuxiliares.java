package auxiliares;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MetodosAuxiliares {
	private MediaPlayer mp;
	private Media musica;

	public void MSG(String msg) {
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setTitle("Atenção");
		alerta.setHeaderText(null);
		alerta.setContentText(msg);
		alerta.showAndWait();
	}

	public boolean MSGEscolha(String msg) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Atenção");
		alerta.setHeaderText(null);
		alerta.setContentText(msg);
		Optional<ButtonType> result = alerta.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}

	public void MusicBackground(String name) {
		String nomeMusica = "./Musicas/" + name + ".mp3";
		musica = new Media(Paths.get(nomeMusica).toUri().toString());
		mp = new MediaPlayer(musica);
		mp.play();
	}

	public boolean existeArquivoSave() {
		File arquivo = new File(".\\savedata\\save.bin");
		if (arquivo.exists()) {
			return true;
		}
		return false;
	}
}
