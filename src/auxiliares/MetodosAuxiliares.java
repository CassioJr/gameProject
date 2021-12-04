package auxiliares;

import java.io.File;
import java.nio.file.Paths;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MetodosAuxiliares {
	
	private MediaPlayer mp;
	private Media musica;

	
	/*Metodo que apresenta uma msg ao usuario quando chamada, ela recebe como parametro o conteudo que 
	 * você deseja apresentar na mensagem que sera apresentada ao usuario*/
	public void MSG(String msg) {
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setTitle("Atenção");
		alerta.setHeaderText(null);
		alerta.setContentText(msg);
		alerta.showAndWait();
	}

	/*Metodo que apresenta uma msg de escolha perguntando sim ou não ao usuario quando chamada, 
	 * ela recebe como parametro o conteudo que você deseja apresentar na mensagem que sera apresentada ao usuario*/
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
	
	/*Metodo que faz com que uma musica seja tocada ao fundo, 
	 * ela recebe como parametro o nome do arquivo de musica dentro de (resources/songs) */
	public void MusicBackground(String name) {
		String nomeMusica = "./resources/songs/" + name + ".mp3";
		musica = new Media(Paths.get(nomeMusica).toUri().toString());
		mp = new MediaPlayer(musica);
		mp.play();
	}

	/*Metodo que verifica se o arquivo de save do usuario existe*/
	public boolean existeArquivoSave() {
		File arquivo = new File("./savedata/save.bin");
		if (arquivo.exists()) {
			return true;
		}
		return false;
	}
}
