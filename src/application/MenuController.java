package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	@FXML
	private Button continuar;
	private Stage primaryStage;

	/*Metodo que chama a tela de espera que serve para continuar o jogo*/
	public void continueGame(ActionEvent event) throws IOException {
		Main.operacoes().lerArquivo();
		AnchorPane fxmlCharCreation = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
		Scene NovoJogo = new Scene(fxmlCharCreation);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(NovoJogo);
		primaryStage.show();
	}

	/*Metodo que chama a tela para realizar a tela de criação de personagem*/
	public void newGame(ActionEvent event) throws IOException {
		// Main.instancia().MusicBackground("create");
		AnchorPane fxmlCharCreation = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaCriacaoPersonagem.fxml"));
		Scene NovoJogo = new Scene(fxmlCharCreation);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(NovoJogo);
		primaryStage.show();
	}

	/*Metodo alternativo que realiza o fechamento do programa, inves de o usuario clicar no fechar no botão da janela*/
	public void exit() {
		System.exit(0);
	}

	/*Metodo que verifica se o arquivo de save do usuario existe, então ele deixa visivel o botão de contiunuar o save*/
	public boolean existeArquivo() {
		File arquivo = new File("./savedata/save.bin");
		if (arquivo.exists()) {
			continuar.setVisible(true);
			return true;
		}
		return false;
	}

	/*
	 * Metodo para tocar a musica de background da tela de titulo ela Chama um
	 * metodo da main para não ter necessidade de toda hora que chamar ela A classe
	 * ser instanciada, fazendo assim a musica não tocar.
	 */

	public void music() {
		// Main.instancia().MusicBackground("main_title");
	}

	/*
	 * Metodo que faz com que assim que o programa inicie chama o metodo de music que faz a musica começar
	 * a tocar, e o metodo Que verifica se existe o arquivo de save para apresentar o botão de continuar
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// music();
		existeArquivo();
	}
}
