package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CombateController implements Initializable{
	@FXML
	private ImageView jogador,inimigo;
	@FXML
	private Label nomeMonstro, vidaMonstro, manaMonstro, NivelPlayer, VidaPlayer, ManaPlayer;
	private Stage primaryStage;
	private Random rand;
	private boolean turnoPlayer = true;
	
	private int quantiaOuro;
	
	public void randomizaCombate() {
		Main.operacoes().pegaInformaçõesMonstro(inimigo, nomeMonstro, vidaMonstro, manaMonstro);
	}

	public void mobMapaDragao1() {
		File file = new File("./resources/Monsters/dragon.png");
		Image image = new Image(file.toURI().toString());
		inimigo.setImage(image);
	}

	public void fugir(ActionEvent event) throws IOException {
		if (Main.instancia().MSGEscolha("Você deseja fugir?") == true) {
			AnchorPane fxmlespera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
			Scene espera = new Scene(fxmlespera);
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(espera);
		}
	}

	public void atacar(ActionEvent event) throws IOException {
		turnoPlayer();
		turnoInimigo();
		if (Main.operacoes().condicaoVitoria(nomeMonstro.getText()) == true) {
		ganhouLuta();
		FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaVitoria.fxml"));
		Parent root = fxmlcombate.load();
		aposController combate = fxmlcombate.getController();
		combate.colocaValores(quantiaOuro, rand.nextInt(30));
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();	
		}
	}

	public void ganhouLuta(){
		rand = new Random();
		quantiaOuro = rand.nextInt(10);
		Main.operacoes().adicionaExperiencia();
		Main.operacoes().adicionaGold(quantiaOuro);
		Main.operacoes().resetaAtributos();
		Main.operacoes().salvarArquivo();
		System.out.println("Ganhou");
	}
	
	public void turnoPlayer() {
		if(turnoPlayer == true) {
		rand = new Random();
		Main.operacoes().danoAtaquePlayer(rand.nextInt(20), nomeMonstro.getText());
		Main.operacoes().atualizaInformacoesInimigo(nomeMonstro.getText(), vidaMonstro, manaMonstro);
		turnoPlayer = false;
		}
	}
	
	public void turnoInimigo() {
		if(turnoPlayer == false) {
			Main.operacoes().danoAtaqueInimigo(rand.nextInt(20));
			Main.operacoes().atualizaInformacoesPlayer(VidaPlayer, ManaPlayer);		
			turnoPlayer = true;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Main.operacoes().pegaInformaçõesPersonagem(jogador, NivelPlayer, VidaPlayer, ManaPlayer);
		
	}
}
