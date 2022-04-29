package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utils.FileManagement;

public class MenuController implements Initializable {
	@FXML
	private Button cont;
	private Stage primaryStage;

	/* Metodo que chama a tela para realizar a tela de criação de personagem */
	public void newGame(ActionEvent event) throws IOException {
		changeScene(event, "TelaCriacaoPersonagem");
	}

	/* Metodo que chama a tela de espera que serve para continuar o jogo */
	public void continueGame(ActionEvent event) throws IOException {
		Main.operacoes().lerArquivo();
		changeScene(event, "TelaEspera");
	}

	/*
	 * Metodo alternativo que realiza o fechamento do programa, inves de o usuario
	 * clicar no fechar no botão da janela
	 */
	public void exit() {
		System.exit(0);
	}


	/*
	 * Metodo para tocar a musica de background da tela de titulo ela chama um
	 * metodo da main para não ter necessidade de toda hora que chamar ela, a classe
	 * ser instanciada fazendo assim a musica não tocar.
	 * O metodo recebe como parametro o nome da musica que deseja que seja tocada
	 */

	public void playMusic() {
		Main.instancia().MusicBackground("Music1");
	}

	public void changeScene(ActionEvent event, String tela) {
		try {
			Parent fxmlCharCreation = FXMLLoader.load(getClass().getResource("/view/" + tela + ".fxml"));
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(new Scene(fxmlCharCreation));
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("Erro ao carregar a tela!");
		}
	}

	public void existSaveFile(){
		if(FileManagement.existSave() == true)
		cont.setVisible(true);
	}

	/*
	 * Metodo que faz com que assim que o programa inicie, inicie tambem o que foi definido no seu esqueleto
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playMusic();
		existSaveFile();
		FileManagement.SaveDirectoryExists();
	}
}
