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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	@FXML
	private Button continuar;
	private Stage primaryStage;

	/*Metodo que chama a tela para realizar a tela de cria��o de personagem*/
	public void newGame(ActionEvent event) throws IOException {
		// Main.instancia().MusicBackground("create");
		AnchorPane fxmlCharCreation = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaCriacaoPersonagem.fxml"));
		Scene NovoJogo = new Scene(fxmlCharCreation);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(NovoJogo);
		primaryStage.show();
	}
	
	/*Metodo que chama a tela de espera que serve para continuar o jogo*/
	public void continueGame(ActionEvent event) throws IOException {
		Main.operacoes().lerArquivo();
		AnchorPane fxmlCharCreation = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
		Scene NovoJogo = new Scene(fxmlCharCreation);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(NovoJogo);
		primaryStage.show();
	}


	/*Metodo alternativo que realiza o fechamento do programa, inves de o usuario clicar no fechar no bot�o da janela*/
	public void exit() {
		System.exit(0);
	}

	/*Metodo que verifica se o arquivo de save do usuario existe, ent�o ele deixa visivel o bot�o de contiunuar o save*/
	public boolean existFile() {
		File arquivo = new File("./savedata/save.bin");
		if (arquivo.exists()) {
			continuar.setVisible(true);
			return true;
		}
		return false;
	}

	/*
	 * Metodo para tocar a musica de background da tela de titulo ela chama um
	 * metodo da main para n�o ter necessidade de toda hora que chamar ela, a classe
	 * ser instanciada fazendo assim a musica n�o tocar.
	 * O metodo recebe como parametro o nome da musica que deseja que seja tocada
	 */

	public void playMusic() {
		Main.instancia().MusicBackground("Music1");
	}

	/*
	 * Metodo que faz com que assim que o programa inicie chama o metodo de music que faz a musica come�ar
	 * a tocar, e o metodo Que verifica se existe o arquivo de save para apresentar o bot�o de continuar
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playMusic();
		existFile();
		Main.operacoes().verificaPastaSave();
	}
}
