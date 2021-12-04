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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    @FXML
    private Pane barraHabilidades;
    @FXML
    private Button habilidadeDano;

	//Metodo que randomiza o combate do player
	public void randomizaCombate() {
		Main.operacoes().pegaInformacoesMonstro(inimigo, nomeMonstro, vidaMonstro, manaMonstro);
	}

	/*Metodo para iniciar o combate com o mob do dragao que esta no mapa*/
	public void mobMapaDragao1() {
		Main.operacoes().mobMapa1(inimigo, vidaMonstro, manaMonstro);
		nomeMonstro.setText("Dragão");
	}

	/*Metodo para fugir do combate caso o player opte por sim, chamando a tela de espera*/
	public void fugir(ActionEvent event) throws IOException {
		if (Main.instancia().MSGEscolha("Voc� deseja fugir?") == true) {
			AnchorPane fxmlespera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
			Scene espera = new Scene(fxmlespera);
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(espera);
		}
	}

	/*Metodo para fugir do combate caso o player opte por sim, chamando a tela de espera
	 *verificando se ap�s os metodos que realizam os danos, o player ganhou ou perdeu*/
	public void atacar(ActionEvent event) throws IOException {
		turnoPlayer();
		turnoInimigo();
		if (Main.operacoes().condicaoVitoria(nomeMonstro.getText()) == true) {
			ganhouLuta();
			////Verifica se a vida do monstro desceu para 0 ent�o o player ganheou, ap�s � chamada a tela de vitoria
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
			//Verifica se a vida do player desceu para 0 ent�o � chamada a tela de derrota
			FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaDerrota.fxml"));
			Parent root = fxmlcombate.load();
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			Main.operacoes().resetaAtributos();
		}
		
	}
	
	
	public void barraAtaque() {
		barraHabilidades.setVisible(true);
	}
	
	public void voltarBarra() {
		barraHabilidades.setVisible(false);
	}
	
	public void habilidadeDano1(ActionEvent event) throws IOException {
		Main.operacoes().danoHabilidade1(nomeMonstro.getText(), habilidadeDano);
		turnoPlayer();
		turnoInimigo();
		if (Main.operacoes().condicaoVitoria(nomeMonstro.getText()) == true) {
			ganhouLuta();
			////Verifica se a vida do monstro desceu para 0 ent�o o player ganheou, ap�s � chamada a tela de vitoria
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
			//Verifica se a vida do player desceu para 0 ent�o � chamada a tela de derrota
			FXMLLoader fxmlcombate = new FXMLLoader(getClass().getResource("/telas/TelaDerrota.fxml"));
			Parent root = fxmlcombate.load();
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			Main.operacoes().resetaAtributos();
		}
	}
	
	public void habilidadeCura(ActionEvent event) throws IOException {
		Main.operacoes().habilidadeCura();
		turnoInimigo();
	}

	/*Metodo que caso o player ganhou ele ira calcular o quando de experiencia e ouro que ele ira ganhar
	 *e resetar os seus atributos como vida e mana, alem de salvar no arquivo os atuais atributos do player ap�s o combate*/
	public void ganhouLuta() {
		rand = new Random();
		quantiaOuro = rand.nextInt(10);
		Main.operacoes().adicionaExperiencia();
		Main.operacoes().adicionaGold(quantiaOuro);
		Main.operacoes().resetaAtributos();
		Main.operacoes().salvarArquivo();
		System.out.println("Ganhou");
	}

	/*Metodo que � referente ao turno do player, caso seja o turno dele
	 *ele randomiza um dano para o player que sera contabilizado na vida do monstro*/
	public void turnoPlayer() {
		if (turnoPlayer == true) {
			rand = new Random();
			Main.operacoes().danoAtaquePlayer(rand.nextInt(20), nomeMonstro.getText());
			Main.operacoes().atualizaInformacoesInimigo(nomeMonstro.getText(), vidaMonstro, manaMonstro);
			turnoPlayer = false;
		}
	}

	/*Metodo que � referente ao turno do inimigo, caso seja o turno dele
	 *ele randomiza um dano para o inimigo que sera contabilizado na vida do player*/
	public void turnoInimigo() {
		if (turnoPlayer == false) {
			Main.operacoes().danoAtaqueInimigo(rand.nextInt(20));
			Main.operacoes().atualizaInformacoesPlayer(VidaPlayer, ManaPlayer);
			turnoPlayer = true;
		}
	}

	/*Metodo quando a tela � renderizada ele chama o metodo de pegaInforma��esPersonagem dentro da classe de operacoes*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Main.operacoes().pegaInformacoeesPersonagem(jogador, NivelPlayer, VidaPlayer, ManaPlayer);

	}
}
