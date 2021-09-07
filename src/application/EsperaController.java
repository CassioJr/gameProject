package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EsperaController implements Initializable {
	@FXML
	private Label nomePlayer;

	@FXML
	private Label nivelPlayer;
	@FXML 
	private AnchorPane telaSobreHistoria;
	
	@FXML
	private Label ouroPlayer;
	private Stage primaryStage;

	public void Informacoes() {
		Main.operacoes().carregaInformacoes(nomePlayer, nivelPlayer, ouroPlayer);
	}

	public void btnMenu(ActionEvent event) throws IOException {
		AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
		Scene main = new Scene(fxmlmenu);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(main);
	}

	public void btnSobreHistoria(){
		if(!telaSobreHistoria.isVisible()) {
			telaSobreHistoria.setVisible(true);
		}else {
			telaSobreHistoria.setVisible(false);
		}
	}
	
	public void btnreino() {
		System.out.println("Olá Mundo");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Informacoes();
	}
}
