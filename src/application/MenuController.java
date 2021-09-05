package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class MenuController implements Initializable{
    @FXML
    private AnchorPane telaMenu;
    
	public void newGame() {
	//Main.instancia().MusicBackground("create");
	Main.changeScene("novoJogo");
	}
	
	public void exit() {
	System.exit(0);
	}
	
	/*
	Metodo para tocar a musica de background da tela de titulo ela
	Chama um metodo da main para n�o ter necessidade de toda hora que chamar ela
	A classe ser instanciada, fazendo assim a musica n�o tocar. 
	*/
	
	public void music() {
		//Main.instancia().MusicBackground("main_title");
		}

	//Metodo que o programa inicia chama o metodo de music que faz a musica come�ar a tocar
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//music();
	}
}
