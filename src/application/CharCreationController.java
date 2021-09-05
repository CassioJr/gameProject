package application;

import java.io.File;

import auxiliares.MetodosAuxiliares;
import classesEntidades.Player;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharCreationController {
	@FXML
	private TextField campoNome;
	
	@FXML
	private ImageView classeImagem;
	
	@FXML
	private MenuButton escolherClasse;
	
	@FXML
	private MenuItem mago,arqueiro,guerreiro;
	
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
	
	public void iniciar() {
		if (validacaoCampos()==false) {
			String nome = campoNome.getText();
			Player jogador = new Player(nome, escolherClasse.getText(), 100, 100, 20,0);
			Main.operacoes().addChar(jogador);
			Main.changeScene("espera");
		}

		
	}
	
	public void voltar() {
		campoNome.setText("");
		escolherClasse.setText("");
		//Main.instancia().MusicBackground("main_title");
		Main.changeScene("Menu");
	}

}
