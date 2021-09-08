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

	public void atacar() {
		Random random = new Random();
		Main.operacoes().danoAtaque(random.nextInt(20), nomeMonstro.getText());
		Main.operacoes().atualizaInformacoes(nomeMonstro.getText(), vidaMonstro, manaMonstro);
		if (Main.operacoes().condicaoVitoria(nomeMonstro.getText()) == true)
			ganhouLuta();
	}

	public void ganhouLuta() {
		Random money = new Random();
		Random Experiencia = new Random();
		Main.operacoes().adicionaExperiencia();
		Main.operacoes().adicionaGold(money.nextInt(10));
		Main.operacoes().salvarArquivo();
		System.out.println("Ganhou");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Main.operacoes().pegaInformaçõesPersonagem(jogador, NivelPlayer, VidaPlayer, ManaPlayer);
		
	}
}
