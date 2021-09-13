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

public class CombateController implements Initializable {
	@FXML
	private ImageView jogador, inimigo;
	@FXML
	private Label nomeMonstro, vidaMonstro, manaMonstro, NivelPlayer, VidaPlayer, ManaPlayer;
	private Stage primaryStage;
	private Random rand;
	private boolean turnoPlayer = true;
	private int quantiaOuro;

	//Metodo que randomiza o combate do player
	public void randomizaCombate() {
		Main.operacoes().pegaInformaçõesMonstro(inimigo, nomeMonstro, vidaMonstro, manaMonstro);
	}

	/*Metodo para iniciar o combate com o mob do dragao que esta no mapa*/
	public void mobMapaDragao1() {
		File file = new File("./resources/Monsters/dragon.png");
		Image image = new Image(file.toURI().toString());
		inimigo.setImage(image);
	}

	/*Metodo para fugir do combate caso o player opte por sim, chamando a tela de espera*/
	public void fugir(ActionEvent event) throws IOException {
		if (Main.instancia().MSGEscolha("Você deseja fugir?") == true) {
			AnchorPane fxmlespera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
			Scene espera = new Scene(fxmlespera);
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(espera);
		}
	}

	/*Metodo para fugir do combate caso o player opte por sim, chamando a tela de espera
	 *verificando se após os metodos que realizam os danos, o player ganhou ou perdeu*/
	public void atacar(ActionEvent event) throws IOException {
		turnoPlayer();
		turnoInimigo();
		if (Main.operacoes().condicaoVitoria(nomeMonstro.getText()) == true) {
			ganhouLuta();
			////Verifica se a vida do monstro desceu para 0 então o player ganheou, após é chamada a tela de vitoria
			FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaVitoria.fxml"));
			Parent root = fxmlcombate.load();
			aposController combate = fxmlcombate.getController();
			combate.colocaValores(quantiaOuro, rand.nextInt(30));
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		if(Main.operacoes().condicaoDerrota() == true) {
			//Verifica se a vida do player desceu para 0 então é chamada a tela de derrota
			FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaDerrota.fxml"));
			Parent root = fxmlcombate.load();
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
	}
	
	
	public void barraAtaque() {
		
	}

	/*Metodo que caso o player ganhou ele ira calcular o quando de experiencia e ouro que ele ira ganhar
	 *e resetar os seus atributos como vida e mana, alem de salvar no arquivo os atuais atributos do player após o combate*/
	public void ganhouLuta() {
		rand = new Random();
		quantiaOuro = rand.nextInt(10);
		Main.operacoes().adicionaExperiencia();
		Main.operacoes().adicionaGold(quantiaOuro);
		Main.operacoes().resetaAtributos();
		Main.operacoes().salvarArquivo();
		System.out.println("Ganhou");
	}

	/*Metodo que é referente ao turno do player, caso seja o turno dele
	 *ele randomiza um dano para o player que sera contabilizado na vida do monstro*/
	public void turnoPlayer() {
		if (turnoPlayer == true) {
			rand = new Random();
			Main.operacoes().danoAtaquePlayer(rand.nextInt(20), nomeMonstro.getText());
			Main.operacoes().atualizaInformacoesInimigo(nomeMonstro.getText(), vidaMonstro, manaMonstro);
			turnoPlayer = false;
		}
	}

	/*Metodo que é referente ao turno do inimigo, caso seja o turno dele
	 *ele randomiza um dano para o inimigo que sera contabilizado na vida do player*/
	public void turnoInimigo() {
		if (turnoPlayer == false) {
			Main.operacoes().danoAtaqueInimigo(rand.nextInt(20));
			Main.operacoes().atualizaInformacoesPlayer(VidaPlayer, ManaPlayer);
			turnoPlayer = true;
		}
	}

	/*Metodo quando a tela é renderizada ele chama o metodo de pegaInformaçõesPersonagem dentro da classe de operacoes*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Main.operacoes().pegaInformaçõesPersonagem(jogador, NivelPlayer, VidaPlayer, ManaPlayer);

	}
}
