package application;

import java.io.File;
import java.io.IOException;

import auxiliares.MetodosAuxiliares;
import classesEntidades.Player;
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

public class CharCreationController {
	@FXML
	private TextField campoNome;
	
	@FXML
	private ImageView classeImagem;
	
	@FXML
	private MenuButton escolherClasse;
	
	@FXML
	private MenuItem mago,arqueiro,guerreiro;
    private Stage primaryStage;
    
	public void mago() {
		escolherClasse.setText(mago.getText());
	    File file = new File("./Imagens_Classes/Mago.png");
	    Image image = new Image(file.toURI().toString());
		classeImagem.setImage(image);
	}
	
	public void arqueiro() {
		escolherClasse.setText(arqueiro.getText());
	    File file = new File("./Imagens_Classes/Arqueiro.png");
	    Image image = new Image(file.toURI().toString());
		classeImagem.setImage(image);
	}
	
	public void guerreiro() {
		escolherClasse.setText(guerreiro.getText());
	    File file = new File("./Imagens_Classes/Guerreiro.png");
	    Image image = new Image(file.toURI().toString());
		classeImagem.setImage(image);
	}
	
	public boolean validacaoCampos() {
		MetodosAuxiliares ma = new MetodosAuxiliares();
		if(campoNome.getText().isEmpty()) {
			ma.MSG("Você deve preencher o campo de nick ");
		return true;
		}
		else if (escolherClasse.getText().isEmpty()) {
			ma.MSG("Você deve escolher uma classe");
		return true;
		}
		return false;
	}
	
	public void iniciar(ActionEvent event) throws IOException {
		if (validacaoCampos()==false) {
			String nome = campoNome.getText();
			Player jogador = new Player(nome, escolherClasse.getText(), 100, 100, 20,0);
			Main.operacoes().addChar(jogador);
			AnchorPane fxmlEspera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
			Scene Espera = new Scene(fxmlEspera);
			primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(Espera);
			primaryStage.show();
		}

		
	}
	
	public void voltar(ActionEvent event) throws IOException {
		campoNome.setText("");
		escolherClasse.setText("");
		//Main.instancia().MusicBackground("main_title");
		AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
		Scene main = new Scene(fxmlmenu);
		primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(main);
		primaryStage.show();
	}

}
