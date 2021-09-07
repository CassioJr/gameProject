package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CombateController {
	@FXML
	private ImageView inimigo;
	@FXML
	private ImageView jogador;

	private Stage primaryStage;
	
	public void randomizaCombate() {}
	
	public void mobMapaDragao1() {
		File file = new File("./resources/Monsters/dragon.png");
		Image image = new Image(file.toURI().toString());
		inimigo.setImage(image);
	}
	
	public void fugir(ActionEvent event) throws IOException {
		if(Main.instancia().MSGEscolha("Você deseja fugir?")==true) {
			AnchorPane fxmlespera = (AnchorPane) FXMLLoader.load(getClass().getResource("/telas/TelaEspera.fxml"));
			Scene espera = new Scene(fxmlespera);
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(espera);
		}
	}
}
