package controller;

import java.io.File;
import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;
import utils.FileManagement;
import utils.Messages;
import utils.MetodosAuxiliares;

public class CharCreationController {
	@FXML
	private TextField campoNome;

	@FXML
	private ImageView classeImagem;

	@FXML
	private MenuButton escolherClasse;

	@FXML
	private MenuItem mago, arqueiro, guerreiro;
	private Stage primaryStage;

	/*Metodo que coloca a imagem da classe referente ao mago na tela de cria��o de personagens
	 * e coloca o texto do nome da classe no botao de escolha*/
	public void mago() {
		escolherClasse.setText(mago.getText());
		File file = new File("./resources/Imagens_Classes/Mago.png");
		Image image = new Image(file.toURI().toString());
		classeImagem.setImage(image);
	}

	/*Metodo que coloca a imagem da classe referente ao arqueiro na tela de cria��o de personagens
	 * e coloca o texto do nome da classe no botao de escolha*/
	public void arqueiro() {
		escolherClasse.setText(arqueiro.getText());
		File file = new File("./resources/Imagens_Classes/Arqueiro.png");
		Image image = new Image(file.toURI().toString());
		classeImagem.setImage(image);
	}

	/*Metodo que coloca a imagem da classe referente ao guerreiro na tela de cria��o de personagens
	 * e coloca o texto do nome da classe no botao de escolha*/
	public void guerreiro() {
		escolherClasse.setText(guerreiro.getText());
		File file = new File("./resources/Imagens_Classes/Guerreiro.png");
		Image image = new Image(file.toURI().toString());
		classeImagem.setImage(image);
	}
	
	/*Metodo que valida os campos para ver se o campo de nick ou escolha de classe est�o vazios
	 * na hora de realizar a cria��o de personagem*/
	public boolean validacaoCampos() {
		MetodosAuxiliares ma = new MetodosAuxiliares();
		if (campoNome.getText().isEmpty()) {
			Messages.MSG("Voc� deve preencher o campo de nick ");
			return true;
		} else if (escolherClasse.getText().isEmpty()) {
			Messages.MSG("Voc� deve escolher uma classe");
			return true;
		}
		return false;
	}

	/*Metodo que inicia o game pegando as informa��es de classe e nick que foi informado pelo player
	 * E criando assim um arquivo de save para o jogo e chamando a tela de espera*/
	public void iniciar(ActionEvent event) throws IOException {
		if (validacaoCampos() == false) {
			//Aqui se verifica se j� existe um save em andamento e � feito a pergunta se deseja sobreescrever por cima do save atual
			if (FileManagement.existSaveFile() == true) {
				if (Messages.MSGEscolha("J� existe um save, deseja criar um novo?") == true) {
					//Aqui � instanciado o objeto do player em que � inciado com 100 de vida e de mana, e com nivel 1 e 0 de ouro
					Player jogador = new Player(campoNome.getText(), escolherClasse.getText());
					Main.operacoes().addChar(jogador);
					if(Main.operacoes().salvarArquivo() == true) {
					AnchorPane fxmlEspera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
					Scene Espera = new Scene(fxmlEspera);
					primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(Espera);
					}
				}
			}else {
				if(Main.operacoes().salvarArquivo() == true) {
					Main.operacoes().salvarArquivo();
					Player jogador = new Player(campoNome.getText(), escolherClasse.getText());
					Main.operacoes().addChar(jogador);
					AnchorPane fxmlEspera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
					Scene Espera = new Scene(fxmlEspera);
					primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(Espera);
				}
			}
		}
	}

	/*Metodo que realiza a fun��o de voltar para a tela de menu*/
	public void voltar(ActionEvent event) throws IOException {
		// Main.instancia().MusicBackground("main_title");
		AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
		Scene main = new Scene(fxmlmenu);
		primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(main);
	}

}
