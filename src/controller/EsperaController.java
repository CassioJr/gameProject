package controller;

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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EsperaController implements Initializable {
	private Stage primaryStage;
	
	@FXML
	private Label nomePlayer;
	@FXML
	private Label nivelPlayer;
	@FXML 
	private AnchorPane telaSobreHistoria;
	@FXML
	private Label ouroPlayer;
	@FXML
	private ImageView inimigo;
	@FXML
	private ImageView jogador;
	
	/*Metodo chama o metodo de carregar informa��es do player da classe de operacoes*/
	public void Informacoes() {
		Main.operacoes().carregaInformacoes(nomePlayer, nivelPlayer, ouroPlayer);
	}

	/*Metodo que quando � clicado o bot�o de sobreHistoria ele deixa como visivel a tela telaSobreHistoria e caso 
	 * ela esteja visivel e ela seja clicada ela � setada com visibilidade false*/
	public void btnSobreHistoria(){
		if(!telaSobreHistoria.isVisible()) {
			telaSobreHistoria.setVisible(true);
		}else {
			telaSobreHistoria.setVisible(false);
		}
	}
	
	public void btnreino() {
		System.out.println("Ol� Mundo");
	}
	
	/*Metodo que quando � clicado o bot�o de dragao do mapa ele chama a tela de combate para a 
	 * batalha contro um mob definido*/
	public void btnDragon(ActionEvent event) throws IOException {
		FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaCombate.fxml"));
		Parent root = fxmlcombate.load();
		
		CombateController combate = fxmlcombate.getController();
		combate.mobMapaDragao1();
		
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	
	/*Metodo que chama a tela de menu inicial caso o player aceite*/
	public void btnMenu(ActionEvent event) throws IOException {
		if(Main.instancia().MSGEscolha("Deseja voltar ao menu?") == true) {
			AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
			Scene main = new Scene(fxmlmenu);
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(main);
		}
	}
	
	/*Metodo que chama a tela de combate*/
	public void btnExplorar(ActionEvent event) throws IOException {
		FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaCombate.fxml"));
		Parent root = fxmlcombate.load();
		
		CombateController combate = fxmlcombate.getController();
		combate.randomizaCombate();
		
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}

	/*Metodo quando a tela de espera � inicializada carrega as informa��es do player atulizadas e carrega o arquivo de monstros*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Informacoes();
		Main.operacoes().lerArquivoMonstros();	
	}
}
