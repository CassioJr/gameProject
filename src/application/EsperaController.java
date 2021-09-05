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

public class EsperaController implements Initializable{
    @FXML
    private Label nomePlayer;

    @FXML
    private Label nivelPlayer;

    @FXML
    private Label ouroPlayer;
    private Stage primaryStage;
    
    public void Informacoes() {
    	Main.operacoes().carregaInformacoes(nomePlayer, nivelPlayer, ouroPlayer);
    }
    
    public void menu(ActionEvent event) throws IOException {
		AnchorPane fxmlmenu = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaMenu.fxml"));
		Scene main = new Scene(fxmlmenu);
		primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(main);
		primaryStage.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Informacoes();
		
	}
}
